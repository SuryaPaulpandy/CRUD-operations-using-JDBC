package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//Transactions - refers to the set of statements that have to be compulsoryly executed.
//			   - in transactions either everything should be executed or nothing should be executed.

public class Transactions {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","root");
		
		con.setAutoCommit(false);
		Scanner sc = new Scanner(System.in);
		String s = "Insert into Student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(s);
		
		System.out.println("Enter the id");
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
		pstmt.executeUpdate();
		
		String s1 = "Insert into Student values(?,?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s1);
		
		System.out.println("Enter the id");
		id = sc.nextInt();
		System.out.println("Enter the name");
		name = sc.next();
		System.out.println("Enter the Marks1");
		Marks1 = sc.nextInt();
		System.out.println("Enter the Marks2");
		Marks2 = sc.nextInt();
		System.out.println("Enter the Marks3");
		Marks3 = sc.nextInt();
		
		pstmt1.setInt(1,id);
		pstmt1.setString(2,name);
		pstmt1.setInt(3,Marks1);
		pstmt1.setInt(4,Marks2);
		pstmt1.setInt(5,Marks3);
		pstmt1.executeUpdate();
		
		con.commit();
	}

}
