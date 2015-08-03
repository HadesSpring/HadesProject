/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.employee.db;

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

/**
 * 公司内部档案信息
 * HadesProject
 * @author 李先瞧
 * 2015-8-2
 *
 */ 
@Entity(name = "CompanyInsideInfo")
public class CompanyInsideInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423341647243381060L;

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 * 部门内部档案信息  多对一 渠道  单向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dealerId")
	private Dealer dealer;
	
	
	
	/**
	 * 公司内部信息  一对多  员工信息   双向关联
	 * 
	 */
	@OneToMany(mappedBy = "companyInsideInfo" , cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private Set<EmployeeInfo> employeeInfos;
	
	
	/**
	 * 名称
	 */
	@Column(name="name",length=32 , unique = true,nullable = false)
	private String name;
	
	
	/**
	 * 按照特定规则 自动生成 编号
	 */
	@Column(name = "number" , length = 32 ,unique = true, nullable = false)
	private String number;
	
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

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<EmployeeInfo> getEmployeeInfos() {
		return employeeInfos;
	}

	public void setEmployeeInfos(Set<EmployeeInfo> employeeInfos) {
		this.employeeInfos = employeeInfos;
	}

	
	
}
