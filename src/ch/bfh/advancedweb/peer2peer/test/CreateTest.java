package ch.bfh.advancedweb.peer2peer.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

public class CreateTest {

	@Test
	public void test() {
		
		User user = new User();
		user.setFirstname("Martin");
		user.setLastname("Moser");

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		//hi martin
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
}
