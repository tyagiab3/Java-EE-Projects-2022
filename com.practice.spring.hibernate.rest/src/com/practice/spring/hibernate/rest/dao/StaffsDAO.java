package com.practice.spring.hibernate.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.practice.spring.hibernate.rest.classes.Staffs;

public class StaffsDAO {
	HibernateTemplate template;

	@Autowired
	private HibernateTransactionManager transactionManager = new HibernateTransactionManager();

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public void setStaff(Staffs s) {
		TransactionStatus transaction = openTrans();
		template.save(s);
		closeTrans(transaction);
	}

	public void updateStaff(Staffs s) {
		TransactionStatus transaction = openTrans();
		template.update(s);
		closeTrans(transaction);
	}

	public void deleteStaff(Staffs s) {
		TransactionStatus transaction = openTrans();
		template.delete(s);
		closeTrans(transaction);
	}

	public Staffs getByID(int id) {
		Staffs s = (Staffs) template.get(Staffs.class, id);
		return s;
	}

	public List<Staffs> getStaffs() {
		List<Staffs> list = new ArrayList<Staffs>();
		list = template.loadAll(Staffs.class);
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
