package com.formation.bank.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.formation.bank.entities.Client;
import com.formation.bank.entities.Compte;
import com.formation.bank.entities.Employe;
import com.formation.bank.entities.Operation;
import com.formation.bank.entities.Versement;

public class CompteDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public CompteDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_BANK");
		em = emf.createEntityManager();
		tx = em.getTransaction();

	}

	public void addCompte(Compte c, Long numCli, Long numEmp) {
		Compte compte = c;
		tx.begin();
		compte.setSolde(0);
		compte.setDateCreation(new Date());
		compte.setClient(em.find(Client.class, numCli));
		compte.setEmploye(em.find(Employe.class, numEmp));
		em.persist(compte);
		tx.commit();
	}

	public void addOperation(Operation op, String numCpte, Long numEmp) {
		Operation operation = op;
		double montant = op.getMontant();
		tx.begin();

		Compte compte = em.find(Compte.class, numCpte);
		double solde = compte.getSolde();

		operation.setCompte(compte);
		operation.setEmploye(em.find(Employe.class, numEmp));

		if (op.getClass().isInstance(new Versement())) {
			compte.setSolde(solde + montant);
		} else {
			compte.setSolde(solde - montant);
		}

		em.merge(compte);
		em.persist(operation);
		tx.commit();
	}

	public Compte consulterCompte(String numCpte) {
		tx.begin();
		Compte cpte = em.find(Compte.class, numCpte);
		tx.commit();
		return cpte;
	}

}
