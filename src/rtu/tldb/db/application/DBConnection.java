package rtu.tldb.db.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DB_CONNECTION = "jdbc:oracle:thin:@85.254.218.229:1521:DITF11";
	public static final String DB_USER = "DB_200AEB004";
	public static final String DB_PASSWORD = "DB_200AEB004";
	
	public static Connection getDBConnection() {
		
		Connection dbConnection = null;
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error driver JDBC: " + e.getMessage());
		}
		
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println("Cannot open connection: " + e.getMessage());
		}
		
		return dbConnection;
	}

}
