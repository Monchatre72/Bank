package com.formation.bank.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Client implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue
@Column(name = "CODE_CLI",unique=true)
private Long code;

@Column(name = "NOM_CLI")
private String nom;

@OneToMany(cascade=CascadeType.ALL,mappedBy="client",fetch=FetchType.LAZY)
private List<Compte> comptes;



public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getCode() {
	return code;
}

public void setCode(Long code) {
	this.code = code;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public List<Compte> getComptes() {
	return comptes;
}

public void setComptes(List<Compte> comptes) {
	this.comptes = comptes;
}




	
}
