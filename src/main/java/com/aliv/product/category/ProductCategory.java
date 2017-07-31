package com.aliv.product.category;

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
@Table(name = "PCAT", uniqueConstraints = @UniqueConstraint(columnNames = { "productCode" }))
@Component
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recid")
	private long id;

	@Column(name = "product_category_code")
	private String pCatCode;
	
	@Column(name = "product_category_name")
	private String name;

	@Column(name = "last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date lastModifiedDate;

	@Column(name = "creted_by")
	private int createdBy;

	@Column(name = "deleted")
	private int deleted;

	public String getpCatCode() {
		return pCatCode;
	}

	public void setpCatCode(String pCatCode) {
		this.pCatCode = pCatCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	
	public ProductCategory() {
		
	}

	public ProductCategory(String pCatCode, String name, Date lastModifiedDate, int createdBy, int deleted) {
		
		this.pCatCode = pCatCode;
		this.name = name;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
		this.deleted = deleted;
	}
	
	

	
	

}
