package com.servicedesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.servicedesk.entity.Customer;
import com.servicedesk.service.CustomerService;

@Controller
public class CustomerController
{			
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value="/listCustomers",method=RequestMethod.GET)
	public ModelAndView listCustomers()
	{
		ModelAndView model = new ModelAndView("customers");
		List<Customer> customers = customerService.listCustomers();
		model.addObject("customers", customers);
		return model;
	}
	
	@RequestMapping(value="/addCustomerPage",method=RequestMethod.GET)
	public ModelAndView addCustomerPage(Customer customer)
	{
		ModelAndView model = new ModelAndView("addCustomer");		
		model.addObject("customer", customer);
		return model;
	}
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer)
	{
		ModelAndView model = new ModelAndView("customers");
		customerService.addCustomer(customer);
		List<Customer> customers = customerService.listCustomers();
		model.addObject("customers", customers);
		return model;
	}
	
	@RequestMapping(value="/editCustomer",method=RequestMethod.GET)
	public ModelAndView editCustomerPage(@RequestParam String id)
	{
		ModelAndView model = new ModelAndView("editCustomer");
		Customer customer = customerService.getCustomer(Integer.parseInt(id));
		model.addObject("customer", customer);
		return model;
	}
	
	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer)
	{
		ModelAndView model = new ModelAndView("customers");
		customerService.updateCustomer(customer);
		List<Customer> customers = customerService.listCustomers();
		model.addObject("customers", customers);
		return model;
	}
	
	@RequestMapping(value="/deleteCustomer",method=RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam String id)
	{
		ModelAndView model = new ModelAndView("customers");
		customerService.deleteCustomer(Integer.parseInt(id));
		List<Customer> customers = customerService.listCustomers();
		model.addObject("customers", customers);
		return model;
	}
	
	@RequestMapping(value="/searchCustomers",method=RequestMethod.POST)
	public ModelAndView searchCustomers(@RequestParam String search)
	{
		ModelAndView model = new ModelAndView("customers");
		List<Customer> customers = customerService.searchCustomers(search);		 
		model.addObject("customers", customers);
		return model;
	}
		
}
