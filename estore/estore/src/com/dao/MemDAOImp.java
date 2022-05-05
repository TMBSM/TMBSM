	package com.dao;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import com.db.DBCon;
import com.entity.Member;
import com.entity.Merchandise;
	
	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class MemDAOImp implements MemDAO {


		DBCon db = new DBCon();
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		public List<Member> selectAll() {

			List<Member> list = new ArrayList<Member>();
			try {

				con = db.getConnection();

				if (con == null) {

					return list;
				}

				stmt = (Statement) con.createStatement();
				String sql = "select * from member";
				rs = stmt.executeQuery(sql);

				while (rs.next()) {

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

		public boolean insert(Member mem) {

			boolean flag = false;
			try {

				con = db.getConnection();
				if (con == null) {

					return flag;
				}

				String sql = "insert into member(loginName,loginPwd,mName,phone,address,email) values(?,?,?,?,?,?)";

				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, mem.getLoginName());
				pstmt.setString(2, mem.getLoginPwd());
				pstmt.setString(3, mem.getmName());
				pstmt.setInt(4, mem.getPhone());
				pstmt.setString(5, mem.getAddress());
				pstmt.setString(6, mem.getEmail());

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
		public boolean delete(int mid) {

			boolean flag = false;
			try {
				con = db.getConnection();
				if (con == null) {

					return flag;
				}
				String sql = "delete from member where mid=?";
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setInt(1, mid);
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
		public Member selectByMid(int mid) {

			Member mem = null;
			try {
				con = db.getConnection();
				if (con == null) {

					return null;
				}
				String sql = "select * from member where mid=?";
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setInt(1, mid);
				rs = pstmt.executeQuery();
				if (rs.next()) {

					mem = new Member();
					
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
			return mem;
		}

		public boolean update(int mid,int intergal) {

			boolean flag = false;
			try {
				con = db.getConnection();
				if (con == null) {

					return flag;
				}
				String sql = "update member set intergal=? where mid=?";
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setInt(1, intergal);

				pstmt.setInt(2,mid);

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

		public boolean isExistA(String name, String passwd) {
			// TODO Auto-generated method stub
			boolean flag = false;
			try {
				con = db.getConnection();
				if (con == null) {

					return flag;
				}
				String sql = "select * from member where loginName=? and loginPwd=?";
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, name);

				pstmt.setString(2,passwd);

				rs=pstmt.executeQuery();
				if (rs.next()) {

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

		public Member selectByName(String name) {

			Member mem = null;
			try {
				con = db.getConnection();
				if (con == null) {

					return null;
				}
				String sql = "select * from member where loginName=?";
				pstmt = (PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				if (rs.next()) {

					mem = new Member();
					int mid=rs.getInt(1);
					String mlevel = rs.getString(2);
					String loginPwd = rs.getString(4);
					String mName = rs.getString(5);
					int phone = rs.getInt(6);
					String address = rs.getString(7);
					String email = rs.getString(8);
					int intergal = rs.getInt(9);
					mem.setLoginName(name);
					mem.setMid(mid);
					mem.setLoginPwd(loginPwd);
					mem.setEmail(email);
					mem.setPhone(phone);
					mem.setAddress(address);
					mem.setMlevel(mlevel);
					mem.setmName(mName);
					mem.setIntergal(intergal);

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
			return mem;
		}

		public List<Member> select(String content) {
			con=db.getConnection();
			List<Member> list=new ArrayList<Member>();
			String sql="select * from member where loginName like ?";
			try {
				pstmt=(PreparedStatement) con.prepareStatement(sql);
				pstmt.setString(1,"%"+content+"%");
				rs=pstmt.executeQuery();
				while(rs.next()){
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


