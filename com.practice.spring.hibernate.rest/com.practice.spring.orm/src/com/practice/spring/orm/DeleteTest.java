package com.practice.spring.orm;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeleteTest {

	public static void main(String[] args) {
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(r);

		EmployeeDao dao = (EmployeeDao) factory.getBean("emp");

		Employee e = new Employee();
		e.setId(114);
		e.setName("varun");
		e.setSalary(60000);

		dao.deleteEmployee(e);;
	}

}
