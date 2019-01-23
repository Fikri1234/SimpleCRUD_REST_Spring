/**
 * 
 */
package com.example.project.DTO;

import java.util.Date;

import com.example.project.Entity.EmbeddEntity;

/**
 * @author FIKRI-PC
 *
 */
public class EmbeddDTO {
	
	private Date createdDate;
	private Date lastUpdate;
	
	public EmbeddDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmbeddDTO(EmbeddEntity embeddEntity) {
		super();
		this.createdDate = embeddEntity.getCreatedDate();
		this.lastUpdate = embeddEntity.getLastUpdate();
	}
	
	public EmbeddDTO(String createdBy, Date createdDate, String updatedBy, Date lastUpdated) {
		super();
		this.createdDate = createdDate;
		this.lastUpdate = lastUpdated;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
