package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

public class UserCRUDTest {
	

	@Test
	public void createUser() {
		
		User user = new User();
		user.setFirstname("Martin");
		user.setLastname("Moser");
		user.setBirthdate(new Date(1988,03,22));
		user.setCity("Fraubrunnen");
		user.setCountry("Bangladesch");
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

	@Test
	public void readUser(){
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a where a.email=:email");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			Assert.assertTrue(firstUser.getEmail().equals("mail.martinmoser@gmail.com"));
		}
	}
	
	@Test
	public void updateUser(){
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a where a.email=:email");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);

		em.getTransaction().begin();
		firstUser.setFirstname("Christian");
		em.getTransaction().commit();

		Assert.assertTrue(firstUser.getFirstname().equals("Christian"));
		
	}
	
	@Test
	public void deleteTest(){
		
		EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a where a.email=:email");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);
		
		if(firstUser != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstUser);
			em.getTransaction().commit();
			
		}
		
	}

}
