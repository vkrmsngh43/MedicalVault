package com.pe.medical.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_access_request_records")
public class AccessRequestRecords extends BaseDao{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "requested_by_user_id")
	private User requestedBy;
	
	@Column(name = "access_code")
	private String accessCode;
	
	@Column(name = "access_code_generated_at")
	private Date accessCodeGeneratedAt;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "access_code_ttl")
	private int accessCodeTtl;
	
	@Column(name = "created_at")
	private Date createdDate;
	
	//Default constructor
	public AccessRequestRecords() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public Date getAccessCodeGeneratedAt() {
		return accessCodeGeneratedAt;
	}

	public void setAccessCodeGeneratedAt(Date accessCodeGeneratedAt) {
		this.accessCodeGeneratedAt = accessCodeGeneratedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getAccessCodeTtl() {
		return accessCodeTtl;
	}
	public void setAccessCodeTtl(int accessCodeTtl) {
		this.accessCodeTtl = accessCodeTtl;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
