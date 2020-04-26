package br.com.alura.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Movementation;

public class JPQLTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();

		Account a = new Account();
		a.setId(2L);

		String jpql = "SELECT m " + "FROM Movementation m " + "WHERE m.a = :pAccount " + "ORDER BY m.value DESC";

//		Usando o tipo TypedClass 
		TypedQuery<Movementation> query = em.createQuery(jpql, Movementation.class);
		query.setParameter("pAccount", a);

		List<Movementation> resultList = query.getResultList();

		for (Movementation mo : resultList) {
			System.out.println("Description: " + mo.getDescription());
			System.out.println("Type: " + mo.getMovementType());
		}

	}

}
