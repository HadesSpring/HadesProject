/*
 * 李先瞧
 * 2015-8-1
 *
 */

package com.hades.records.department.db;

import java.io.Serializable;
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
import com.hades.records.area.db.Area;
import com.hades.records.employee.db.EmployeeInfo;

/**
 * 部门档案信息实体类
 * 1. 部门关联渠道  多对一的  单向关联
 * 
 * HadesProject
 * @author 李先瞧
 * 2015-8-1
 *
 */
@Entity(name = "DepartmentInfo")
public class DepartmentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7084554004411812310L;

	
	
	/**
	 * 主键id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	
	
	/**
	 *  部门与渠道  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "dealerId" )
	private Dealer dealer ;
	
	
	/**
	 *  部门与地区  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "areaId")
	private Area area ;
	
	/**
	 * 部门档案信息  与部门分类  多对一  双向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "departmentCategoryId" ) 
	private DepartmentCategory departmentCategory;
	
	
	/**
	 * 部门档案信息  一对多  员工信息   双向关联
	 * 
	 */
	@OneToMany(mappedBy = "departmentInfo" , cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private Set<EmployeeInfo> employeeInfos;
	
	/**
	 * 名称
	 */
	@Column(name="name",length=32 , nullable = false)
	private String name;
	
	
	/**
	 * 按照特定规则 自动生成 编号
	 */
	@Column(name = "number" , length = 32 ,unique = true, nullable = false)
	private String number;
	

	/**
	 * 类型 仓库属性类型   1.卖场  2.仓库 3.财务 
	 */
	@Column(name="storageType",length = 2,nullable = false)
	private int storageType; 
	
	

	/**
	 * 部门使用状态 ,  1.使用 2.停用
	 */
	@Column(name="doStatus",length = 2,nullable = false)
	private int doStatus ;
	
	

	/**
	 * 数据发送标志   1.可发送 2.不发送
	 */
	@Column(name="canSend",length = 2,nullable = false)
	private int canSend ;
	
	/**
	 * 负责人姓名
	 */
	@Column(name="superPersonName",length = 32,nullable = false)
	private String superPersonName;
	
	
	/**
	 * 联系电话
	 */
	@Column(name="phone",length = 32,nullable = false)
	private String phone;
	
	/**
	 * 详细地址
	 */
	@Column(name="address",length = 255,nullable = false)
	private  String address ; 
	
	/**
	 * 传真
	 */
	@Column(name="telautogram",length = 32)
	private  String telautogram;
	
	
	/**
	 * 计价方式   1.折扣率   2.调拨价
	 */
	@Column(name="priceType",length = 2,nullable = false)
	private int priceType;
	
	
	/**
	 *  描述详情
	 */
	@Column(name="description" , length=255 )
	private String description;
	
	
	
	/**
	 * 默认现金账户  
	 * 李先瞧
	 * 2015-8-1
	 * 
	 * @return
	 */

	
	
	/**
	 * 默认银行账户 
	 * 李先瞧
	 * 2015-8-1
	 * 
	 * @return
	 */

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Dealer getDealer() {
		return dealer;
	}


	public Set<EmployeeInfo> getEmployeeInfos() {
		return employeeInfos;
	}


	public void setEmployeeInfos(Set<EmployeeInfo> employeeInfos) {
		this.employeeInfos = employeeInfos;
	}


	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public DepartmentCategory getDepartmentCategory() {
		return departmentCategory;
	}


	public void setDepartmentCategory(DepartmentCategory departmentCategory) {
		this.departmentCategory = departmentCategory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public int getStorageType() {
		return storageType;
	}


	public void setStorageType(int storageType) {
		this.storageType = storageType;
	}


	public int getDoStatus() {
		return doStatus;
	}


	public void setDoStatus(int doStatus) {
		this.doStatus = doStatus;
	}


	public int getCanSend() {
		return canSend;
	}


	public void setCanSend(int canSend) {
		this.canSend = canSend;
	}


	public String getSuperPersonName() {
		return superPersonName;
	}


	public void setSuperPersonName(String superPersonName) {
		this.superPersonName = superPersonName;
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


	public String getTelautogram() {
		return telautogram;
	}


	public void setTelautogram(String telautogram) {
		this.telautogram = telautogram;
	}


	public int getPriceType() {
		return priceType;
	}


	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
}
