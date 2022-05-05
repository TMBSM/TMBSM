package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;


import com.db.DBCon;
import com.entity.Orders;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class OrderDAOImp implements OrderDAO {

	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<Orders> selectAll() {

		List<Orders> list = new ArrayList<Orders>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}

			stmt = (Statement) con.createStatement();
			String sql = "select * from orders";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

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

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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

	public boolean insert(Orders or) {

		boolean flag = false;
		try {

			con = db.getConnection();
			if (con == null) {

				return flag;
			}

			String sql = "insert into orders(mid,orderNo,orderdate,sum,orderstatus,dstatus,pay) values(?,?,?,?,?,?,?)";

			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, or.getMid());
			pstmt.setInt(2, or.getOrderNo());
			pstmt.setTimestamp(3, or.getOrderdate());
			pstmt.setDouble(4, or.getSum());
			pstmt.setInt(5, or.getOrderstatus());
			pstmt.setInt(6, or.getDstatus());
			pstmt.setInt(7, or.getPay());

			// pstmt.executeQuery() ִ��select
			int state = pstmt.executeUpdate();
			if (state > 0) {

				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
		return flag;
	}

	// pstmt
	public boolean delete(int oid) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "delete from orders where oid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, oid);
			int state = pstmt.executeUpdate();
			if (state > 0) {

				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
		return flag;
	}

	// pstmt
	public Orders selectByOid(int oid) {

		Orders mer = null;
		try {
			con = db.getConnection();
			if (con == null) {

				return null;
			}
			String sql = "select * from orders where oid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, oid);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				Orders or = new Orders();

				
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

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
		return mer;
	}

	public boolean update(int oid,int orderstatus,int dstatus,int pay) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "update orders set orderstatus=?,dstatus=?,pay=? where oid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, orderstatus);
			pstmt.setInt(2,dstatus);
			pstmt.setInt(3,pay);
			pstmt.setInt(4,oid);

			int state = pstmt.executeUpdate();
			if (state > 0) {

				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
		return flag;
	}

	public List<Orders> select(String content) {
			con=db.getConnection();
			List<Orders> list=new ArrayList<Orders>();
			String sql="select * from orders where mid like ?";
			try {
				pstmt=(PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1,"%"+content+"%");
				rs=pstmt.executeQuery();
				while(rs.next()){
					Orders or=new Orders();
					int oid=rs.getInt(1);
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
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(pstmt!=null)pstmt.close();
					if(stmt!=null)stmt.close();
					if(rs!=null)rs.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return list;
		}
}
