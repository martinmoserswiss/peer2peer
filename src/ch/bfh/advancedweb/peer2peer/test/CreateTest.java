package ch.bfh.advancedweb.peer2peer.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

public class CreateTest {

	@Test
	public void test() {
		
		User user = new User();
		user.setFirstname("Christian");
		user.setLastname("Moser");

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
}