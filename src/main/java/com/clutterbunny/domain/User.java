
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


@Entity(name="User")
@Table(name="user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	@Column(name="fist_name")
	protected String firstName;
	@Column(name="last_name")
	protected String lastName;
	@Column
	protected String username;
	@Column
	protected String password;
	@Column
	protected String email;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="type", length=1)
	private UserTypeEnum type;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="source", length=1)
	private UserSourceEnum source;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="status", length=1)
	private UserStatusEnum status;
	
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserTypeEnum getType() {
		return type;
	}

	public void setType(UserTypeEnum type) {
		this.type = type;
	}

	public UserSourceEnum getSource() {
		return source;
	}

	public void setSource(UserSourceEnum source) {
		this.source = source;
	}

	public UserStatusEnum getStatus() {
		return status;
	}

	public void setStatus(UserStatusEnum status) {
		this.status = status;
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
