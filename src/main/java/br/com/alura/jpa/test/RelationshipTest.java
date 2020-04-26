package br.com.alura.jpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.MovementType;
import br.com.alura.jpa.model.Movementation;

public class RelationshipTest {

	public static void main(String[] args) {
		/*
		 * Instance a transient data for Account and Movementation
		 */
		Account a = new Account();
		a.setHolder("Almiro");
		a.setAgency(1234);
		a.setNumber(987659);
		
		Movementation m = new Movementation();
		m.setAccount(a);
		m.setDate(LocalDateTime.now());
		m.setDescription("Meal");
		m.setMovementType(MovementType.CREDIT);
		m.setValue(new BigDecimal(123.45));
		
		
		/*
		 * Instance an EntityManager, persisting both objects so a relationship will be created
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(a);
		em.persist(m);
		em.getTransaction().commit();
		
		em.close();
	}

}
