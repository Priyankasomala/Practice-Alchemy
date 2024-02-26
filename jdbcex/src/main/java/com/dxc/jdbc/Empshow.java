package com.dxc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Empshow {
	public static void main(String [] args) {
 try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employdetails","root","Priyanka@123");
	String cmd="select * from Employ; ";
	PreparedStatement pst=conn.prepareStatement(cmd);
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {
		System.out.println("Employ id " +rs.getInt("id"));
		System.out.println("Employ name " +rs.getString("name"));
		System.out.println("Employ salary " +rs.getDouble("salary"));
		System.out.println("Employ address " +rs.getString("address"));
		System.out.println("-----------");
	}
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}
}
