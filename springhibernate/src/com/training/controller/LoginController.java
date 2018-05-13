package com.training.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.service.UserService;
import com.training.viewmodel.LoginBean;
import com.training.viewmodel.UserValidator;


@Controller
public class LoginController
{
		@Autowired
		UserValidator validator;
		
		@Autowired
		private UserService userService;
		
		
		
		public UserValidator getValidator() {
			return validator;
		}
		public void setValidator(UserValidator validator) {
			this.validator = validator;
		}
		
		public UserService getUserService() {
			return userService;
		}
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		@RequestMapping(value="/",method=RequestMethod.GET)
		public ModelAndView displayLogin(LoginBean loginBean)
		{
			ModelAndView model = new ModelAndView("login");			
			model.addObject("loginBean", loginBean);
			return model;
		}
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView executeLogin(@Valid @ModelAttribute("loginBean") LoginBean loginBean, BindingResult result)
		{
				ModelAndView model= null;
				validator.validate(loginBean, result);
				if(result.hasErrors()){
					System.out.println("Validation Errors");
					return new ModelAndView("login");
				}
				try
				{
					boolean isValidUser = false;
						isValidUser = userService.isValidUser(loginBean.getUsername(), loginBean.getPassword());
						if(isValidUser)
						{
								System.out.println("User Login Successful");
								model = new ModelAndView("welcome");
								model.addObject("loggedInUser", loginBean.getUsername());
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
}
