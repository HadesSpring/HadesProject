package com.hades.user.service.impl;

import java.util.List;

import com.hades.user.dao.IUserDao;
import com.hades.user.db.User;
import com.hades.user.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	@Override
	public boolean save(String userName, String userPwd) {
		// TODO Auto-generated method stub
		userDao.save(userName, userPwd);
		return false;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		return userDao.queryAllUser();
	}

}
