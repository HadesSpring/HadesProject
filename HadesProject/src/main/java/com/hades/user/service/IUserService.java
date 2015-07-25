package com.hades.user.service;

import java.util.List;

import com.hades.framework.core.model.Page;
import com.hades.user.db.User;

public interface IUserService {

	public boolean save(String userName , String userPwd);
	public List<User> queryAllUser();
	public Page<User> queryByPage(final Page<User> page,final Object... values) ;
}
