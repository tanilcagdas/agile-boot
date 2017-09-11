package com.agile.rest.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.agile.beans.servicebean.UserServiceBean;
import com.agile.interfaces.UserServiceIF;


//@Component
//@Path("user")
@RestController
@RequestMapping(value = "/webresources/user" , produces= "application/json")
public class UserRestController extends BaseRestController<UserServiceBean>{
	
	@Autowired
	private UserServiceIF service;

	
	@PostConstruct
	public void init(){
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.service = this.service;
	}
}
