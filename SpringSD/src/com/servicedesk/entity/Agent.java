package com.servicedesk.entity;

import javax.persistence.*;

@Entity
@Table(name="serviceagent")
public class Agent {
	
	@Id
	@Column (name="id")
	int id;
	
	String username;
	String password;
	String email;
	String contactno;
	
	@ManyToOne
    @JoinColumn(name = "groupid")
	Group group;
	
	public Agent() {
		super();		
	}

	public Agent(int id, String username, String password, String email, String contactno) {
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
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", contactno=" + contactno + "]";
	}
	
}
