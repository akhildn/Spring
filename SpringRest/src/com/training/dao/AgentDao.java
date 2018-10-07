package com.training.dao;

import com.training.entity.Agent;

public interface AgentDao
{
	public Agent findAgentByUsername(String username);
}
