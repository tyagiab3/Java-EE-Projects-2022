package com.practice.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.CustomerDAO;
import com.practice.pojo.*;

@RestController
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private CustomerDAO service;

	@GetMapping("/getCustomers")
	public List<Customers> getCustomers() {
		return service.findAll();
	}

	@PostMapping("/createCustomer")
	public String setCustomer(@RequestBody Customers c) {
		service.save(c);
		return "saved";
	}

	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody Customers c) {
		service.save(c);
		return "updated";
	}

	@DeleteMapping("/deleteCustomer")
	public String deleteCustomer(@RequestBody Customers c) {
		service.delete(c);
		return "deleted";
	}

	@DeleteMapping("/deleteCustomerByID/{id}")
	public String deleteByID(@PathVariable Integer id) {
		service.deleteById(id);
		return "deleted";
	}
}
