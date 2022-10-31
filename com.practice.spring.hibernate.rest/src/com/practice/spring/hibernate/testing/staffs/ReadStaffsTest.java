package com.practice.spring.hibernate.testing.staffs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Customers;
import com.practice.spring.hibernate.rest.classes.Staffs;
import com.practice.spring.hibernate.rest.dao.CustomersDAO;
import com.practice.spring.hibernate.rest.dao.StaffsDAO;

public class ReadStaffsTest {
	public static void main(String[] args) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		StaffsDAO dao = (StaffsDAO) factory.getBean("staff");

		List<Staffs> c = new ArrayList<Staffs>();
		c = dao.getStaffs();
		System.out.println(c);

	}
}
