package com.dxc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Empsort2 {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Enter Emp name: ");
		
		String name = sc.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employdetails","root","Priyanka@123");
			
			String cmd = "select * from Employ where name = ?";
			
			
			PreparedStatement pst = conn.prepareStatement(cmd);
			pst.setString(1,name);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("EmpId: "+rs.getInt("id"));
				System.out.println("EmpName: "+rs.getString("name"));
				System.out.println("EmpSalary: "+rs.getDouble("salary"));
				System.out.println("Address: "+rs.getString("address"));
				
			}
			else {
				System.out.println("Record Not Found....");
			}
			
			while(rs.next()) {
				System.out.println("EmpId: "+rs.getInt("id"));
				System.out.println("EmpName: "+rs.getString("name"));
				System.out.println("EmpSalary: "+rs.getDouble("salary"));
				System.out.println("Address: "+rs.getString("address"));
			}
		} 
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
