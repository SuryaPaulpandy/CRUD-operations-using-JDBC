package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//Update a data in a table
public class Update {
	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","root");
		System.out.println("Connection Established");
		String s = "Update Student Set name = ? Where id = ?";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id:");
		int id = sc.nextInt();
		System.out.println("Enter the Name:");
		String name = sc.next();
		pstmt.setString(1,name);
		pstmt.setInt(2,id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
		
	}
}
