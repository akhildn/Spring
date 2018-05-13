package com.servicedesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicedesk.dao.AgentDao;
import com.servicedesk.dao.CustomerDao;
import com.servicedesk.entity.Agent;
import com.servicedesk.entity.Customer;
import com.servicedesk.service.AgentService;
import com.servicedesk.service.CustomerService;


@Service
public class AgentServiceImpl implements AgentService
{
	@Autowired
	private AgentDao agentDao;
	
	@Override
	public boolean isValidUser(String username, String password)
	{
		Agent agent = agentDao.findAgentByUsername(username);
		
		if(password.equals(agent.getPassword())){
			return true;
		} else {
			return false;
		}
	}

}
