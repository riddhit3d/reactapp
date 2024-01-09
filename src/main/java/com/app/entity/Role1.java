package com.app.entity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Role1 {
    @Id
	private int id;
	private String name;
	@ManyToMany(mappedBy = "roles")
	Set<User1> user=new HashSet<>();
	
	public Set<User1> getUser() {
		return user;
	}

	public void setUser(Set<User1> user) {
		this.user = user;
	}

	public Role1(int id, String name, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		
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
	public Role1(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Role1() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
