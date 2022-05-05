package com.db;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class DBCon {
	Connection con=null;
	public Connection getConnection(){
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			con= (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_store?useUnicode=true&characterEncoding=utf-8",
					"root",
					"88492033wszsdr@@"
					);
			
			
			
			//Class.forName("net.sourceforge.jtds.jdbc.Driver");
			//con= DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/db_stuinfo","sa", "123");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("NO");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("NO");
			e.printStackTrace();
		}
	
	return con;
	   
		
		
	}
	

}
