package com.training.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.training.service.AgentService;
import com.training.service.CustomerService;
import com.training.viewmodel.LoginBean;



@Controller
public class LoginController
{		
		
		@Autowired
		private CustomerService customerService;
		
		@Autowired
		private AgentService agentService;

		@RequestMapping("/")
		public String index() {
	 
			return "index";
			
		}		
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
		@ResponseBody  public boolean executeLogin(@RequestBody LoginBean loginBean)
		{
				String userType = loginBean.getUserType();
				boolean isValidUser = false;
				try
				{
					
					
					if(userType.equals("admin")){
						if(loginBean.getUsername().equals("admin") && loginBean.getPassword().equals("admin")){
							isValidUser = true;
						}
					} else if(userType.equals("customer")){
						isValidUser = customerService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
					} else if(userType.equals("agent")){
						isValidUser = agentService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
					}
					
					

				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return isValidUser;
		}
		
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		@ResponseBody public boolean logout(HttpSession session)
		{
			System.out.println("Invalidating the session...");
			session.invalidate();
			return true;
		}
}
