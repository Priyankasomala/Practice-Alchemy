package com.dxc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class empdelete {

	public static void main(String[] args) {
int id;
Scanner sc = new Scanner(System.in);  
	System.out.println("Enter employee id");
	id=sc.nextInt();

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employdetails","root","root");
	String cmd="delete from Employ where id = ?";
	PreparedStatement pst=conn.prepareStatement(cmd);
	pst.setInt(1, id);
	pst.executeUpdate();
	System.out.println("Record Successfully Deleted ");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
	
}catch(SQLException e) {
	e.printStackTrace();
}
	}

}
