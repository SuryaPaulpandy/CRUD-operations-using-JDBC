package Jdbc;

//Deleting a Row from the Table
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","root");
		System.out.println("Connection Established");
		String s ="Delete From Student Where id = ?";
		PreparedStatement pstmt = con.prepareStatement(s);
		System.out.println("Enter the Id:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		pstmt.setInt(1, id);
		int rows = pstmt.executeUpdate();
		System.out.println(rows+"Row deleted");
	}

}
