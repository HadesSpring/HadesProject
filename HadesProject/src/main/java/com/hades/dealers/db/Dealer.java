/*
 * 李先瞧
 * 2015-7-28
 *
 */

package com.hades.dealers.db;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.hades.user.db.User;


/**
 * 
 * 经销商渠道实体 
 * HadesProject
 * @author 李先瞧
 * 2015-7-28
 *
 */
@Entity(name="Dealer")
public class Dealer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7248705641757896535L;
	
	/**
	 * id主键
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 * 删除渠道经销商的时候 要级联删除用户
	 * @OneToMany(mapped=“由One的一方指向Many的一方，并且，这个属性应该等于Many的一方中含有One类的属性的属性名，否则会出错啦 ”)
	 */
	@OneToMany(mappedBy = "dealer",cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	private Set<User> users;

	
	
	/**
	 * 名称
	 */
	@Column(name="name",length=32 , unique = true,nullable = false)
	private String name;
	
	/**
	 * 创建时间
	 */
	@Column(name="createTime" , length=20 , nullable = false )
	private long createTime;
	
	/**
	 *  描述详情
	 */
	@Column(name="description" , length=255 )
	private String description;

	
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
