
package com.clutterbunny.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity(name="BookRegistry")
@Table(name="registry_book")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRegistry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name="user_id")
	protected Long userId;	
	
	@Column(name="isbn_number")
	protected String isbnNumber;
	@Column(name="name")
	protected String name;
	@Column
	protected int quantity;
		
	@Enumerated(EnumType.ORDINAL)
	@Column(name="type", length=1)
	private RegistryTypeEnum type;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="by_when")
	protected Date byWhen;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	protected Date createdTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_modified_date")
	protected Date lastModifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public RegistryTypeEnum getType() {
		return type;
	}

	public void setType(RegistryTypeEnum type) {
		this.type = type;
	}

	public Date getByWhen() {
		return byWhen;
	}

	public void setByWhen(Date byWhen) {
		this.byWhen = byWhen;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
