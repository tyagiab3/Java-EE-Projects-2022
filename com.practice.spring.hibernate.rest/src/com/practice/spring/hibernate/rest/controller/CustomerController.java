package com.practice.spring.hibernate.rest.controller;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.practice.spring.hibernate.rest.service.CustomerService;
import com.practice.spring.hibernate.rest.classes.Customers;
import com.practice.spring.hibernate.rest.dao.CustomersDAO;

@Path("customers")
public class CustomerController {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Customers> getCustomer() {
		CustomerService cs = new CustomerService();
		return cs.getCustomers();
	}
	
	@POST
	@Consumes
	public void setCustomer(Customers c) {
		CustomersDAO dao = CustomerService.resource();
		dao.setCustomer(c);
	}

	@DELETE
	public String deleteCustomer(Customers c) {
		CustomersDAO dao = CustomerService.resource();
		dao.deleteCustomer(c);
		return c.toString() + " DELETED!";
	}
	
	@PUT
	public String updateCustomer(Customers c) {
		CustomersDAO dao = CustomerService.resource();
		dao.updateCustomer(c);
		return c.toString() + " UPDATED!";
	}

}
