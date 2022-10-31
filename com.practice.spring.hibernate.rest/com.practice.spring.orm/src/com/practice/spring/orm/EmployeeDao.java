package com.practice.spring.orm;

import org.hibernate.FlushMode;
import org.hibernate.Transaction;
import org.springframework.transaction.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.*;

@Transactional
public class EmployeeDao {
	HibernateTemplate template;
	
	@Autowired
	private HibernateTransactionManager transactionManager = new HibernateTransactionManager();

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void saveEmployee(Employee e) {
		TransactionStatus transaction = openTrans();
		template.save(e);
		closeTrans(transaction);
	}


	public void updateEmployee(Employee e) {
		TransactionStatus transaction = openTrans();
		template.update(e);
		closeTrans(transaction);
	}

	public void deleteEmployee(Employee e) {
		TransactionStatus transaction = openTrans();
		template.delete(e);
		closeTrans(transaction);
	}

	public Employee getByID(int id) {
		Employee e = (Employee) template.get(Employee.class, id);
		return e;
	}

	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		list = template.loadAll(Employee.class);
		return list;
	}
	
	public TransactionStatus openTrans() {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		transactionManager.setSessionFactory(this.template.getSessionFactory());
		TransactionStatus transaction = transactionManager.getTransaction(definition);
		this.template.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
		return transaction;
	}
	public void closeTrans(TransactionStatus transaction) {
		transactionManager.commit(transaction);
	}
}
