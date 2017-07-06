package com.aliv.responsecode;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "response_code", uniqueConstraints = @UniqueConstraint(columnNames = { "response_code" }))
@Component
public class ResponseCodeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private long recid;

	@Column(name = "response_code")
	private String code;

	@Column(name = "response_description")
	private String description;

	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date lastModifiedDate;

	@Column(name = "modeified_by")
	private int lastModifiedBy;

	@Column(name = "deleted")
	private int deleted = 0;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public ResponseCodeModel(String code, String description, Date lastModifiedDate, int lastModifiedBy, int deleted) {

		this.code = code;
		this.description = description;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
		this.deleted = deleted;
	}

	public ResponseCodeModel() {

	}

	// get class model
	public ResponseCodeModel getClassObj() {
		return new ResponseCodeModel();
	}

	@Override
	public String toString() {
		return "ResponseCodeModel [recid=" + recid + ", code=" + code + ", description=" + description
				+ ", lastModifiedDate=" + lastModifiedDate + ", lastModifiedBy=" + lastModifiedBy + ", deleted="
				+ deleted + "]";
	}

}
