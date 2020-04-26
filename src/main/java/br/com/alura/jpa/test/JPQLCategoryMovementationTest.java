package br.com.alura.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.model.Category;
import br.com.alura.jpa.model.Movementation;

public class JPQLCategoryMovementationTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();

		Category c = new Category();
		c.setId(1L);
		String jpql = 
				"SELECT m "
				+ "FROM Movementation m "
				+ "JOIN m.categories c "
				+ "WHERE c = :pCategory "
				+ "ORDER BY m.value DESC";

		TypedQuery<Movementation> q = em.createQuery(jpql, Movementation.class);
		q.setParameter("pCategory", c);
		
		List<Movementation> resultList = q.getResultList();
		
		for (Movementation m : resultList) {
			System.out.println("Categorias: " + m.getCategories());
			System.out.println("Descrição: " + m.getDescription());
			System.out.println("Valor: " + m.getValue());
			System.out.println("Tipo: " + m.getMovementType());
		}
	}

}
