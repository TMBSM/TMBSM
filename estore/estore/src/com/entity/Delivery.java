package com.entity;

import java.io.Serializable;

public class Delivery implements Serializable{
private int did;
private String dname;
private double dprice;
public Delivery() {
	super();
}
public Delivery(int did, String dname, double dprice) {
	super();
	this.did = did;
	this.dname = dname;
	this.dprice = dprice;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public double getDprice() {
	return dprice;
}
public void setDprice(double dprice) {
	this.dprice = dprice;
}
@Override
public String toString() {
	return "Delivery [did=" + did + ", dname=" + dname + ", dprice=" + dprice
			+ "]";
}


}
