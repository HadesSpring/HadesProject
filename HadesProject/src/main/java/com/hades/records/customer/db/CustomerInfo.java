/*
 * 李先瞧
 * 2015-8-2
 *
 */

package com.hades.records.customer.db;

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
 * 客户档案信息 
 * HadesProject
 * @author 李先瞧
 * 2015-8-2
 *
 */
@Entity(name = "CustomerInfo")
public class CustomerInfo implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4644404358436474147L;

	
	

	/**
	 * 主键id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",length=20)
	private long id;
	
	
	
	/**
	 *  客户信息与渠道  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "dealerId" )
	private Dealer dealer ;
	
	
	/**
	 *  客户信息与地区  多对一单项关联 
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "areaId")
	private Area area ;
	
	/**
	 * 客户档案信息  与  客户类别 多对一 双向关联  
	 */
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "customerCategoryId")
	private CustomerCategory customerCategory;
	
	
	

	/**
	 * 名称
	 */
	@Column(name="name",length=32 , nullable = false)
	private String name;
	
	/**
	 * 名称简称
	 */
	@Column(name="abbreviation",length=32 , nullable = false)
	private String abbreviation;
	
	/**
	 * 按照特定规则 自动生成 编号
	 */
	@Column(name = "number" , length = 32 ,unique = true, nullable = false)
	private String number;
	
	/**
	 * 客户类型  1.代理商 2.分公司 3.加盟商  4.普通客户
	 */
	@Column(name="customerType",length=2 , nullable = false)
	private int customerType;
	
	/**
	 * 管理库存    1.不管理库存    2.管理库存
	 */
	@Column(name="managerStorage",length=2 , nullable = false)
	private  int managerStorage;
	
	/**
	 * 仓库属性    1.仓库    2.卖场 
	 */
	@Column(name="storageType",length=2 , nullable = false)
	private  int storageType;
	
	/**
	 * 是否控制调换率   1.控制   2.不控制
	 */
	@Column(name="contrlChange",length=2 , nullable = false)
	private  int  contrlChange;
	

	/**
	 * 客户信息使用状态 ,  1.使用 2.停用
	 */
	@Column(name="doStatus",length = 2,nullable = false)
	private int doStatus ;
	
	/**
	 * 是否手动审核采购单  1.是   2.否
	 */
	@Column(name="handAudit",length = 2,nullable = false)
	private int handAudit;
	
	
	/**
	 * 是否按订货出库    1.是   2.否
	 */
	@Column(name="outStorage",length = 2,nullable = false)
	private int outStorage;
	
	
	
	/** *********************  基本信息  *********************    */
	
	
	/**
	 * 客户公司
	 */
	@Column(name="company",length=32 )
	private  String  company;
	
	/**
	 * 所属行业
	 */
	@Column(name="trade",length=32 )
	private  String  trade;
	
	
	/**
	 * 税号
	 */
	@Column(name="tax",length=32 )
	private  String  tax;
	
	
	/**
	 * 法人
	 */
	@Column(name="corporation",length=32 )
	private  String  corporation;
	
	
	/**
	 * 开户银行
	 */
	@Column(name="bank",length=32 )
	private  String  bank;
	
	
	/**
	 * 银行账号
	 */
	@Column(name="bankAccount",length=32 )
	private  String  bankAccount;
	
	
	
	/** *********************  联系  *********************    */
	
	/**
	 * 详细地址
	 */
	@Column(name = "address" , length = 255 )
	private String address;
	

	/**
	 * 手机
	 */
	@Column(name = "phone" , length = 32 )
	private  String  phone;
	/**
	 * 电话 
	 */
	@Column(name = "calls" , length = 32 )
	private  String  calls;
	
	
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
	 * 联系人
	 */
	@Column(name = "person" , length = 32 )
	private  String  person;
	
	
	/**
	 * email邮箱
	 */
	@Column(name = "email" , length = 32 )
	private  String  email;
	

	/**
	 * 其他联系方式
	 */
	@Column(name = "otherContact" , length = 32 )
	private  String  otherContact;
	
	
	/**
	 * 发货仓库
	 */
	@Column(name = "sendStorage" , length = 32 )
	private  String  sendStorage;
	
	/**
	 * 发货地址
	 */
	@Column(name = "sendAddress" , length = 64 )
	private  String  sendAddress;
	
	
	/**
	 * 发货方式
	 */
	@Column(name = "sendWay" , length = 32 )
	private  String  sendWay;
	
	
	
	/** *********************  信用  *********************    */
	
	/**
	 * 信用等级
	 */
	@Column(name = "creditLevel" , length = 12 )
	private String creditLevel;
	
	
	/**
	 * 信用额度
	 */
	@Column(name = "creditMoney" , length = 32 )
	private String creditMoney;
	
	/**
	 * 信用期限
	 */
	@Column(name = "creditTime" , length = 20 )
	private long creditTime;
	
	
	/**
	 * 付款方式
	 */
	@Column(name = "payWay" , length = 32 )
	private String payWay;
	
	
	/**
	 * 最后交易时期
	 */
	@Column(name = "dealTime" , length = 20 )
	private  long  dealTime;
	
	
	/**
	 * 最后交易金额
	 */
	@Column(name = "dealMoney" , length = 20 )
	private  double  dealMoney;
	
	/**
	 * 最早欠款日期
	 */
	@Column(name = "arrearsTime" , length = 20 )
	private long  arrearsTime;
	
	/**
	 * 最后收款金额
	 */
	@Column(name = "posMoney" , length = 20 )
	private double posMoney;
	

	/** *********************  其他  *********************    */
	
	/**
	 * 分管部门
	 */
	@Column(name = "department" , length = 32 )
	private String department;
	
	/**
	 * 专营业务员
	 */
	@Column(name = "salesman" , length = 32 )
	private String salesman;
	
	/**
	 * 发展日期
	 */
	@Column(name = "developTime" , length = 20 )
	private long developTime;
	
	/**
	 * 停用日期
	 */
	@Column(name = "stopTime" , length = 20 )
	private long  stopTime;
	/**
	 * 使用额度
	 */
	@Column(name = "useQuota" , length = 20 )
	private double useQuota ;
	/**
	 * 调换精确度      1.款式   2.颜色
	 */
	@Column(name = "exchange" , length = 2 )
	private  int exchange;
	
	/**
	 * 范围外退货处理  1.提示   2.不允许,不提示     3,直接强制退货
	 */
	@Column(name = "giveBack" , length = 2 )
	private  int giveBack;
	
	/**
	 * 调换率 设置 
	 */
	
	
	

	/** *********************  价格体系  *********************    */
	
	/**
	 * 价格体系 
	 * 1.依据商品档案  - 按客户折扣 
	 * 2.依据商品档案  - 按单款折扣
	 * 3.依据商品档案  - 批发价1
	 * 4.依据商品档案  - 批发价2
	 * 5.依据商品档案  - 批发价3
	 * 6.依据商品档案  - 批发价4
	 * 7.依据客户价格表  - 按客户折扣
	 * 8.依据客户价格表  - 按单款折扣
	 * 9.依据客户价格表  - 按固定批发价
	 * 10.按价格追踪
	 * 11.货品类别折扣  [设置]
	 * 12.按品牌折扣率结算 - 品牌折扣  [设置]
	 * 13.按发货类型折扣率 - 发货类别折扣   [设置]
	 * 
	 */
	@Column(name = "priceType" , length = 2 )
	private int priceType;
	
	
	/**
	 * 受 priceType = 1  控制 
	 * 1.依据商品档案  - 按客户折扣 [值value]
	 */
	@Column(name = "value" , length = 12 )
	private  String value;
	
	/**
	 * 是否  启用批发价同时追踪 1.启用   2.不启用
	 * 受 priceType = 1  控制 
	 */
	@Column(name = "enable" , length = 2 )
	private int enable;

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

	public CustomerCategory getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(CustomerCategory customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public int getManagerStorage() {
		return managerStorage;
	}

	public void setManagerStorage(int managerStorage) {
		this.managerStorage = managerStorage;
	}

	public int getStorageType() {
		return storageType;
	}

	public void setStorageType(int storageType) {
		this.storageType = storageType;
	}

	public int getContrlChange() {
		return contrlChange;
	}

	public void setContrlChange(int contrlChange) {
		this.contrlChange = contrlChange;
	}

	public int getDoStatus() {
		return doStatus;
	}

	public void setDoStatus(int doStatus) {
		this.doStatus = doStatus;
	}

	public int getHandAudit() {
		return handAudit;
	}

	public void setHandAudit(int handAudit) {
		this.handAudit = handAudit;
	}

	public int getOutStorage() {
		return outStorage;
	}

	public void setOutStorage(int outStorage) {
		this.outStorage = outStorage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCalls() {
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtherContact() {
		return otherContact;
	}

	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}

	public String getSendStorage() {
		return sendStorage;
	}

	public void setSendStorage(String sendStorage) {
		this.sendStorage = sendStorage;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getSendWay() {
		return sendWay;
	}

	public void setSendWay(String sendWay) {
		this.sendWay = sendWay;
	}

	public String getCreditLevel() {
		return creditLevel;
	}

	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}

	public String getCreditMoney() {
		return creditMoney;
	}

	public void setCreditMoney(String creditMoney) {
		this.creditMoney = creditMoney;
	}

	public long getCreditTime() {
		return creditTime;
	}

	public void setCreditTime(long creditTime) {
		this.creditTime = creditTime;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public long getDealTime() {
		return dealTime;
	}

	public void setDealTime(long dealTime) {
		this.dealTime = dealTime;
	}

	public double getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(double dealMoney) {
		this.dealMoney = dealMoney;
	}

	public long getArrearsTime() {
		return arrearsTime;
	}

	public void setArrearsTime(long arrearsTime) {
		this.arrearsTime = arrearsTime;
	}

	public double getPosMoney() {
		return posMoney;
	}

	public void setPosMoney(double posMoney) {
		this.posMoney = posMoney;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public long getDevelopTime() {
		return developTime;
	}

	public void setDevelopTime(long developTime) {
		this.developTime = developTime;
	}

	public long getStopTime() {
		return stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	public double getUseQuota() {
		return useQuota;
	}

	public void setUseQuota(double useQuota) {
		this.useQuota = useQuota;
	}

	public int getExchange() {
		return exchange;
	}

	public void setExchange(int exchange) {
		this.exchange = exchange;
	}

	public int getGiveBack() {
		return giveBack;
	}

	public void setGiveBack(int giveBack) {
		this.giveBack = giveBack;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
