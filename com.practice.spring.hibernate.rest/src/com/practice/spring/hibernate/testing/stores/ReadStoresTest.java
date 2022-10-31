package com.practice.spring.hibernate.testing.stores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Stores;
import com.practice.spring.hibernate.rest.dao.StoresDAO;

public class ReadStoresTest {

	public static void main(String[] args) {

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		StoresDAO dao = (StoresDAO) factory.getBean("store");

		List<Stores> c = new ArrayList<Stores>();
		c = dao.getStores();
		System.out.println(c);

	}

}
