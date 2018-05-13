package com.servicedesk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.servicedesk.dao.CustomerDao;
import com.servicedesk.entity.Customer;
import com.servicedesk.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public boolean isValidUser(String username, String password)
	{
		Customer customer = customerDao.findCustomerByUsername(username);
		
		if(password.equals(customer.getPassword())){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Customer> listCustomers() {
		
		return customerDao.findAllCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);		
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDao.findCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
		
	}

	@Override
	public List<Customer> searchCustomers(String search) {
		return customerDao.findCustomers(search);
	}

}
