/*
 * 李先瞧
 * 2015-8-9
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

/**
 * 提成级别设置
 * HadesProject
 * @author 李先瞧
 * 2015-8-9
 *
 */
@Entity(name = "DeductLevel")
public class DeductLevel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 118544565147748464L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	/**
	 * 员工提成级别信息  多对一 渠道  单向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dealerId")
	private Dealer dealer;

	/**
	 * 提成级别 多对一双向 关联 提成组
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "deductGroupId")
	private DeductGroup deductGroup;
	/**
	 * 销售总额
	 */
	@Column(name="totalSale",length=20 ,nullable = false)
	private double totalSale;
	
	/**
	 * 提成率百分比
	 */
	@Column(name="rate",length=20 ,nullable = false)
	private double rate;

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

	public DeductGroup getDeductGroup() {
		return deductGroup;
	}

	public void setDeductGroup(DeductGroup deductGroup) {
		this.deductGroup = deductGroup;
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
