package com.entity;

import java.util.Date;

public class Shouye {
  private int sid;
  private String name;
  private String sno;
  private String snation;
  private String scity;
  private String scolor;
  private String ssize;
  private Date sdate;
  private String scharact;
  private String sother;
  private String spic;
  private int number;
  private double sprice;
public double getSprice() {
	return sprice;
}
public void setSprice(double sprice) {
	this.sprice = sprice;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public Shouye() {
	super();
}
public Shouye(int sid, String name, String sno, String snation, String scity,
		String scolor, String ssize, Date sdate, String scharact,
		String sother, String spic) {
	super();
	this.sid = sid;
	this.name = name;
	this.sno = sno;
	this.snation = snation;
	this.scity = scity;
	this.scolor = scolor;
	this.ssize = ssize;
	this.sdate = sdate;
	this.scharact = scharact;
	this.sother = sother;
	this.spic = spic;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public String getSnation() {
	return snation;
}
public void setSnation(String snation) {
	this.snation = snation;
}
public String getScity() {
	return scity;
}
public void setScity(String scity) {
	this.scity = scity;
}
public String getScolor() {
	return scolor;
}
public void setScolor(String scolor) {
	this.scolor = scolor;
}
public String getSsize() {
	return ssize;
}
public void setSsize(String ssize) {
	this.ssize = ssize;
}
public Date getSdate() {
	return sdate;
}
public void setSdate(Date sdate) {
	this.sdate = sdate;
}
public String getScharact() {
	return scharact;
}
public void setScharact(String scharact) {
	this.scharact = scharact;
}
public String getSother() {
	return sother;
}
public void setSother(String sother) {
	this.sother = sother;
}
public String getSpic() {
	return spic;
}
public void setSpic(String spic) {
	this.spic = spic;
}
@Override
public String toString() {
	return "Shouye [name=" + name + ", scharact=" + scharact + ", scity="
			+ scity + ", scolor=" + scolor + ", sdate=" + sdate + ", sid="
			+ sid + ", snation=" + snation + ", sno=" + sno + ", sother="
			+ sother + ", spic=" + spic + ", ssize=" + ssize + "]";
}
  
}
