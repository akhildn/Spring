package com.servicedesk.dao;

import com.servicedesk.entity.Agent;

public interface AgentDao
{
	public Agent findAgentByUsername(String username);
}
