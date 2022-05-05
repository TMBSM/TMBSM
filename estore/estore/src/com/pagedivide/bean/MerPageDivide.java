package com.pagedivide.bean;


import com.dao.MerDAOImp;
import com.db.DBCon;
import com.entity.Merchandise;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MerPageDivide {
   private int sumRecord;
   private int pageRecord=3;
   private int pageNum;
   private int pageShow;
	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	MerDAOImp mdi=null;
public MerPageDivide() {
	super();
	sumRecord=this.getSumRecord();
	pageRecord=this.getPageRecord();
	pageNum=this.getPageNum();
}
public int getSumRecord() {
	mdi=new MerDAOImp();
	this.sumRecord=mdi.selectAll().size();
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

public List<Merchandise> getPageShow(int pageShow) {
		// TODO Auto-generated method stub
		   System.out.println("getPageShow"+pageShow);
			List<Merchandise> list=new ArrayList<Merchandise>() ;
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
				String sql = "select * from merchandise";
				rs = stmt.executeQuery(sql);
			
				int p=(pageShow-1)*this.getPageRecord()+1;
				rs.absolute(p);
				
				for(int i=0;(i<this.getPageRecord())&&(i+p<=this.getSumRecord());i++){
					
					
					Merchandise mer = new Merchandise();
					
					int gid = rs.getInt(1);
					int category = rs.getInt(2);
					String mername = rs.getString(3);
					double price = rs.getDouble(4);
					double sprice = rs.getDouble(5);
					String picture = rs.getString(6);
					String merdesc = rs.getString(7);
					String manufacturer = rs.getString(8);
					int special=rs.getInt(9);
					mer.setGid(gid);
					mer.setCategory(category);
					mer.setMername(mername);
					mer.setPrice(price);
					mer.setSprice(sprice);
					mer.setPicture(picture);
					mer.setMerdesc(merdesc);
					mer.setManufacturer(manufacturer);
					mer.setSpecial(special);
					list.add(mer);
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
