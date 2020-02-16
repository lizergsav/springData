package com.hold.ovk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hold.ovk.repository.TemporaryRegistrationRepository;

@RestController
public class Queries {

	@Autowired
	private TemporaryRegistrationRepository registration;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> test(){
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tempRegistration", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getTempRegistration(){
		
		return new ResponseEntity<>(registration.findAll(),HttpStatus.OK);
	}	
}
