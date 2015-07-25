package com.hades.user.action;


import org.apache.log4j.Logger;

import com.hades.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 测试类
 * @author qiao
 *
 */
public class UserAction extends ActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6279522404420788267L;
	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private IUserService userService;
	public String login(){
		logger.info("登陆成功!");
		userService.save("1", "2");
		userService.queryAllUser();
		return SUCCESS;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	
	

	
	
	
	
	
}
