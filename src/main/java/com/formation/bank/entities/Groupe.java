package com.formation.bank.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Groupe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "NUM_GR")
	private Long numGroupe;
	
	@Column(name = "NOM_GR")
	private String nomGroupe;

	@ManyToMany(mappedBy="groupes", fetch=FetchType.LAZY)
	private List<Employe> employes;

	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNumGroupe() {
		return numGroupe;
	}

	public void setNumGroupe(Long numGroupe) {
		this.numGroupe = numGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}


	
	
	
}
