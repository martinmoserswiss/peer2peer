package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

public class UserTest {
	
	@Test
	public void crud(){
		
		/* ------ Create -------*/
		
		User user = new User();
		user.setFirstname("Basil");
		user.setLastname("Krähenbühl");
		user.setBirthdate(new Date(1988,03,22));
		user.setCity("Bern");
		user.setCountry("Schweiz");
		user.setEmail("basilKraehenbuehl@gmail.com");
		user.setExpenses(1000.0);
		user.setExsisting_credits(0);
		user.setIncome(500);
		user.setPassword("1234");
		user.setPhone("0796901032");
		user.setPostalcode(3300);
		user.setRegistration_date(new Date(2012,11,29));
		user.setStreet("Breitenrainplatz 12");
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		/* ------ Created -------*/
		
		/* ------ Udpate -------*/
		
		Query q = em.createQuery("select a from User a where a.email=:email");
		q.setParameter("email", "basilKraehenbuehl@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);

		em.getTransaction().begin();
		firstUser.setFirstname("Christian");
		em.getTransaction().commit();
		
		/* ------ Udpated -------*/
		
		/* ------ Delete -------*/
		
		Query deleteQuery = em.createQuery("select a from User a where a.email=:email");
		deleteQuery.setParameter("email", "basilKraehenbuehl@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsersToDelete = deleteQuery.getResultList();
		User firstUserToDelte = foundUsersToDelete.get(0);
		
		if(firstUserToDelte != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstUserToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ Deleted -------*/
	}
}
