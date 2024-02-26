package com.dxc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Empinsert {

	public static void main(String[] args) {
		int id;
		String name;
		String address;
		double salary;
		
Scanner sc=new Scanner(System.in);		
System.out.println("Enter employee no");
id=sc.nextInt();
System.out.println("Enter employee name");
name=sc.next();
System.out.println("enter employee address");
address=sc.next();
System.out.println("enter employee salary");
salary=sc.nextDouble();
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employdetails","root","root");
	String cmd="insert into Employ(id,name,address,salary)  "+"values(?,?,?,?)";
	PreparedStatement pst=conn.prepareStatement(cmd);
	pst.setInt(1, id);
	pst.setString(2,name);
	pst.setString(3,address);
	pst.setDouble(4, salary);
	pst.executeUpdate();
	System.out.println("Record Updated");
}catch(ClassNotFoundException e) {
e.printStackTrace();	
}catch(SQLException e) {
	e.printStackTrace();
}
	}

}
