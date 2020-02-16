package com.hold.ovk.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.hold.ovk")
@EnableTransactionManagement(order = Ordered.HIGHEST_PRECEDENCE)
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "com.hold.ovk.repository")
@EnableWebMvc
public class MainConfig {
	
	static final String DB_TRANSACTION_MANAGER = "dbTransactionManager";
	static final String DB_ENTITY_MANAGER_FACTORY = "dbEntityManagerFactory";
	private static final String DATABASE_PASSWORD = "database.password";
	private static final String DATABASE_USER = "database.user";
	private static final String DATABASE_DRIVER = "database.driver";
	private static final String DATABASE_URL = "database.url";
	private static final String HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String LOCATION_ENTITY = "com.hold.ovk.domain";
	private static final String HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	
	@Autowired
	public Environment env;
	
	@Bean(destroyMethod = "close")
	DataSource dataSource(Environment env) {
		final HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getRequiredProperty(DATABASE_DRIVER));
		dataSourceConfig.setJdbcUrl(env.getRequiredProperty(DATABASE_URL));
		dataSourceConfig.setUsername(env.getRequiredProperty(DATABASE_USER));
		dataSourceConfig.setPassword(env.getRequiredProperty(DATABASE_PASSWORD));
		dataSourceConfig.setAutoCommit(true);

		System.out.println("Database URL is "+ env.getRequiredProperty(DATABASE_URL));
		
		return new HikariDataSource(dataSourceConfig);
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(LOCATION_ENTITY);

		final Properties jpaProperties = new Properties();
		jpaProperties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
		//jpaProperties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
		//jpaProperties.put(COMMON_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(COMMON_HIBERNATE_FORMAT_SQL));
		jpaProperties.put(HIBERNATE_HBM2DDL,env.getRequiredProperty(HIBERNATE_HBM2DDL));
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
