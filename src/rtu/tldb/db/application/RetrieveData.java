package rtu.tldb.db.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import rtu.tldb.db.application.entities.PilotTable;

public class RetrieveData {
	
	public static final String PILOT_QUERY = "SELECT * FROM PILOT_TABLE";
	public static final String AIRCRAFT_QUERY = "SELECT * FROM AIRCRAFT_TABLE";
	public static final String CALLSIGN_QUERY = "SELECT FP.CALLSIGN CALLSIGN FROM FLIGHT_PLAN_TABLE FP";
	
	public ObservableList<PilotTable> retrievePilots() {
		
		List<PilotTable> pilotList = new ArrayList<PilotTable>();
		
		try {
			Connection conn = DBConnection.getDBConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(PILOT_QUERY);
			
			while (rs.next()) {
				PilotTable pilot = new PilotTable();
				pilot.setPilotId(rs.getInt("PILOT_ID"));
				pilot.setPilotName(rs.getString("PILOT_NAME"));
				pilot.setPilotSurname(rs.getString("PILOT_SURNAME"));
				pilot.setPilotAge(rs.getBigDecimal("PILOT_AGE"));
				pilot.setPilotLevel(rs.getString("PILOT_LEVEL"));
				
				pilotList.add(pilot);
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ObservableList<PilotTable> finalPilotList = FXCollections.observableArrayList(pilotList);
		
		return finalPilotList;
	}
	
	public ObservableList<String> retrieveFPCallsigns() {
		List<String> callsignList = new ArrayList<String>();
		
		try {
			Connection conn = DBConnection.getDBConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(CALLSIGN_QUERY);
			
			while (rs.next()) {
				callsignList.add(rs.getString("CALLSIGN"));
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ObservableList<String> finalCallsignList = FXCollections.observableArrayList(callsignList);
		
		return finalCallsignList;
	}
	
}
