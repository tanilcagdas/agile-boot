package com.agile.rest.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.agile.beans.servicebean.UserStoryServiceBean;
import com.agile.interfaces.UserStoryServiceIF;


//@Component
//@Path("userstory")
@RestController
@RequestMapping(value = "/webresources/userstory" , produces= "application/json")
//@CrossOrigin
public class UserStoryRestController extends BaseRestController<UserStoryServiceBean>{
	
	@Autowired
	private UserStoryServiceIF service;
	
	@PostConstruct
	public void init(){
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.service = this.service;
	}
}
