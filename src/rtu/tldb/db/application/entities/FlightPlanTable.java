package rtu.tldb.db.application.entities;

import java.io.Serializable;
import java.util.Date;


public class FlightPlanTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private long flightPlanId;

	private String adep;

	private String ades;

	private Object airwayList;

	private AircraftOperationTable aoKey;

	private AuthorizationStatusTable asKey;

	private String callsign;

	private Date creationDate;

	private String eet;

	private String eobt;

	private FlightRuleTable frKey;

	private FlightTypeTable ftKey;

	private PilotTable pilotKey;

	public FlightPlanTable() {
	}

	public long getFlightPlanId() {
		return this.flightPlanId;
	}

	public void setFlightPlanId(long flightPlanId) {
		this.flightPlanId = flightPlanId;
	}

	public String getAdep() {
		return this.adep;
	}

	public void setAdep(String adep) {
		this.adep = adep;
	}

	public String getAdes() {
		return this.ades;
	}

	public void setAdes(String ades) {
		this.ades = ades;
	}

	public Object getAirwayList() {
		return this.airwayList;
	}

	public void setAirwayList(Object airwayList) {
		this.airwayList = airwayList;
	}


	public String getCallsign() {
		return this.callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEet() {
		return this.eet;
	}

	public void setEet(String eet) {
		this.eet = eet;
	}

	public String getEobt() {
		return this.eobt;
	}

	public void setEobt(String eobt) {
		this.eobt = eobt;
	}

	public AircraftOperationTable getAoKey() {
		return aoKey;
	}

	public void setAoKey(AircraftOperationTable aoKey) {
		this.aoKey = aoKey;
	}

	public AuthorizationStatusTable getAsKey() {
		return asKey;
	}

	public void setAsKey(AuthorizationStatusTable asKey) {
		this.asKey = asKey;
	}

	public FlightRuleTable getFrKey() {
		return frKey;
	}

	public void setFrKey(FlightRuleTable frKey) {
		this.frKey = frKey;
	}

	public FlightTypeTable getFtKey() {
		return ftKey;
	}

	public void setFtKey(FlightTypeTable ftKey) {
		this.ftKey = ftKey;
	}

	public PilotTable getPilotKey() {
		return pilotKey;
	}

	public void setPilotKey(PilotTable pilotKey) {
		this.pilotKey = pilotKey;
	}

}