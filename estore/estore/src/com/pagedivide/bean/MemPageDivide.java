package com.pagedivide.bean;



import com.dao.MemDAOImp;
import com.db.DBCon;
import com.entity.Member;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemPageDivide {
   private int sumRecord;
   private int pageRecord=6;
   private int pageNum;
   private int pageShow;
	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	MemDAOImp mdi=null;
public MemPageDivide() {
	super();
	sumRecord=this.getSumRecord();
	pageRecord=this.getPageRecord();
	pageNum=this.getPageNum();
}
public int getSumRecord() {
	mdi=new MemDAOImp();
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

public List<Member> getPageShow(int pageShow) {
		// TODO Auto-generated method stub
		   System.out.println("getPageShow"+pageShow);
			List<Member> list=new ArrayList<Member>() ;
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
				String sql = "select * from member";
				rs = stmt.executeQuery(sql);
			
				int p=(pageShow-1)*this.getPageRecord()+1;
				rs.absolute(p);
				
				for(int i=0;(i<this.getPageRecord())&&(i+p<=this.getSumRecord());i++){
					
					
					Member mem = new Member();
					
					int mid = rs.getInt(1);
					String mlevel = rs.getString(2);
					String loginName = rs.getString(3);
					String loginPwd = rs.getString(4);
					String mName = rs.getString(5);
					int phone = rs.getInt(6);
					String address = rs.getString(7);
					String email = rs.getString(8);
					int intergal = rs.getInt(9);
					mem.setLoginName(loginName);
					mem.setMid(mid);
					mem.setLoginPwd(loginPwd);
					mem.setEmail(email);
					mem.setPhone(phone);
					mem.setAddress(address);
					mem.setMlevel(mlevel);
					mem.setmName(mName);
					mem.setIntergal(intergal);

					list.add(mem);
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
