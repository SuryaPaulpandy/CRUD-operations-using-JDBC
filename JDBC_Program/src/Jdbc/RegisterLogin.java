package Jdbc;

//Registration and Login 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterLogin {
	public static void main(String[] args) throws Exception {

//Give the Choices , Register or Login		
		Scanner sc = new Scanner(System.in);
		System.out.println("1-Register");
		System.out.println("2-Login");
		System.out.println("Enter your choice:");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			register();
			break;
		case 2:
			login();
			break;
		default:
			System.out.println("Enter the given choice only");
			break;

		}
	}

//Register
	static void register() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "root");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = sc.next();
		System.out.println("Enter username:");
		String username = sc.next();

		while (true) {
			String s = "select * from Users where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				System.out.println("Username already exists.Please enter another username");
				username = sc.next();
			} else {
				break;
			}
		}
		String password;
		String confirmPassword;
		do {
			System.out.println("Enter the Password:");
			password = sc.next();
			System.out.println("Re-enter Password:");
			confirmPassword = sc.next();
		} while (!password.equals(confirmPassword));

		System.out.println("Enter email:");
		String email = sc.next();

		String s1 = "Insert into Users Values(?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s1);
		pstmt1.setString(1, name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		pstmt1.executeUpdate();

		System.out.println("Registered Successfully");
	}

//Login	
	static void login() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "root");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter username:");
		String username = sc.next();
		ResultSet res1;
		do {
			String s = "select * from Users where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			res1 = pstmt.executeQuery();

			if (!res1.next()) {
				System.out.println("Invalid Username");
				username = sc.next();
			}
		} while (res1.next());

		System.out.println("Enter Password:");
		String password = sc.next();
		ResultSet res2;
		do {
			String s2 = "select * from Users where password=?";
			PreparedStatement pstmt1 = con.prepareStatement(s2);
			pstmt1.setString(1, password);
			res2 = pstmt1.executeQuery();

			if (!res2.next()) {
				System.out.println("Invalid Password");
				password = sc.next();
			}
		} while (res2.next());

		System.out.println("Login Successful");

	}
}
