/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.customer.db;

import java.io.Serializable;
import java.util.List;

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

import com.hades.dealers.db.Dealer;


/**
 * 顾客客户分类类别
 * HadesProject
 * @author 李先瞧
 * 2015-8-2
 *
 */
@Entity(name="CustomerCategory")
public class CustomerCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7558589083546007703L;

	
	/**
	 * 主键id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	
	
	/**
	 * 客户双向自关联 , 下级子客户类别
	 */
	@OneToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE},mappedBy = "parentCustomerCategory")
	private List<CustomerCategory> childCustomerCategorys;
	
	
	
	/**
	 * 客户自关联 , 父级客户类别
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "parentId" )
	private CustomerCategory parentCustomerCategory;
	
	
	/**
	 *  客户与渠道  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "dealerId")
	private Dealer dealer ;
	
	
	/**
	 * 
	 */
	@OneToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE},mappedBy = "customerCategory")
	private List<CustomerInfo> customerInfos;
	
	
	
	/**
	 * 按照特定规则 自动生成 编号
	 */
	@Column(name = "number" , length = 32 ,nullable = false,unique = true)
	private String number;
	
	/**
	 * 名称
	 */
	@Column(name="name",length=32 , nullable = false)
	private String name;
	
	/**
	 *  描述详情
	 */
	@Column(name="description" , length=255 )
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<CustomerCategory> getChildCustomerCategorys() {
		return childCustomerCategorys;
	}

	public void setChildCustomerCategorys(
			List<CustomerCategory> childCustomerCategorys) {
		this.childCustomerCategorys = childCustomerCategorys;
	}

	public CustomerCategory getParentCustomerCategory() {
		return parentCustomerCategory;
	}

	public void setParentCustomerCategory(CustomerCategory parentCustomerCategory) {
		this.parentCustomerCategory = parentCustomerCategory;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
	
	
	
}
