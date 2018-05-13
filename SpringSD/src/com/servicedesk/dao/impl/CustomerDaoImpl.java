package com.servicedesk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.servicedesk.dao.CustomerDao;
import com.servicedesk.entity.Customer;

@Repository
public class CustomerDaoImpl extends DaoImpl implements CustomerDao
{	

	@Override
	public Customer findCustomerByUsername(String username){
		Session session= sessionFactory.openSession();
		Query qry = session.createQuery("from Customer c where c.username='"+username+"'");
		Customer customer = (Customer)qry.getResultList().get(0);
		session.close();			
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		Session session= sessionFactory.openSession();
		Query qry = session.createQuery("from Customer");
		List<Customer> customers = (List<Customer>)qry.getResultList();
		session.close();			
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session= sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(customer);
		t.commit();
		session.close();		
	}

	@Override
	public Customer findCustomerById(int id) {
		Session session= sessionFactory.openSession();
		Query qry = session.createQuery("from Customer c where c.id="+id);
		Customer customer = (Customer)qry.getResultList().get(0);
		session.close();			
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session= sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.update(customer);
		t.commit();
		session.close();
	}

	@Override
	public void deleteCustomer(int id) {
		Session session= sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Query qry = session.createQuery("delete from Customer c where c.id="+id);
		qry.executeUpdate();
		t.commit();
		session.close();	
	}

	@Override
	public List<Customer> findCustomers(String search) {
		Session session= sessionFactory.openSession();
		Query qry = session.createQuery("from Customer c where upper(c.username) like'%"+search.toUpperCase()+"%'");
		List<Customer> customers = (List<Customer>)qry.getResultList();
		session.close();			
		return customers;
	}		

}