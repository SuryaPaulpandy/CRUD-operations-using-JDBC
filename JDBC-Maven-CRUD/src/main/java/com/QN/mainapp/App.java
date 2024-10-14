package com.QN.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws Exception{
    	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","root");
		System.out.println("Connection Established");
		
		String s = "select*from Student where name=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		System.out.println("Enter the name");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		pstmt.setString(1, name);
		ResultSet res = pstmt.executeQuery();
		
		if(res.next()) {
			int id = res.getInt(1);
			name = res.getString(2);
			int Marks1 = res.getInt(3);
			int Marks2 = res.getInt(4);
			int Marks3 = res.getInt(5);
			System.out.println(id+" "+name+" "+Marks1+" "+Marks2+" "+Marks3);
		}
		else {
			System.out.println("Invalid data");
		}
    }
}
