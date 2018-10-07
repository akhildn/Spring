package com.training.dao;

import java.util.List;

import com.training.entity.Customer;


public interface CustomerDao
{
	public Customer findCustomerByUsername(String username);

	public List<Customer> findAllCustomers();

	public void addCustomer(Customer customer);

	public Customer findCustomerById(int id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);

	public List<Customer> findCustomers(String search);
}
