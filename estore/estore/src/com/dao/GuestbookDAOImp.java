package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.db.DBCon;
import com.entity.Category;
import com.entity.Guestbook;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class GuestbookDAOImp implements GuestbookDAO {

	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<Guestbook> selectAll() {

		List<Guestbook> list = new ArrayList<Guestbook>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}

			stmt = (Statement) con.createStatement();
			String sql = "select * from guestbook";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Guestbook gb = new Guestbook();

				int wid = rs.getInt(1);
				int mid = rs.getInt(2);
				String content = rs.getString(3);
				String answerContent = rs.getString(4);
				gb.setWid(wid);
				gb.setMid(mid);
				gb.setContent(content);
				gb.setAnswerContent(answerContent);
				list.add(gb);

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
	public boolean delete(int wid) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "delete from guestbook where wid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, wid);
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
	public Guestbook selectByWid(int wid) {

		Guestbook gb = null;
		try {
			con = db.getConnection();
			if (con == null) {

				return null;
			}
			String sql = "select * from guestbook where wid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, wid);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				 gb = new Guestbook();
				int mid = rs.getInt(2);
				String content = rs.getString(3);
				String answerContent = rs.getString(4);
				gb.setWid(wid);
				gb.setMid(mid);
				gb.setContent(content);
				gb.setAnswerContent(answerContent);

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
		return gb;
	}

	public boolean update(int wid,String answerContent) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "update guestbook set answerContent=? where wid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			
			pstmt.setString(1, answerContent);
			pstmt.setInt(2, wid);

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


	public boolean insert(Guestbook gb) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		try {

			con = db.getConnection();
			if (con == null) {

				return flag;
			}

			String sql = "insert into guestbook(mid,content) values(?,?)";

			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, gb.getMid());
			pstmt.setString(2, gb.getContent());

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

