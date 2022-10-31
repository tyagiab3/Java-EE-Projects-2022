package com.practice.spring.hibernate.testing.staffs;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.practice.spring.hibernate.rest.classes.Staffs;
import com.practice.spring.hibernate.rest.dao.StaffsDAO;

public class DeleteStaffsTest {

	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		int id = 11;

		StaffsDAO dao = (StaffsDAO) factory.getBean("staff");

		Staffs s = dao.getByID(id);
		dao.deleteStaff(s);
	}

}
