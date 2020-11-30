package rtu.tldb.db.application.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class AuthorizationStatusTable implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private BigDecimal asOrder;

	private String asType;

	private String description;

	public AuthorizationStatusTable() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAsOrder() {
		return this.asOrder;
	}

	public void setAsOrder(BigDecimal asOrder) {
		this.asOrder = asOrder;
	}

	public String getAsType() {
		return this.asType;
	}

	public void setAsType(String asType) {
		this.asType = asType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}