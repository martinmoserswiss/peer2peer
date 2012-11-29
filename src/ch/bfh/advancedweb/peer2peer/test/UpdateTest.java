package ch.bfh.advancedweb.peer2peer.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

/**
 * @author Martin Moser
 * 
 */
public class UpdateTest {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a");
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstUser.setFirstname("Martin");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstUser.getFirstname().equals("Martin"));
	}

}
