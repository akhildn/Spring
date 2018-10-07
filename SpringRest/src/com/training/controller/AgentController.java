package com.training.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.service.AgentService;

@Controller
public class AgentController
{			
	@Autowired
	private AgentService agentService;
	
	
	@RequestMapping(value="/getAgent",method=RequestMethod.GET)
	public String index()
	{
		
		return "index";
	}		
		
}
