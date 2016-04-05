
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


@Entity(name="Profile")
@Table(name="profile")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name="user_id")
	protected Long userId;
	
	@Column(name="address")
	protected String address1;
	@Column(name="street")
	protected String street;
	@Column(name="city")
	protected String city;
	@Column(name="state")
	protected String state;
	@Column(name="zip")
	protected int zip;
	
	
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
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
