package com.crm.model;

import lombok.Builder;


@Builder
public class User_Model {
	private String uid;
	private String eid;
	private String uname;
	private String phone;
	private String address;
	private String credit;
	private String buyProduce;
	private String buyTime;
	private String pwd;
	public User_Model(){}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public User_Model(String uid, String eid, String uname, String phone, String address, String credit, String buyProduce, String buyTime,String pwd) {
		this.uid=uid;
		this.eid = eid;
		this.uname = uname;
		this.phone = phone;
		this.address = address;
		this.credit = credit;
		this.buyProduce = buyProduce;
		this.buyTime = buyTime;
		this.pwd=pwd;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getBuyProduce() {
		return buyProduce;
	}

	public void setBuyProduce(String buyProduce) {
		this.buyProduce = buyProduce;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

}
