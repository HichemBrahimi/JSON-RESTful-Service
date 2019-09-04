package com.topten.webservices.rest.jersey;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/customers")
public class CustomersResource {

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	CustomerService customerService;

	public CustomersResource() {
		customerService = new CustomerService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Customer> getCustumers() {
		return customerService.getCustomerAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Customer> getCustumersAsHtml() {
		return customerService.getCustomerAsList();
	}

	// URI: /rest/customers/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(customerService.getCustomersCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createCustomer(@FormParam("id") String id,
			@FormParam("customerfirstName") String firstName,
			@FormParam("customerlastName") String lastName,
			@FormParam("customerphoneNumber") String phoneNumber,
			@FormParam("customeremail") String email,
			@FormParam("customeadresse") List<Adresse> adresse,
			@Context HttpServletResponse servletResponse) throws IOException {
		Customer customer = new Customer(id, firstName, lastName,phoneNumber,email,adresse);
		customerService.createCustomer(customer);
		servletResponse.sendRedirect("./customers/");
	}

	@Path("{customer}")
	public CustomerResource getCustomer(@PathParam("customer") String id) {
		return new CustomerResource(uriInfo, request, id);
	}

}