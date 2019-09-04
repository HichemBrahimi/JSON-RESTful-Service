package com.topten.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class CustomerResource {

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	String id;

	CustomerService customerService;

	public CustomerResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		customerService = new CustomerService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Customer getCustomer() {
		Customer customer = customerService.getCustomer(id);
		return customer;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Customer getCustomerAsHtml() {
		Customer customer = customerService.getCustomer(id);
		return customer;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCustomer(JAXBElement<Customer> custumerElement) {
		Customer customer = custumerElement.getValue();
		Response response;
		if (customerService.getCustomers().containsKey(customer.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		customerService.createCustomer(customer);
		return response;
	}

	@DELETE
	public void deleteCustomer() {
		customerService.deleteCustomer(id);
	}

}