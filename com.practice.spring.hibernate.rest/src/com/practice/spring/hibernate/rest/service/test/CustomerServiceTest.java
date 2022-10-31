package com.practice.spring.hibernate.rest.service.test;

import java.util.List;

import com.practice.spring.hibernate.rest.classes.Customers;
import com.practice.spring.hibernate.rest.service.CustomerService;

public class CustomerServiceTest {

	public static void main(String[] args) {
		CustomerService cs = new CustomerService();
		List<Customers> c = cs.getCustomers();
		System.out.println(c);
	}

}
