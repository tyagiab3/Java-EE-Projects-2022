package com.practice.spring.hibernate.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.practice.spring.hibernate.rest.classes.Customers;


public class CustomersDAO {
	HibernateTemplate template;
	
	@Autowired
	private HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	public void setCustomer(Customers c) {
		TransactionStatus transaction = openTrans();
		template.save(c);
		closeTrans(transaction);
	}
	public void updateCustomer(Customers c) {
		TransactionStatus transaction = openTrans();
		template.update(c);
		closeTrans(transaction);
	}
	public void deleteCustomer(Customers c) {
		TransactionStatus transaction = openTrans();
		template.delete(c);
		closeTrans(transaction);
	}
	public Customers getByID(int id) {
		Customers c = (Customers) template.get(Customers.class, id);
		return c;
	}
	public List<Customers> getCustomers(){
		List<Customers> list = new ArrayList<Customers>();
		list = template.loadAll(Customers.class);
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
