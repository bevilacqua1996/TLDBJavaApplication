package rtu.tldb.load.java.classes;

import java.sql.*;

public class FlightPlanTrigger {
	
	public static String informInsertionSuccessful(Integer flightPlanId) throws SQLException {
		
		return String.format("Current line (Flight Plan ID: %d) inserted successfull!", flightPlanId);
		
	}

}
