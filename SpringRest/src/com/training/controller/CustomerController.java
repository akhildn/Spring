package com.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.entity.Customer;
import com.training.service.CustomerService;

@Controller
public class CustomerController
{			
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value="/customers",method=RequestMethod.GET)
	@ResponseBody public List<Customer> getCustomers(HttpServletResponse response)
	{
		response.addHeader("Access-Control-Allow-Origin", "*");
		return customerService.listCustomers();		
	}
	
	@RequestMapping(value="/customer/{id}",method=RequestMethod.GET)
	@ResponseBody public Customer getCustomer(@PathVariable int id)
	{
		return customerService.getCustomer(id);		
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	@ResponseBody public Customer addCustomer(@RequestBody Customer customer)
	{
		customerService.addCustomer(customer);
		return customer;
	}
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	@ResponseBody public Customer updateCustomer(@RequestBody Customer customer)
	{
		customerService.updateCustomer(customer);
		
		return customer;
	}
	
	@RequestMapping(value="/deleteCustomer/{id}",method=RequestMethod.GET)
	public Customer deleteCustomer(@PathVariable int id)
	{
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(id);
		return customer;
	}
	
	@RequestMapping(value="/searchCustomers/{search}",method=RequestMethod.GET)
	public List<Customer> searchCustomers(@PathVariable String search)
	{		
		return customerService.searchCustomers(search);	 
		
	}
		
}
