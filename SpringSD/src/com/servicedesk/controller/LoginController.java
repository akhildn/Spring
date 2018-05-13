package com.servicedesk.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.servicedesk.service.AgentService;
import com.servicedesk.service.CustomerService;
import com.servicedesk.viewmodel.LoginBean;



@Controller
public class LoginController
{		
		
		@Autowired
		private CustomerService customerService;
		
		@Autowired
		private AgentService agentService;

		@RequestMapping(value="/",method=RequestMethod.GET)
		public String index()
		{
			
			return "index";
		}
		
		@RequestMapping(value="/loginPage",method=RequestMethod.GET)
		public ModelAndView displayLoginPage(LoginBean loginBean)
		{
			ModelAndView model = new ModelAndView("login");			
			model.addObject("loginBean", loginBean);
			return model;
		}
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView executeLogin(@ModelAttribute("loginBean") LoginBean loginBean, HttpSession session)
		{
				ModelAndView model= null;				
				System.out.println("Username: "+loginBean.getUsername()+"\nPassword: "+loginBean.getPassword()+"\nUser Type: "+loginBean.getUserType());
				String userType = loginBean.getUserType();
				try
				{
					boolean isValidUser = false;
					
					if(userType.equals("admin")){
						if(loginBean.getUsername().equals("admin") && loginBean.getPassword().equals("admin")){
							isValidUser = true;
						}
					} else if(userType.equals("customer")){
						isValidUser = customerService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
					} else if(userType.equals("agent")){
						isValidUser = agentService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
					}
					
					if(isValidUser)
					{
							System.out.println("User Login Successful");
							model = new ModelAndView("home");							
							session.setAttribute("username", loginBean.getUsername());
							session.setAttribute("userType", userType);
					}
					else
					{
							model = new ModelAndView("login");								
							model.addObject("message", "Invalid credentials!!");							
					}

				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return model;
		}
		
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public ModelAndView logout(LoginBean loginBean, HttpSession session)
		{
			session.invalidate();
			ModelAndView model = new ModelAndView("login");			
			model.addObject("loginBean", loginBean);
			return model;
		}
}
