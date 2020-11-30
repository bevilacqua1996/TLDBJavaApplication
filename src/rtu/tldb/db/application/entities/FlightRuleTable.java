package rtu.tldb.db.application.entities;

import java.io.Serializable;

public class FlightRuleTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String description;

	public FlightRuleTable() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}