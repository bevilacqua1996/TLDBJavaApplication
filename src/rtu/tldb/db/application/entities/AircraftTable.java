package rtu.tldb.db.application.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class AircraftTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private long aircraftId;

	private BigDecimal aircraftCapacity;

	private String aircraftName;

	private BigDecimal aircraftSize;

	private Object aircraftWakeTurbulence;

	public AircraftTable() {
	}

	public long getAircraftId() {
		return this.aircraftId;
	}

	public void setAircraftId(long aircraftId) {
		this.aircraftId = aircraftId;
	}

	public BigDecimal getAircraftCapacity() {
		return this.aircraftCapacity;
	}

	public void setAircraftCapacity(BigDecimal aircraftCapacity) {
		this.aircraftCapacity = aircraftCapacity;
	}

	public String getAircraftName() {
		return this.aircraftName;
	}

	public void setAircraftName(String aircraftName) {
		this.aircraftName = aircraftName;
	}

	public BigDecimal getAircraftSize() {
		return this.aircraftSize;
	}

	public void setAircraftSize(BigDecimal aircraftSize) {
		this.aircraftSize = aircraftSize;
	}

	public Object getAircraftWakeTurbulence() {
		return this.aircraftWakeTurbulence;
	}

	public void setAircraftWakeTurbulence(Object aircraftWakeTurbulence) {
		this.aircraftWakeTurbulence = aircraftWakeTurbulence;
	}

}