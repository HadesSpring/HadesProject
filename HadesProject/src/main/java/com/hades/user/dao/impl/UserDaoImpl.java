package com.hades.user.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.hades.framework.core.dao.impl.HadesBaseDaoSupport;
import com.hades.framework.core.model.Page;
import com.hades.user.dao.IUserDao;
import com.hades.user.db.User;

public class UserDaoImpl extends HadesBaseDaoSupport<User,Long> implements IUserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	
	
	@Override
	public boolean save(String userName, String userPwd) {
		        User user = new User();
		        user.setUserName("小李"+Math.random()*5);
		        user.setUserPwd("aaaa");
		        Long id = this.save(user);
		        logger.info("from user"+id);
		return false;
	}



	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> list =  this.queryAll(User.class);
		   logger.info("from user"+list.size());
		return list;
	}

	
	public Page<User> queryByPage(final Page<User> page,final Object... values) {
		String where = " where UserPwd = ?";
	 String hql = "from User "+ where;
	   page.setTotalCount( this.queryTotalCount(User.class, where, values));
		return this.queryByPage(page, hql, values);
		
	}


	

	
	
	
	
}
