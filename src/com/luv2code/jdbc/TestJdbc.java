package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		// basic hibernate
	//	String jdbcUrl="jdbc:mysql://localhost:3306/projectdb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		
		
		// advance hibernate (OneToOne )
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_01_one_to_one_uni?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		
		String user="root";
		String pass= "root";
		
		try {
			
			System.out.println("Connecting to database :"+jdbcUrl);
			Connection myConn= DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection Successfull");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
