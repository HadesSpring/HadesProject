package com.hades.user.service.impl;

import com.hades.user.dao.IUserDao;
import com.hades.user.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	@Override
	public boolean login(String userName, String userPwd) {
		// TODO Auto-generated method stub
		userDao.login(userName, userPwd);
		return false;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
