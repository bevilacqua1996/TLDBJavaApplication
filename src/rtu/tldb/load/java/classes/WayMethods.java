package rtu.tldb.load.java.classes;

import java.sql.*;

public class WayMethods {
	
	public static String getClassification(Integer length) throws SQLException {
		String classification = "";
		
		if(length <= 300) {
			classification = "Short way";
		} else if(length > 300 && length <= 400) {
			classification = "Medium Way";
		} else {
			classification = "Long Way";
		}
		
		return classification; 
		
	}

}
