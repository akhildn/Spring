package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.AgentDao;
import com.training.dao.CustomerDao;
import com.training.entity.Agent;
import com.training.entity.Customer;
import com.training.service.AgentService;
import com.training.service.CustomerService;


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
