package com.hades.user.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hades.dealers.db.Dealer;

/**
 * 用户实体类 , 附属于经销商下 , 每个经销商可以有多个用户
 * HadesProject
 * @author 李先瞧
 * 2015-7-30
 *
 */
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
	 * CascadeType.PERSIST只有A类新增时，会级联B对象新增。若B对象在数据库存（跟新）在则抛异常（让B变为持久态） 
       CascadeType.MERGE指A类新增或者变化，会级联B对象（新增或者变化） 
       CascadeType.REMOVE只有A类删除时，会级联删除B类； 
       CascadeType.ALL包含所有； 
       CascadeType.REFRESH没用过。 
                  综上：大多数情况用CascadeType.MERGE就能达到级联跟新又不报错，用CascadeType.ALL时要斟酌下CascadeType.REMOVE
	  //optional=true表示该对象(Order)是可选的，对象(Order)可以不存在
      //值为false表示不可选即该对象(Order)必须存在，则在数据库中的外键就不能为null）
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dealerId")
	private Dealer dealer;
	
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
	
	
	
	
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
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
