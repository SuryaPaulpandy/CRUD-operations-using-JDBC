package Jdbc;

//Inserting data into table Student

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insertion {
	public static void main(String[] args) throws Exception{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	System.out.println("Driver Loaded");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","root");
	System.out.println("Connection Established");
	String s = "Insert into Student values(?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(s);
	System.out.println("Enter the id");
	Scanner sc = new Scanner(System.in);
	int id = sc.nextInt();
	System.out.println("Enter the name");
	String name = sc.next();
	System.out.println("Enter the Marks1");
	int Marks1 = sc.nextInt();
	System.out.println("Enter the Marks2");
	int Marks2 = sc.nextInt();
	System.out.println("Enter the Marks3");
	int Marks3 = sc.nextInt();
	
	pstmt.setInt(1,id);
	pstmt.setString(2,name);
	pstmt.setInt(3,Marks1);
	pstmt.setInt(4,Marks2);
	pstmt.setInt(5,Marks3);
	int rows = pstmt.executeUpdate();
	System.out.println(rows);
	}
}
