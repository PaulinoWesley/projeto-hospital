package com.br.hospital.wesley.repository.purejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MyConnection {
	private static Connection conn;
		
	public static Connection getInstance() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=N01teQu3nt3";
		if (conn == null) {
			conn = DriverManager.getConnection(connectionUrl);
		}
		return conn;
	}
}
