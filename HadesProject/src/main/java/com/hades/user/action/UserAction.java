package com.hades.user.action;


import org.apache.log4j.Logger;

import com.hades.framework.core.model.Page;
import com.hades.user.db.User;
import com.hades.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 测试类
 * @author qiao
 *
 */
public class UserAction extends ActionSupport {

	private User userModel ;
	
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
		Page<User> page = new Page<User>();
		page.setPageNo(1);
		page.setPageSize(3);
		String[] values = new String[]{"aaaa"};
		page = userService.queryByPage(page, values);
		logger.info("count total = "+ page.getTotalCount());
		logger.info("count pages = "+ page.getTotalPages());
		return SUCCESS;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public User getUserModel() {
		return userModel;
	}
	public void setUserModel(User userModel) {
		this.userModel = userModel;
	}
	
	
	
	

	
	
	
	
	
}
