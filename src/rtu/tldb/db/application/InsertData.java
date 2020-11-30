package rtu.tldb.db.application;

import java.sql.Connection;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import rtu.tldb.db.application.entities.PilotTable;

public class InsertData {
	
	Alert alertDialog;
	
	public void insertNewPilot(PilotTable pilot) {
		
		try {
			Connection conn = DBConnection.getDBConnection();
			Statement stmt = conn.createStatement();
			
			String insertPilotQuery = 
					String.format("INSERT INTO PILOT_TABLE VALUES(PILOT(%d, '%s', '%s', %.0f, '%s', null))", 
							pilot.getPilotId(), pilot.getPilotName(), pilot.getPilotSurname(), pilot.getPilotAge(), pilot.getPilotLevel());
			
			stmt.executeUpdate(insertPilotQuery);
			
			conn.close();
			
		} catch (Exception e) {
			alertDialog = new Alert(AlertType.ERROR, "Error in the data insertion", ButtonType.OK);
		}
		
	}

}
