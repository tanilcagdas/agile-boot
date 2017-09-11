package com.agile.rest.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.agile.beans.servicebean.IterationServiceBean;
import com.agile.interfaces.IterationServiceIF;


//@Component
//@Path("webresources/iteration")
@RestController
@RequestMapping(value = "/webresources/iteration" , produces= "application/json")
public class IterationRestController extends BaseRestController<IterationServiceBean>{
	
	@Autowired
	IterationServiceIF service;

	@PostConstruct
	public void init(){
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		super.service = this.service;
	}
	
//	@GET
//    @Path("/list")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response list() {
//		List<IterationServiceBean> result;
//		try {
//			result = service.findAll();
//			return Response.ok(new Gson().toJson(result ), MediaType.APPLICATION_JSON).build();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return Response.status(Response.Status.NOT_FOUND).build();
//		}
//	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//		public Response list() {
//			List<IterationServiceBean> result;
//			try {
//				result = service.findAll();
//				return Response.ok(new Gson().toJson(result ), MediaType.APPLICATION_JSON).build();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return Response.status(Response.Status.NOT_FOUND).build();
//			}
//		}
}
