package ch.bfh.advancedweb.peer2peer.test.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

/**
 * @author Martin Moser
 * 
 */
public class DeleteTest {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a");
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);
		// Assert.assertTrue(firstAuthor.getLastname().equals("Tolkien"));

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstUser);
		em.getTransaction().commit();
	}

}
