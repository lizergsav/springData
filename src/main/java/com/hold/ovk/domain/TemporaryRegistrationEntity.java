package com.hold.ovk.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "temporary_registration")
public class TemporaryRegistrationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 40,nullable = false)
	private long id;
	
	@Column(name = "username", nullable = false, length = 255)
	private String userName;
		
	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "phone_number", nullable = false, length = 255)
	private String phoneNumber;
	
	@Column(name = "sms_code", nullable = false, length = 255)
	private String smsCode;
	
	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "sms_code_generated_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date smsCodeGeneratedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getSmsCodeGeneratedAt() {
		return smsCodeGeneratedAt;
	}

	public void setSmsCodeGeneratedAt(Date smsCodeGeneratedAt) {
		this.smsCodeGeneratedAt = smsCodeGeneratedAt;
	}
	
}
