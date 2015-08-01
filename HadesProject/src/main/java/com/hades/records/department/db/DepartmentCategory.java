/*
 * 李先瞧
 * 2015-8-1
 *
 */

package com.hades.records.department.db;

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

import com.hades.dealers.db.Dealer;
/**
 * 部门实体类  , 
 * 1 . 部门与渠道  多对一  单项关联
 * 2 . 部门 自关联 
 * HadesProject
 * @author 李先瞧
 * 2015-8-1
 *
 */
@Entity(name="DepartmentCategory")
public class DepartmentCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5717829521232813870L;

	
	/**
	 * 主键id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	
	/**
	 * 部门双向自关联 , 下级子部门
	 */
	@OneToMany(cascade = {CascadeType.REMOVE,CascadeType.MERGE},mappedBy = "parentDepartmentCategory")
	private List<DepartmentCategory> childDepartmentCategorys;
	
	
	
	/**
	 * 部门自关联 , 父级部门
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "parentId" )
	private DepartmentCategory parentDepartmentCategory;
	
	
	/**
	 *  部门与渠道  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "dealerId")
	private Dealer dealer ;
	
	/**
	 * 部门分类  与  部门档案信息  一对多 双向关联
	 */
	@OneToMany(mappedBy = "departmentCategory",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private Set<DepartmentInfo> departmentInfos;
	
	
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
	 * 类型  哪一类的部门 
	 */
	@Column(name="type",length = 2,nullable = false)
	private int type;
	
	
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

	public List<DepartmentCategory> getChildDepartmentCategorys() {
		return childDepartmentCategorys;
	}

	public void setChildDepartmentCategorys(
			List<DepartmentCategory> childDepartmentCategorys) {
		this.childDepartmentCategorys = childDepartmentCategorys;
	}

	public Set<DepartmentInfo> getDepartmentInfos() {
		return departmentInfos;
	}

	public void setDepartmentInfos(Set<DepartmentInfo> departmentInfos) {
		this.departmentInfos = departmentInfos;
	}

	public DepartmentCategory getParentDepartmentCategory() {
		return parentDepartmentCategory;
	}

	public void setParentDepartmentCategory(
			DepartmentCategory parentDepartmentCategory) {
		this.parentDepartmentCategory = parentDepartmentCategory;
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
