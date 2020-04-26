package br.com.alura.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class AccountCreation {

	public static void main(String[] args) {

		/*
		 * Creates an instance that exchanges data in db according with definitions of "account" from persistence.xml
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();
		
		Account a = new Account();
		a.setHolder("Lowbank");
		a.setAgency(123);
		a.setNumber(987654);
		
		/*
		 * Stores data about a through persist() from begin transaction until commit and closes connection with DB, creating a Managed transaction
		 */
		
		em.getTransaction().begin();
		
		em.persist(a);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
