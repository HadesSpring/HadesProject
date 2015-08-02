/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.supplier.db;

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
 * 供应商分类
 * HadesProject
 * @author 李先瞧
 * 2015-8-2
 *
 */
@Entity(name="SupplierCategory")
public class SupplierCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6400277921808462978L;

	/**
	 * 主键id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	

	/**
	 *  供应商与渠道  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "dealerId")
	private Dealer dealer ;
	
	
	/**
	 *  下级供应商,供应商双向自关联
	 */
	@OneToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE},mappedBy = "parentSupplierCategory")
	private List<SupplierCategory> childSupplierCategorys;
	
	
	
	/**
	 * 供应商父级 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "parentId" )
	private SupplierCategory parentSupplierCategory;
	
	
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

	
	/**
	 * 供应商分类  一对多 供应商信息   双向关联
	 */
	@OneToMany(mappedBy = "supplierCategory" , cascade = {CascadeType.REMOVE,CascadeType.MERGE} )
	private List<SupplierInfo> supplierInfos;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Dealer getDealer() {
		return dealer;
	}


	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}


	public List<SupplierCategory> getChildSupplierCategorys() {
		return childSupplierCategorys;
	}


	public void setChildSupplierCategorys(
			List<SupplierCategory> childSupplierCategorys) {
		this.childSupplierCategorys = childSupplierCategorys;
	}


	public SupplierCategory getParentSupplierCategory() {
		return parentSupplierCategory;
	}


	public void setParentSupplierCategory(SupplierCategory parentSupplierCategory) {
		this.parentSupplierCategory = parentSupplierCategory;
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


	public List<SupplierInfo> getSupplierInfos() {
		return supplierInfos;
	}


	public void setSupplierInfos(List<SupplierInfo> supplierInfos) {
		this.supplierInfos = supplierInfos;
	}

	
	
	
	
	
	
	
	
}
