/**
 * 
 */
package com.example.project.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author FIKRI-PC
 *
 */

@Embeddable
public class EmbeddEntity {
	
	private Date createdDate;
	private Date lastUpdate;
	
	public EmbeddEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmbeddEntity(Date lastUpdate) {
		super();
		this.lastUpdate = lastUpdate;
	}
	
	public EmbeddEntity(Date lastUpdate, Date createdDate) {
		super();
		this.lastUpdate = lastUpdate;
		this.createdDate = createdDate;
	}

	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "last_update")
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
