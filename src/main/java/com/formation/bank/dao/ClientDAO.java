package com.formation.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.bank.entities.Client;

public class ClientDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public ClientDAO() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_BANK");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addClient(Client c) {

		tx.begin();
		em.persist(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Client> consulterClients() {
		Query q = em.createQuery("SELECT cl FROM Client cl");

		List<Client> listclients = (List<Client>) q.getResultList();
		return listclients;
	}

	@SuppressWarnings("unchecked")
	public List<Client> consulterClientsParNom(String mc) {
		Query q = em.createQuery("SELECT cl FROM Compte cl WHERE cl.nom= :nom");
		q.setParameter("nom", mc);
		List<Client> listclientsparnom = (List<Client>) q.getResultList();
		return listclientsparnom;
	}

}
