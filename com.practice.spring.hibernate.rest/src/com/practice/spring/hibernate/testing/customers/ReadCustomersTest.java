package com.practice.spring.hibernate.testing.customers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Customers;
import com.practice.spring.hibernate.rest.dao.CustomersDAO;


public class ReadCustomersTest {
	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		CustomersDAO dao = (CustomersDAO) factory.getBean("cust");

		List<Customers> c = new ArrayList<Customers>();
		c = dao.getCustomers();
		System.out.println(c);
	}

}