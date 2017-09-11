package com.agile.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agile.interfaces.ServiceBeanIF;
import com.agile.interfaces.ServiceIF;

public class BaseRestController<T extends ServiceBeanIF> {

	protected ServiceIF<T> service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<T> list() {
		List<T> result;
		try {
			result = service.findAll();
//			return Response.ok(gson.toJson(result ), MediaType.APPLICATION_JSON).build();
//			return new Response(result);
			//System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
//			return Response.status(Response.Status.NOT_FOUND).build();
//			return new Response("",javax.ws.rs.core.Response.Status.NOT_FOUND.getStatusCode());
			throw e;
		}
	}
	

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response save(@RequestBody T item){
		try {
			service.save(item);
//			return Response.status(Status.CREATED).build();
			return new Response("success");
		} catch (Exception e) {
			e.printStackTrace();
//			return Response.notModified().build();
			return new Response("",404);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Response delete(@RequestBody T item){
		try {
			service.delete(item);
//			return Response.status(Status.GONE).build();
			return new Response("success");
		} catch (Exception e) {
			e.printStackTrace();
//			return Response.notModified().build();
			return new Response("",404);
		}
	}

}

//class IterationServiceBeanDeserializer implements JsonDeserializer<IterationServiceBean>{
//		
//		@Override
//		public IterationServiceBean deserialize(JsonElement json, Type arg1, JsonDeserializationContext arg2)
//				throws JsonParseException {
//			
//			return new Gson().fromJson(json, IterationServiceBean.class);
//		}
//	
//}


class Response{
	private Object entity;
	private int status = 200;
	public Response(Object entity, int status) {
		super();
		this.entity = entity;
		this.status = status;
	}
	public Response(Object entity) {
		super();
		this.entity = entity;
	}
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
