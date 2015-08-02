/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.supplier.db;

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
import com.hades.records.area.db.Area;
/**
 * 供应商信息档案 
 * HadesProject
 * @author 李先瞧
 * 2015-8-2
 *
 */
@Entity(name = "SupplierInfo")
public class SupplierInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4475028824209615172L;

	
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
	@JoinColumn(name = "dealerId" )
	private Dealer dealer ;
	
	
	/**
	 *  供应商与地区  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "areaId")
	private Area area ;
	

	/**
	 * 供应商信息 与供应商分类  多对一双向关联
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "supplierCategoryId")
	private SupplierCategory supplierCategory;
	
	
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
	 * 供应商详细地址
	 */
	@Column(name = "address" , length = 255 )
	private String address;
	
	
	/**
	 * 公司性质    1.经销商   2. 代理商    3 . 其他  
	 */
	@Column(name = "companyType" , length = 2,nullable = false )
	private int companyType;
	
	/**
	 * 银行账号 
	 */
	@Column(name = "bankAccount" , length = 32 )
	private String bankAccount;
	
	
	/**
	 * 入库类型  : 1.按订货入库  2.按采购入库
	 */
	@Column(name = "storageType" , length = 2,nullable = false )
	private int storageType;
	
	/**
	 * 纳税号
	 */
	@Column(name = "taxNumber" , length = 64 )
	private String taxNumber;
	
	/**
	 * 开户行 , 
	 */
	@Column(name = "bank" , length = 64 )
	private String bank; 
	
	/**
	 * 电话联系方式
	 */
	@Column(name = "phone" , length = 32 )
	private  String  phone;
	
	
	/**
	 * 传真
	 */
	@Column(name = "fax" , length = 32 )
	private  String fax;
	
	/**
	 * 邮编
	 */
	@Column(name = "postcode" , length = 32 )
	private  String  postcode;
	
	
	/**
	 * 开票地址 
	 */
	@Column(name = "billAddress" , length = 32 )
	private  String   billAddress;
	
	
	

	/**
	 * 供应商使用状态 ,  1.使用 2.停用
	 */
	@Column(name="doStatus",length = 2,nullable = false)
	private int doStatus ;
	
	

	/**
	 * 计价方式   1.折扣率   2.进价  3.进价跟踪  4.类别折扣率
	 */
	@Column(name="priceType",length = 2,nullable = false)
	private int priceType;
	
	
	/**
	 * 折扣率
	 */
	@Column(name = "discount" , length = 12 )
	private String discount;

	
	
	
	/**
	 * 类别折扣设置 
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


	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public SupplierCategory getSupplierCategory() {
		return supplierCategory;
	}


	public void setSupplierCategory(SupplierCategory supplierCategory) {
		this.supplierCategory = supplierCategory;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getCompanyType() {
		return companyType;
	}


	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}


	public String getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}


	public int getStorageType() {
		return storageType;
	}


	public void setStorageType(int storageType) {
		this.storageType = storageType;
	}


	public String getTaxNumber() {
		return taxNumber;
	}


	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getBillAddress() {
		return billAddress;
	}


	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}


	public int getDoStatus() {
		return doStatus;
	}


	public void setDoStatus(int doStatus) {
		this.doStatus = doStatus;
	}


	public int getPriceType() {
		return priceType;
	}


	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}


	public String getDiscount() {
		return discount;
	}


	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	

}
