
package com.training.service;

import java.util.List;

import com.training.entity.Customer;

public interface CustomerService
{
	public boolean isValidUser(String username, String password);

	public List<Customer> listCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomers(String search);
}
