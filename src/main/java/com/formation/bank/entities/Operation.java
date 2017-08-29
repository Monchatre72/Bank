package com.formation.bank.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING, length = 2)
public abstract class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="NUM_OP",unique=true)
	private long numOperation;

	@Column(name="DATE_OP")
	@Temporal(TemporalType.DATE)
	private Date dateOperation;

	@Column(name="MONTANT")
	private double montant;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NUM_CPTE")
	private Compte compte;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "NUM_EMP")
	private Employe employe;

	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(long numOperation, Date dateOperation, double montant, Compte compte, Employe employe) {
		super();
		this.numOperation = numOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
		this.employe = employe;
	}

	public long getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(long numOperation) {
		this.numOperation = numOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
