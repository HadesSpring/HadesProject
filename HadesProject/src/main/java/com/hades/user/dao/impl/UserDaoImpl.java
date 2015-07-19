package com.hades.user.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hades.user.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public boolean login(String userName, String userPwd) {
		        String hsql="from user";
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createQuery(hsql);
		        logger.info(query.list().size()+"-----------=============-----------------================");
		        System.out.println("from user");
		return false;
	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

	
	
	
	
}
