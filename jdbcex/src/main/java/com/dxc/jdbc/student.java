package com.dxc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class student {
	public static void main(String [] args) throws ClassNotFoundException {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Interns","root","Priyanka@123");
		String cmd ="select * from Trainee";
		PreparedStatement pst =conn.prepareStatement(cmd);
		ResultSet rs =pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getInt("age"));
		}
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		
		
	}

}

