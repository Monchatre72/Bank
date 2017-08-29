package com.formation.bank.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "NUM_EMP")
	private Long codeEmploye;
	
	@Column(name = "NOM_EMP")
	private String nomEmploye;
	

	@ManyToMany
	@JoinTable(name="EMP_GROUPES",joinColumns=@JoinColumn(name="NUM_EMP"),inverseJoinColumns=@JoinColumn(name="NUM_GROUPE"))
	private List<Groupe> groupes;
	
	@ManyToOne
	@JoinColumn(name="NUM_EMP_SUP")
	private Employe supHierarchique;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}



	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Employe getSupHierarchique() {
		return supHierarchique;
	}

	public void setSupHierarchique(Employe supHierarchique) {
		this.supHierarchique = supHierarchique;
	}




	
	
	
}
