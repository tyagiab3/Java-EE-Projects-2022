package com.practice.spring.hibernate.testing.customers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Customers;
import com.practice.spring.hibernate.rest.dao.CustomersDAO;

public class UpdateCustomersTest {
	public static void main(String[] a) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		CustomersDAO dao = (CustomersDAO) factory.getBean("cust");

		Customers c = new Customers(11, "Abhi", "Tyagi", null, "tyagi.ab2001@gmail.com", "172 Eculid Ave.", "Toronto",
				"ON", "00001");
		dao.updateCustomer(c);
	}
}
