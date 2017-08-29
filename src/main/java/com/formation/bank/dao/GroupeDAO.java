package com.formation.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.bank.entities.Employe;
import com.formation.bank.entities.Groupe;

public class GroupeDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public GroupeDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_BANK");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addGroupe(Groupe g) {
		tx.begin();
		em.persist(g);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Groupe> consulterGroupe() {
		Query q = em.createQuery("SELECT gr FROM Groupe gr");
		List<Groupe> listgroupe = (List<Groupe>) q.getResultList();
		return listgroupe;
	}
	

	public List<Employe> consulterEmployesParGroupe(Long idG) {
		tx.begin();
		Groupe groupe=em.find(Groupe.class,idG);
		tx.commit();
		
		List<Employe> listEmpParGrpe =groupe.getEmployes();
		return  listEmpParGrpe;
	}
}
