package rtu.tldb.db.application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class CallProcedure {

	Alert alertDialog;
	
	public int callCalculateWay(String callsign) {
		
		int wayLength = 0;
		
		try {
			Connection conn = DBConnection.getDBConnection();
			CallableStatement cstmt = conn.prepareCall("{? = call f_get_way_length (?)}");
			
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, callsign);
			cstmt.executeUpdate();
			wayLength = cstmt.getInt(1);
			
			conn.close();
			
		} catch (Exception e) {
			alertDialog = new Alert(AlertType.ERROR, "Error in the data insertion", ButtonType.OK);
		}
		
		return wayLength;
		
	}

}
