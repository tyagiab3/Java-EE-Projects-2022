package com.practice.spring.hibernate.rest.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Customers;
import com.practice.spring.hibernate.rest.dao.CustomersDAO;

public class CustomerService {
	public List<Customers> getCustomers() {
		CustomersDAO dao = CustomerService.resource();
		return dao.getCustomers();
	}

	public String setCustomer(Customers c) {
		CustomersDAO dao = CustomerService.resource();
		dao.setCustomer(c);
		return c.toString()+" SET!";
	}

	public String deleteCustomer(Customers c) {
		CustomersDAO dao = CustomerService.resource();
		dao.deleteCustomer(c);
		return c.toString()+" DELETED!";
	}
	
	public String updateCustomer(Customers c) {
		CustomersDAO dao = CustomerService.resource();
		dao.updateCustomer(c);
		return c.toString()+" UPDATED!";
	}

	public static CustomersDAO resource() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		CustomersDAO dao = (CustomersDAO) factory.getBean("cust");
		return dao;
	}
}
