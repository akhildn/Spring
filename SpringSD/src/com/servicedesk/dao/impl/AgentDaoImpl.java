package com.servicedesk.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.servicedesk.dao.AgentDao;
import com.servicedesk.dao.CustomerDao;
import com.servicedesk.entity.Agent;
import com.servicedesk.entity.Customer;

@Repository
public class AgentDaoImpl extends DaoImpl implements AgentDao
{	

	@Override
	public Agent findAgentByUsername(String username){
		Session session= sessionFactory.openSession();
		Query qry = session.createQuery("from Agent a where a.username='"+username+"'");
		Agent agent = (Agent)qry.getResultList().get(0);
		session.close();			
		return agent;
	}		

}