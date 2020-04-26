package br.com.alura.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;

public class AccountCreationWithBalance {

	public static void main(String[] args) {
		/*
		 * Creates an instance that exchanges data in db according with definitions of "account" from persistence.xml
		 */

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();
		
		Account a = new Account();
		a.setHolder("Fairbank");
		a.setAgency(123);
		a.setNumber(987654);
		a.setBalance(123.45);
		
		/*
		 * Stores data about a through persist() from begin transaction until commit and closes connection with DB, creating a Managed transaction
		 */
		
		em.getTransaction().begin();
		
		em.persist(a);
		
		em.getTransaction().commit();
		em.close();
		
		/*
		 * Even though it creates a new transaction due to the previous persist(), 
		 * the following method call won't work, because this is a not managed call (still transient)
		 *  
		 * a.setBalance(200.00);
		 * 
		 * In order to make this same transaction, it's necessary to instantiate EntityManager again, calling the method merge() in the transaction.
		 * This procedure will compare changes in the instance, altering only the modified data
		 * Since there's no id specified, the altered transaction will occur on the lastest 
		 */
		
		EntityManager em2 = emf.createEntityManager();
		a.setBalance(200.00);
		
		em2.getTransaction().begin();
		
		em2.merge(a);
		
		em2.getTransaction().commit();

	}

}
