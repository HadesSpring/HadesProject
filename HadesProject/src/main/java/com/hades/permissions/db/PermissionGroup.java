/*
 * 李先瞧
 * 2015-8-5
 *
 */

package com.hades.permissions.db;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.hades.dealers.db.Dealer;
import com.hades.records.employee.db.EmployeeInfo;

/**
 * 权限组
 * HadesProject
 * @author 李先瞧
 * 2015-8-5
 *
 */
@Entity(name = "PermissionGroup")
public class PermissionGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985758699560246311L;

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 *权限组信息  多对一 渠道  单向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dealerId")
	private Dealer dealer;
	
	/**
	 * 员工信息与权限组双向 多对多  被控方
	 * 比如你在A表中有一个外键，是B表的ID（主键），这时候A就是主控方，B就是被控方。
	 * 当保存主控方实体Entity时，被控方entity也会级联保存，但保存被控方entity时，无法级联保存主控方entity，就像学生和学校的关系，学生需要知道学校在哪里，学校不一定知道学生在哪里。
	 * 
	 */
	@ManyToMany(mappedBy = "permissionGroups",cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private List<EmployeeInfo> employeeInfos ;
	/**
	 * 按照特定规则 自动生成 编号
	 */
	@Column(name = "number" , length = 32 ,nullable = false,unique = true)
	private String number;
	
	/**
	 * 名称
	 */
	@Column(name="name",length=32 , unique = true,nullable = false)
	private String name;

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

	public List<EmployeeInfo> getEmployeeInfos() {
		return employeeInfos;
	}

	public void setEmployeeInfos(List<EmployeeInfo> employeeInfos) {
		this.employeeInfos = employeeInfos;
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
	
	
}
