package com.training.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.training.dao.UserDao;
import com.training.entity.User;

public class UserDaoImpl implements UserDao
{

		@Autowired
		SessionFactory sessionFactory;		

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Override
		public boolean isValidUser(String username, String password) throws SQLException
		{
							
				Session session= sessionFactory.openSession();
				Query qry = session.createQuery("from User u where u.email='"+username+"'");
				User user = (User)qry.getResultList().get(0);
				session.close();
				System.out.println(user);
				
				if(user.getPassword().equals(password)){
					return true;
				} else{
					return false;
				}			
				
		}

}