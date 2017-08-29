package com.formation.bank.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)

public abstract class Compte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name= "NUM_CPTE",unique=true)
	protected String numCompte;
	
	@Column(name="DATE_CR")
	@Temporal(TemporalType.DATE)
	protected Date dateCreation;
	
	@Column(name="SOLDE")
	protected double solde;
	
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="compte",fetch=FetchType.LAZY)
	protected List<Operation> operations;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CODE_CLI")
	protected Client client; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NUM_EMP")
	protected Employe employe;
	
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String numCompte, Date dateCreation, double solde, Client client, Employe employe) {

		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
		this.employe = employe;
	}





	public String getNumCompte() {
		return numCompte;
	}


	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}







	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	
	
	
	
	
}
