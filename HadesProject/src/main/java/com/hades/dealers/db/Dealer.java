/*
 * 李先瞧
 * 2015-7-28
 *
 */

package com.hades.dealers.db;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.hades.records.area.db.Area;
import com.hades.user.db.User;


/**
 * 
 * 经销商渠道实体 
 * 渠道经销商  自关联
 * 渠道经销商 一旦创建不能删除 , 只提供修改
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
	 * 与用户双向一对多关联
	 * 删除渠道经销商的时候 要级联删除用户
	 * @OneToMany(mapped=“由One的一方指向Many的一方，并且，这个属性应该等于Many的一方中含有One类的属性的属性名，否则会出错啦 ”)
	 */
	@OneToMany(mappedBy = "dealer",cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	private Set<User> users;

	
	/**
	 * 渠道多对一地区  双向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional=false)
	@JoinColumn(name = "areaId")
	private Area area;
	
	
	/**
	 * 渠道子关联
	 * 渠道的下级子渠道
	 */
	@OneToMany(mappedBy = "parentDealer" , cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private List<Dealer> childDealers; 
	
	/**
	 * 渠道的上级渠道
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false )
	@JoinColumn(name = "parentId")
	private Dealer parentDealer;
	
	
	
	
	/**
	 * 按照特定规则 自动生成 渠道编号
	 */
	@Column(name = "number" , length = 32 ,unique = true, nullable = false)
	private String number;
	
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

	/**
	 * 类型 指定经销商渠道的 类型 
	 * 属于总代理  还是区域下级渠道
	 */
	@Column(name="type",length = 2,nullable = false)
	private int type;
	

	
	

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Dealer> getChildDealers() {
		return childDealers;
	}

	public void setChildDealers(List<Dealer> childDealers) {
		this.childDealers = childDealers;
	}

	public Dealer getParentDealer() {
		return parentDealer;
	}

	public void setParentDealer(Dealer parentDealer) {
		this.parentDealer = parentDealer;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
