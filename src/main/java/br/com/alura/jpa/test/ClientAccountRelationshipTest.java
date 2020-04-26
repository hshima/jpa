package br.com.alura.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Client;

public class ClientAccountRelationshipTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();

		// Instantiate both classes
		Account a = new Account();
		a.setId(2L); //Fix this id user so information will be always set to this account
		a.setAgency(1234);
		a.setNumber(654322);
		a.setHolder("Mario");
		
		Client c = new Client();
		c.setName(a.getHolder());
		c.setProfession("Engeneer");
		c.setAddress("50 Living St");
		c.setAccount(a);
		
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();

	}

}
