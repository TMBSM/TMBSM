package com.entity;

import java.io.Serializable;

public class Category implements Serializable{
   private int cid;
   private int category;
   private String name;
   private String cdesc;
public Category() {
	super();
}
public Category(int cid, int category, String name,String cdesc) {
	super();
	this.cid = cid;
	this.category = category;
	this.name = name;
	this.cdesc=cdesc;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCdesc() {
	return cdesc;
}
public void setCdesc(String cdesc) {
	this.cdesc = cdesc;
}
@Override
public String toString() {
	return "Category [category=" + category + ", cdesc=" + cdesc + ", cid="
			+ cid + ", name=" + name + "]";
}

   
}
