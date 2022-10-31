package com.practice.spring.hibernate.rest.service;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Staffs;
import com.practice.spring.hibernate.rest.dao.StaffsDAO;

public class StaffService {
	public List<Staffs> getStaffs() {
		StaffsDAO dao = StaffService.resource();
		return dao.getStaffs();
	}

	public String setStaff(Staffs s) {
		StaffsDAO dao = StaffService.resource();
		dao.setStaff(s);
		return s.toString() + " SET!";
	}

	public String deleteStaff(Staffs s) {
		StaffsDAO dao = StaffService.resource();
		dao.deleteStaff(s);
		return s.toString() + " DELETED!";
	}

	public String updateStaff(Staffs s) {
		StaffsDAO dao = StaffService.resource();
		dao.updateStaff(s);
		return s.toString() + " UPDATED!";
	}

	public static StaffsDAO resource() {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		StaffsDAO dao = (StaffsDAO) factory.getBean("staff");
		return dao;
	}
}
