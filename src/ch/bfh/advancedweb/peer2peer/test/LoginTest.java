package ch.bfh.advancedweb.peer2peer.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Test;
import ch.bfh.advancedweb.peer2peer.model.User;

public class LoginTest {

	@Test
	public void successfulLogin() {
		
		/* ------ Create User-------*/
		
		User user = new User();
		user.setFirstname("Serge");
		user.setLastname("Bühler");
		user.setBirthdate(new Date(1988,03,22));
		user.setCity("Thun");
		user.setCountry("Schweiz");
		user.setEmail("sergebuehler@gmail.com");
		user.setExpenses(1000.0);
		user.setExsisting_credits(0);
		user.setIncome(500);
		user.setPassword("1234");
		user.setPhone("0796901032");
		user.setPostalcode(3300);
		user.setRegistration_date(new Date(2012,11,29));
		user.setStreet("Bergstrasse100");
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		/* ------ User created -------*/
		
		/* ------ Check user -------*/
		
		Query q = em.createQuery("select a from User a where a.email=:email AND a.password=:password");
		q.setParameter("email", "sergebuehler@gmail.com");
		q.setParameter("password", "1234");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			Assert.assertTrue(firstUser.getEmail().equals("sergebuehler@gmail.com") && firstUser.getPassword().equals("1234"));
		}
		
		/* ------ Checked user -------*/
		
		/* ------ Delete user-------*/
		
		Query deleteQuery = em.createQuery("select a from User a where a.email=:email");
		deleteQuery.setParameter("email", "sergebuehler@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsersToDelete = deleteQuery.getResultList();
		User firstUserToDelte = foundUsersToDelete.get(0);
		
		if(firstUserToDelte != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstUserToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ User deleted -------*/
		
	}
	
	@Test
	public void errorLogin(){
		
		/* ------ Create user-------*/
		
		User user = new User();
		user.setFirstname("Serge");
		user.setLastname("Bühler");
		user.setBirthdate(new Date(1988,03,22));
		user.setCity("Thun");
		user.setCountry("Schweiz");
		user.setEmail("sergebuehler@gmail.com");
		user.setExpenses(1000.0);
		user.setExsisting_credits(0);
		user.setIncome(500);
		user.setPassword("1234");
		user.setPhone("0796901032");
		user.setPostalcode(3300);
		user.setRegistration_date(new Date(2012,11,29));
		user.setStreet("Bergstrasse100");
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		/* ------ User created -------*/
		
		/* ------ Check user -------*/
		
		Query q = em.createQuery("select a from User a where a.email=:email AND a.password=:password");
		q.setParameter("email", "sergebuehler@gmail.com");
		q.setParameter("password", "1234");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			Assert.assertFalse(firstUser.getEmail().equals("sergebuehler@gmail.com") && firstUser.getPassword().equals("3434"));
		}
		
		/* ------ Checked user -------*/
		
		/* ------ Delete user-------*/
		
		Query deleteQuery = em.createQuery("select a from User a where a.email=:email");
		deleteQuery.setParameter("email", "sergebuehler@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsersToDelete = deleteQuery.getResultList();
		User firstUserToDelte = foundUsersToDelete.get(0);
		
		if(firstUserToDelte != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstUserToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ User deleted -------*/
		
	}

}
