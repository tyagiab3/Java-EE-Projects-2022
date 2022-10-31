package com.practice.spring.hibernate.rest.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Stores;
import com.practice.spring.hibernate.rest.dao.StoresDAO;

public class StoreService {
	public List<Stores> getStores() {
		StoresDAO dao = StoreService.resource();
		return dao.getStores();
	}

	public String setStore(Stores s) {
		StoresDAO dao = StoreService.resource();
		dao.setStore(s);
		return s.toString() + " SET!";
	}

	public String deleteStore(Stores s) {
		StoresDAO dao = StoreService.resource();
		dao.deleteStore(s);
		return s.toString() + " DELETED!";
	}

	public String updateStore(Stores s) {
		StoresDAO dao = StoreService.resource();
		dao.updateStore(s);
		return s.toString() + " UPDATED!";
	}

	public static StoresDAO resource() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		StoresDAO dao = (StoresDAO) factory.getBean("store");
		return dao;
	}
}