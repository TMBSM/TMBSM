package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.DBCon;
import com.entity.Mlevel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MlevelDAOImp implements MlevelDAO {

	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<Mlevel> selectAll() {

		List<Mlevel> list = new ArrayList<Mlevel>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}

			stmt = (Statement) con.createStatement();
			String sql = "select * from memberlevel";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Mlevel ml = new Mlevel();

				int lid = rs.getInt(1);
				String levelname = rs.getString(2);
				double  favourable=rs.getDouble(3);
					ml.setLid(lid);
					ml.setLevelName(levelname);
					ml.setFavourable(favourable);
				list.add(ml);

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
	public boolean delete(int lid) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "delete from memberlevel where lid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, lid);
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
	public Mlevel selectByLid(int lid) {

		Mlevel ml = null;
		try {
			con = db.getConnection();
			if (con == null) {

				return null;
			}
			String sql = "select * from memebelevel where lid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, lid);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				ml = new Mlevel();

			
				String levelname = rs.getString(2);
				double  favourable=rs.getDouble(3);
					ml.setLid(lid);
					ml.setLevelName(levelname);
					ml.setFavourable(favourable);
			

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
		return ml;
	}

	public boolean update(int lid,double favourable) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "update memberlevel set favourable=? where lid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setDouble(1, favourable);
			pstmt.setInt(2, lid);

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

