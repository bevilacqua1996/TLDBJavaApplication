package rtu.tldb.db.application.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class PilotTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private long pilotId;

	private BigDecimal pilotAge;

	private AircraftTable pilotAircraft;

	private String pilotLevel;

	private String pilotName;

	private String pilotSurname;

	public PilotTable() {
	}

	public long getPilotId() {
		return this.pilotId;
	}

	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}

	public BigDecimal getPilotAge() {
		return this.pilotAge;
	}

	public void setPilotAge(BigDecimal pilotAge) {
		this.pilotAge = pilotAge;
	}

	public AircraftTable getPilotAircraft() {
		return this.pilotAircraft;
	}

	public void setPilotAircraft(AircraftTable pilotAircraft) {
		this.pilotAircraft = pilotAircraft;
	}

	public String getPilotLevel() {
		return this.pilotLevel;
	}

	public void setPilotLevel(String pilotLevel) {
		this.pilotLevel = pilotLevel;
	}

	public String getPilotName() {
		return this.pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getPilotSurname() {
		return this.pilotSurname;
	}

	public void setPilotSurname(String pilotSurname) {
		this.pilotSurname = pilotSurname;
	}

}