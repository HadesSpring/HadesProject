/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.employee.db;

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
import com.hades.records.department.db.DepartmentInfo;

/**
 * 员工基础档案信息
 * HadesProject
 * @author 李先瞧
 * 2015-8-2
 *
 */
@Entity(name = "EmployeeInfo")
public class EmployeeInfo implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -882051202958738315L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 *员工基本档案信息  多对一 渠道  单向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dealerId")
	private Dealer dealer;
	
	/**
	 * 员工信息  与 公司内部档案  多对一 双向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "companyInsideInfoId")
	private  CompanyInsideInfo companyInsideInfo;
	
	/**
	 * 员工信息  与 员工职务 多对一 双向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "employeeDutyInfoId")
	private  EmployeeDutyInfo employeeDutyInfo;
	
	
	/**
	 * 员工信息  多对一 部门档案信息 双向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "departmentInfoId")
	private DepartmentInfo departmentInfo;
	
	
	/**
	 * 姓名
	 */
	@Column(name="name",length=32 , unique = true,nullable = false)
	private String name;
	
	
	/**
	 * 性别
	 * 1.男    2.女
	 */
	@Column(name="sex",length=2 ,nullable = false)
	private  int  sex ;
	
	
	/**
	 * 学历
	 * 1.小学   2.初中  3.高中  4.中专  5.大专  6.本科   7.学士  8.硕士   10.博士
	 */
	@Column(name="degree",length=2 ,nullable = false)
	private  int  degree;


	
	
	
	
	
	
	
	
	
	
	
	
	
	
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


	public CompanyInsideInfo getCompanyInsideInfo() {
		return companyInsideInfo;
	}


	public void setCompanyInsideInfo(CompanyInsideInfo companyInsideInfo) {
		this.companyInsideInfo = companyInsideInfo;
	}


	public EmployeeDutyInfo getEmployeeDutyInfo() {
		return employeeDutyInfo;
	}


	public void setEmployeeDutyInfo(EmployeeDutyInfo employeeDutyInfo) {
		this.employeeDutyInfo = employeeDutyInfo;
	}


	public DepartmentInfo getDepartmentInfo() {
		return departmentInfo;
	}


	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public int getDegree() {
		return degree;
	}


	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
