package com.servicedesk.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="servicegroup")
public class Group {
	
	@Id
	@Column (name="id")
	int id;
	
	String name;
	
	@OneToMany(mappedBy = "group")	
	List<Agent> agents;
	
	public Group() {
		super();		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}	
	
}
