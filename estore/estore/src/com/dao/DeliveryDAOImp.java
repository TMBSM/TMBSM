package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.db.DBCon;
import com.entity.Delivery;
import com.entity.Member;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DeliveryDAOImp implements DeliveryDAO {

	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<Delivery> selectAll() {

		List<Delivery> list = new ArrayList<Delivery>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}

			stmt = (Statement) con.createStatement();
			String sql = "select * from delivery";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Delivery de = new Delivery();

				int did = rs.getInt(1);
				String dname = rs.getString(2);
				double dprice = rs.getDouble(3);
				de.setDid(did);
				de.setDname(dname);
				de.setDprice(dprice);
				list.add(de);

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

	
	// pstmt
	public boolean delete(int did) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "delete from delivery where did=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, did);
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
	public Delivery selectByDid(int did) {

		Delivery de = null;
		try {
			con = db.getConnection();
			if (con == null) {

				return null;
			}
			String sql = "select * from delivery where did=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, did);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				de = new Delivery();
				String dname = rs.getString(2);
				double dprice = rs.getDouble(3);
				de.setDid(did);
				de.setDname(dname);
				de.setDprice(dprice);

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
		return de;
	}

	public boolean update(int did,double dprice) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "update delivery set dprice=? where did=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setDouble(1, dprice);

			pstmt.setInt(2,did);

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


	public double select(int did) {
		// TODO Auto-generated method stub
		double dprice = 0;
		try {
			con = db.getConnection();
			if (con == null) {

				return 0;
			}
			String sql = "select dprice from delivery where did=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, did);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				
				 dprice = rs.getDouble(1);
			

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
		return dprice;
	}

	public boolean insert(Delivery de) {

		boolean flag = false;
		try {

			con = db.getConnection();
			if (con == null) {

				return flag;
			}

			String sql = "insert into delivery(dname,dprice) values(?,?)";

			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1,de.getDname());
			pstmt.setDouble(2, de.getDprice());
			
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

}
