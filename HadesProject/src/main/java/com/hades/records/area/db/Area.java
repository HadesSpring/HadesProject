/*
 * 李先瞧
 * 2015-8-1
 *
 */

package com.hades.records.area.db;

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
 * 区域地区设置 
 * 区域一经创建不可删除 , 只能修改
 * 
 * HadesProject
 * @author 李先瞧
 * 2015-8-1
 *
 */
@Entity(name = "Area")
public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3894755359680189188L;
	
	/**
	 * 主键id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	
	/**
	 * 所属子地区
	 */
	@OneToMany(mappedBy = "parentArea",cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	private List<Area> childAreas;
	
	/**
	 * 地方区域的父级地区
	 */
	@ManyToOne(fetch = FetchType.LAZY ,optional=false)
	@JoinColumn(name = "parentId")
	private  Area parentArea;
	
	
	/**
	 * 地区一对多 渠道 双向关联
	 */
	@OneToMany(mappedBy = "area" , cascade={CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST})
	private Set<Dealer> dealers;
	
	
	/**
	 * 按照特定规则 自动生成 编号
	 */
	@Column(name = "number" , length = 32 ,unique = true, nullable = false)
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



	public List<Area> getChildAreas() {
		return childAreas;
	}



	public void setChildAreas(List<Area> childAreas) {
		this.childAreas = childAreas;
	}



	public Area getParentArea() {
		return parentArea;
	}



	public void setParentArea(Area parentArea) {
		this.parentArea = parentArea;
	}



	public Set<Dealer> getDealers() {
		return dealers;
	}



	public void setDealers(Set<Dealer> dealers) {
		this.dealers = dealers;
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
