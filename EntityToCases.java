package com.test.management.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Entities_To_Cases")
@Component
public class EntityToCases {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	public int serial;
	
    @Column(name = "case_number", nullable = false)
	public String caseNumber;
    
    @Column(name = "entity_id", nullable = false)
	public int entityId;

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	
    
}
