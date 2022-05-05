package com.pagedivide.bean;


import com.dao.OrderDAOImp;
import com.db.DBCon;
import com.entity.Orders;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class OrderPageDivide {
   private int sumRecord;
   private int pageRecord=10;
   private int pageNum;

	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	OrderDAOImp odi=null;
public OrderPageDivide() {
	super();
	sumRecord=this.getSumRecord();
	pageRecord=this.getPageRecord();
	pageNum=this.getPageNum();
}
public int getSumRecord() {
	odi=new OrderDAOImp();
	this.sumRecord=odi.selectAll().size();
	return sumRecord;
}

public int getPageRecord() {
	return pageRecord;
}
public int getPageNum() {
	if(sumRecord%pageRecord==0){
	  pageNum=sumRecord/pageRecord;
	}else{
	  pageNum=sumRecord/pageRecord+1;
	}
	return pageNum;
}

public List<Orders> getPageShow(int pageShow) {
		// TODO Auto-generated method stub
		   System.out.println("getPageShow"+pageShow);
			List<Orders> list=new ArrayList<Orders>() ;
			if(pageShow<1){
			 pageShow=1;
			}
			if(pageShow>this.getPageNum()){
			 pageShow=this.getPageNum();
			}
			try {
				
				con = db.getConnection();
			
				if (con == null) {
					
					return list;
				}
		
				stmt = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
				String sql = "select * from orders";
				rs = stmt.executeQuery(sql);
			
				int p=(pageShow-1)*this.getPageRecord()+1;
				rs.absolute(p);
				
				for(int i=0;(i<this.getPageRecord())&&(i+p<=this.getSumRecord());i++){
					
					
					Orders or = new Orders();

					int oid = rs.getInt(1);
					int mid = rs.getInt(2);
					int orderNo= rs.getInt(3);
					Timestamp orderdate=rs.getTimestamp(4);
					double sum=rs.getDouble(5);
					int orderstatus= rs.getInt(6);
					int dstatus= rs.getInt(7);
					int pay= rs.getInt(8);
					or.setOid(oid);
					or.setMid(mid);
					or.setOrderNo(orderNo);
					or.setOrderdate(orderdate);
					or.setOrderstatus(orderstatus);
					or.setDstatus(dstatus);
					or.setPay(pay);
					or.setSum(sum);
					list.add(or);
                    rs.next();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					
					if (stmt != null) {
						stmt.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				

			return list;
		
	}
   
}
