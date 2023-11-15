package com.fabio.eicon.entity;

import java.util.Set;
import javax.persistence.*;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String email;
	@ManyToMany
	private Set<Produto> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Set<Produto> getRoles() {
		return roles;
	}
	public void setRoles(Set<Produto> roles) {
		this.roles = roles;
	}
	
}
