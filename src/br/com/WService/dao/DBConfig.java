package br.com.WService.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class DBConfig {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ws", "postgres","admin");
	}
	
	
}
