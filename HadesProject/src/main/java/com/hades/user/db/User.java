package com.hades.user.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655896053549552871L;
    
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 * 用户名
	 */
	@Column(name="userName",length=32 , unique = true,nullable = false)
	private String userName;
	
	/**
	 * 密码
	 */
	@Column(name="userPwd",length=32,nullable = true)
	private String userPwd;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
	
	
	
}
