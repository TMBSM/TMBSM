package com.entity;

import java.io.Serializable;

public class Merchandise implements Serializable{
	private int gid;
	private int category;
	private String mername;
	private double price;
	private double sprice;
	private String picture;
	private String merdesc;
	private String manufacturer;
	private int special;
	private int number;
	public Merchandise() {
		super();
	}
	public Merchandise(int gid, int category, String mername, double price,
			double sprice, String picture, String merdesc, String manufacturer,
			String leavefactory, int special) {
		super();
		this.gid = gid;
		this.category = category;
		this.mername = mername;
		this.price = price;
		this.sprice = sprice;
		this.picture = picture;
		this.merdesc = merdesc;
		this.manufacturer = manufacturer;
		this.special = special;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getMername() {
		return mername;
	}
	public void setMername(String mername) {
		this.mername = mername;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSprice() {
		return sprice;
	}
	public void setSprice(double sprice) {
		this.sprice = sprice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getMerdesc() {
		return merdesc;
	}
	public void setMerdesc(String merdesc) {
		this.merdesc = merdesc;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getSpecial() {
		return special;
	}
	public void setSpecial(int special) {
		this.special = special;
	}
	@Override
	public String toString() {
		return "Merchandise [category=" + category + ", gid=" + gid
				+ ", manufacturer="
				+ manufacturer + ", mername=" + mername + ", merdesc="
				+ merdesc + ", picture=" + picture + ", price=" + price
				+ ", special=" + special + ", sprice=" + sprice + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
