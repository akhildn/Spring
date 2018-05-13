package com.servicedesk.entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column (name="id")	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
	@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1, initialValue = 1)
	int id;
	
	String username;
	String password;
	String email;
	String contactno;
	
	public Customer() {
		super();		
	}

	public Customer(int id, String username, String password, String email, String contactno) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contactno = contactno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", contactno=" + contactno + "]";
	}
	
}
