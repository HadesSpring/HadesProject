/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.employee.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.hades.dealers.db.Dealer;
import com.hades.permissions.db.PermissionGroup;
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
	 * 员工信息  与提成组多对一单项关联
	 */
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name = "deductGroupId")
	private DeductGroup deductGroup;
	
	/**
	 * 员工多对多 权限组  双向关联
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PermissionGroup_EmployeeInfo", joinColumns = { @JoinColumn(name = "employeeInfoId") }, inverseJoinColumns = { @JoinColumn(name = "permissionGroupId") })
	private List<PermissionGroup> permissionGroups;

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


	/**
	 * 提成
	 */
	@Column(name="deduct",length=12 )
	private String  deduct;
	
	/**
	 * 薪资,基本工资
	 */
	@Column(name="salary",length=20 )
	private double salary;
	
	
	/**
	 * 员工属性
	 * 1.职员   2.操作员   3.部门管理员  4.渠道管理员
	 */
	@Column(name="employeeType",length=2 )
	private int employeeType;
	
	
	
	/**
	 * 手机 
	 */
	@Column(name="phone",length=32 )
	private  String  phone;
	
	
	/**
	 * 联系方式
	 */
	@Column(name="call",length=32 )
	private  String  call;
	
	
	/**
	 * 班组  1.A组  2.B组 3.C组 4.D组
	 */
	@Column(name="teamGroup",length=2 )
	private int teamGroup;
	
	/**
	 * 身份证号
	 */
	@Column(name="idCard",length=32 )
	private  String idCard;
	
	/**
	 * 联系地址 
	 */
	@Column(name="address",length=255 )
	private String address;
	
	
	/**
	 *员工使用状态 ,  1.使用 2.停用
	 */
	@Column(name="doStatus",length = 2,nullable = false)
	private int doStatus ;
	
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


	public DeductGroup getDeductGroup() {
		return deductGroup;
	}


	public void setDeductGroup(DeductGroup deductGroup) {
		this.deductGroup = deductGroup;
	}


	public List<PermissionGroup> getPermissionGroups() {
		return permissionGroups;
	}


	public void setPermissionGroups(List<PermissionGroup> permissionGroups) {
		this.permissionGroups = permissionGroups;
	}


	public String getDeduct() {
		return deduct;
	}


	public void setDeduct(String deduct) {
		this.deduct = deduct;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCall() {
		return call;
	}


	public void setCall(String call) {
		this.call = call;
	}


	public int getTeamGroup() {
		return teamGroup;
	}


	public void setTeamGroup(int teamGroup) {
		this.teamGroup = teamGroup;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getDoStatus() {
		return doStatus;
	}


	public void setDoStatus(int doStatus) {
		this.doStatus = doStatus;
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
