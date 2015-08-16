/*
 * 李先瞧
 * 2015-8-5
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
 * 员工提成组
 * HadesProject
 * @author 李先瞧
 * 2015-8-5
 *
 */
@Entity(name = "DeductGroup")
public class DeductGroup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4426895066279207252L;

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 * 员工提成组信息  多对一 渠道  单向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dealerId")
	private Dealer dealer;
	
	/**
	 * 提成组  一对多提成级别   双向关联
	 * 
	 */
	@OneToMany(mappedBy = "deductGroup" , cascade = {CascadeType.REMOVE,CascadeType.MERGE})
	private Set<DeductLevel> deductLevels;
	
	
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
	
	/**
	 * 组类型   1.集体提成组 2.个人提成组
	 */
	@Column(name="type",length=2 , nullable = false)
	private  int type;
	
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

	public Set<DeductLevel> getDeductLevels() {
		return deductLevels;
	}

	public void setDeductLevels(Set<DeductLevel> deductLevels) {
		this.deductLevels = deductLevels;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
