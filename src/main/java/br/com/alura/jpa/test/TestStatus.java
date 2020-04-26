package br.com.alura.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class TestStatus {

	public static void main(String[] args) {
		/*
		 * Status: Transient
		 * Creating an instance equals to a transient status. This status is a existing transaction that could turn to be managed  
		 */
		Account a = new Account();
		a.setHolder("Almiro");
		a.setAgency(1234);
		a.setNumber(987659);
		
		/*
		 * Instance of an EntityManagerFatory allows the application to interact with the db based on persistence.xml atribute from the Persistence Class
		 * Instance of an EntityManager allows interaction about the transaction to be managed. 
		 */
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Status: Transient --> Managed
		em.persist(a);
		
		/*
		 * Finally, the use of remove(), also alter a managed transaction from the JPA, also removing information from the db  
		 */
		em.remove(a);
		em.getTransaction().commit();

	}

}
