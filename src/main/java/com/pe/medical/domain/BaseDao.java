package com.pe.medical.domain;

import java.util.Date;

import javax.persistence.Column;

public class BaseDao {
	
	@Column(name = "created_at")
	private Date createdDate;
	
	@Column(name = "modified_at")
	private Date modifiedDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	

}
