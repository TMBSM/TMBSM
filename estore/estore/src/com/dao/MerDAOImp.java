package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.db.DBCon;
import com.entity.Merchandise;
import com.entity.Orders;
import com.entity.Shouye;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MerDAOImp implements MerchandiseDAO {

	DBCon db = new DBCon();
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<Merchandise> selectAll() {

		List<Merchandise> list = new ArrayList<Merchandise>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}

			stmt = (Statement) con.createStatement();
			String sql = "select * from merchandise";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Merchandise mer = new Merchandise();

				int gid = rs.getInt(1);
				int category = rs.getInt(2);
				String mername = rs.getString(3);
				double price = rs.getDouble(4);
				double sprice = rs.getDouble(5);
				String picture = rs.getString(6);
				String merdesc = rs.getString(7);
				String manufacturer = rs.getString(8);
				int special = rs.getInt(9);
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

	public boolean insert(Merchandise mer) {

		boolean flag = false;
		try {

			con = db.getConnection();
			if (con == null) {

				return flag;
			}

			String sql = "insert into merchandise(category,mername,price,sprice,picture,merdesc,manufacturer,special) values(?,?,?,?,?,?,?,?)";

			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, mer.getCategory());
			pstmt.setString(2, mer.getMername());
			pstmt.setDouble(3, mer.getPrice());
			pstmt.setDouble(4, mer.getSprice());
			pstmt.setString(5, mer.getPicture());
			pstmt.setString(6, mer.getMerdesc());
			pstmt.setString(7, mer.getManufacturer());
			pstmt.setInt(8, mer.getSpecial());

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
	public boolean delete(int gid) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "delete from merchandise where gid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, gid);
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
	public Merchandise selectByGid(int gid) {

		Merchandise mer = null;
		try {
			con = db.getConnection();
			if (con == null) {

				return null;
			}
			String sql = "select * from merchandise where gid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, gid);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				mer = new Merchandise();

				int category = rs.getInt(2);
				String mername = rs.getString(3);
				double price = rs.getDouble(4);
				double sprice = rs.getDouble(5);
				String picture = rs.getString(6);
				String merdesc = rs.getString(7);
				String manufacturer = rs.getString(8);
				int special = rs.getInt(9);
				mer.setGid(gid);
				mer.setCategory(category);
				mer.setMername(mername);
				mer.setPrice(price);
				mer.setSprice(sprice);
				mer.setPicture(picture);
				mer.setMerdesc(merdesc);
				mer.setManufacturer(manufacturer);
				mer.setSpecial(special);

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

	public boolean update(int gid,int special) {

		boolean flag = false;
		try {
			con = db.getConnection();
			if (con == null) {

				return flag;
			}
			String sql = "update merchandise set special=? where gid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, special);

			pstmt.setInt(2,gid);

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

	public List<Merchandise> selectByCategory(int category) {
		List<Merchandise> list = new ArrayList<Merchandise>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}

			
			String sql = "select * from merchandise where category=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Merchandise mer = new Merchandise();

				int gid = rs.getInt(1);
				String mername = rs.getString(3);
				double price = rs.getDouble(4);
				double sprice = rs.getDouble(5);
				String picture = rs.getString(6);
				String merdesc = rs.getString(7);
				String manufacturer = rs.getString(8);
				int special = rs.getInt(9);
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

	public List<Shouye> selectById(int minid, int maxid) {
		List<Shouye> list = new ArrayList<Shouye>();
		try {

			con = db.getConnection();

			if (con == null) {

				return list;
			}
			String sql = "select * from shouye where sid<=? and sid>=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, maxid);
			pstmt.setInt(2, minid);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Shouye sy = new Shouye();

				int sid = rs.getInt(1);
				String name = rs.getString(2);
				String sno = rs.getString(3);
				String snation = rs.getString(4);
				String scity = rs.getString(5);
				String scolor = rs.getString(6);
				String ssize = rs.getString(7);
				Date sdate = rs.getDate(8);
				String scharact = rs.getString(9);
				String sother = rs.getString(10);
				String spic = rs.getString(11);
				double sprice=rs.getDouble(12);
				sy.setName(name);
				sy.setScharact(scharact);
				sy.setScity(scity);
				sy.setScolor(scolor);
				sy.setSsize(ssize);
				sy.setSpic(spic);
				sy.setSother(sother);
				sy.setSno(sno);
				sy.setSid(sid);
				sy.setSdate(sdate);
				sy.setSnation(snation);
				sy.setSprice(sprice);
				list.add(sy);

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

	public Shouye selectBySid(int sid) { 
		Shouye sy=null;
		try {

			con = db.getConnection();

			if (con == null) {

				return sy;
			}

			String sql = "select * from shouye where sid=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				sy = new Shouye();
				String name = rs.getString(2);
				String sno = rs.getString(3);
				String snation = rs.getString(4);
				String scity = rs.getString(5);
				String scolor = rs.getString(6);
				String ssize = rs.getString(7);
				Date sdate = rs.getDate(8);
				String scharact = rs.getString(9);
				String sother = rs.getString(10);
				String spic = rs.getString(11);
				double sprice=rs.getDouble(12);
				sy.setName(name);
				sy.setScharact(scharact);
				sy.setScity(scity);
				sy.setScolor(scolor);
				sy.setSsize(ssize);
				sy.setSpic(spic);
				sy.setSother(sother);
				sy.setSno(sno);
				sy.setSid(sid);
				sy.setSdate(sdate);
				sy.setSnation(snation);
				sy.setSprice(sprice);

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

		return sy;
	}

	public List<Merchandise> select(String content) {
		con=db.getConnection();
		List<Merchandise> list5=new ArrayList<Merchandise>();
		String sql="select * from merchandise where mername like ?";
		try {
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1,"%"+content+"%");
			rs=pstmt.executeQuery();
			while(rs.next()){
				Merchandise mer = new Merchandise();

				int gid = rs.getInt(1);
				int category = rs.getInt(2);
				String mername = rs.getString(3);
				double price = rs.getDouble(4);
				double sprice = rs.getDouble(5);
				String picture = rs.getString(6);
				String merdesc = rs.getString(7);
				String manufacturer = rs.getString(8);
				int special = rs.getInt(9);
				mer.setGid(gid);
				mer.setCategory(category);
				mer.setMername(mername);
				mer.setPrice(price);
				mer.setSprice(sprice);
				mer.setPicture(picture);
				mer.setMerdesc(merdesc);
				mer.setManufacturer(manufacturer);
				mer.setSpecial(special);
				list5.add(mer);
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
		return list5;
	}

}
