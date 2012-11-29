package ch.bfh.advancedweb.peer2peer.test.crud;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

/**
 * 
 * @author Martin Moser
 *
 */
public class CreateUserTest {

	@Test
	public void test() {
		
		User user = new User();
		user.setFirstname("Martin");
		user.setLastname("Moser");
		user.setBirthdate(new Date(1988,03,22));
		user.setCity("Fraubrunnen");
		user.setCountry("Switzerland");
		user.setEmail("mail.martinmoser@gmail.com");
		user.setExpenses(1000.0);
		user.setExsisting_credits(0);
		user.setIncome(500);
		user.setPassword("teddibaer");
		user.setPhone("0796901032");
		user.setPostalcode(3312);
		user.setRegistration_date(new Date(2012,11,29));
		user.setStreet("Schuetzenmattweg 30");
		

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		//
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
}
