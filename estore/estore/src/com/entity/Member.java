package com.entity;

import java.io.Serializable;

public class Member implements Serializable{
	private int mid;
	private String mlevel;
	private String loginName;
	private String loginPwd;
	private String mName;
	private int phone;
	private String address;
	private String email;
	private int intergal;
	public Member() {
		super();
	}
	public Member(int mid, String mlevel, String loginName, String loginPwd,
			String mName, int phone, String address, String email, int intergal) {
		super();
		this.mid = mid;
		this.mlevel = mlevel;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.mName = mName;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.intergal = intergal;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIntergal() {
		return intergal;
	}
	public void setIntergal(int intergal) {
		this.intergal = intergal;
	}
	@Override
	public String toString() {
		return "Manager [address=" + address + ", email=" + email
				+ ", intergal=" + intergal + ", loginName=" + loginName
				+ ", loginPwd=" + loginPwd + ", mName=" + mName + ", mid="
				+ mid + ", mlevel=" + mlevel + ", phone=" + phone + "]";
	}
	
}
