package com.hades.user.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="User" )
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
	@Column(name="userPwd",length=32,nullable = false)
	private String userPwd;
	
	/**
	 * 创建时间
	 */
	@Column(name="createTime" , length=20 , nullable = false )
	private long createTime;
	
	/**
	 * 来往邮件
	 */
	@Column(name="email" , length=32 , nullable = false )
	private String email;
	

	/**
	 * 联系电话
	 */
	@Column(name="phone" , length=20 , nullable = false )
	private String phone;
	
	/**
	 * 联系电话
	 */
	@Column(name="address" , length=255 , nullable = false )
	private String address;
	
	
	
	
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
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
