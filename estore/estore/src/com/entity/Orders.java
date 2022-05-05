package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


public class Orders implements Serializable{
	private int oid;
	private int mid;
	private int orderNo;
	private Timestamp orderdate;
	private int orderstatus;
	private int dstatus;
	private int pay;
	private double sum;
	public Orders() {
		super();
	}
	
	public Orders(int oid, int mid, int orderNo, Timestamp orderdate,
			int orderstatus, int dstatus, int pay, double sum) {
		super();
		this.oid = oid;
		this.mid = mid;
		this.orderNo = orderNo;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
		this.dstatus = dstatus;
		this.pay = pay;
		this.sum = sum;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getDstatus() {
		return dstatus;
	}
	public void setDstatus(int dstatus) {
		this.dstatus = dstatus;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Orders [dstatus=" + dstatus + ", mid=" + mid + ", oid=" + oid
				+ ", orderNo=" + orderNo + ", orderdate=" + orderdate
				+ ", orderstatus=" + orderstatus + ", pay=" + pay + ", sum="
				+ sum + "]";
	}
	
	
	
}
