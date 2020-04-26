package br.com.alura.jpa.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.model.Account;
import br.com.alura.jpa.model.Category;
import br.com.alura.jpa.model.Client;
import br.com.alura.jpa.model.MovementType;
import br.com.alura.jpa.model.Movementation;

public class MovementationCategoryRelashionshiptTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("account");
		EntityManager em = emf.createEntityManager();
		
		Category c1 = new Category("Lodging");
		Category c2 = new Category("Parking lot");
		
		Account a = new Account();
		a.setId(1L);
		
		Movementation m = new Movementation();
		m.setValue(new BigDecimal(50.00));
		m.setDate(LocalDateTime.now());
		m.setDescription("refund - day one");
		m.setMovementType(MovementType.CREDIT);
/*		
 * 		The following call stands the same as the next two rows below 		
 *		List<Category> categories = new ArrayList<>();
 *		categories.add();
 */
		m.setCategories(Arrays.asList(c1,c2));
		m.setAccount(a);

		Movementation m2 = new Movementation();
		m2.setValue(new BigDecimal(20.00));
		m2.setDate(LocalDateTime.now());
		m2.setDescription("refund - day two");
		m2.setMovementType(MovementType.CREDIT);
		m2.setCategories(Arrays.asList(c2));
		m2.setAccount(a);
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.persist(m);
		em.persist(m2);
		em.getTransaction().commit();
		em.close();
		
	}

}
