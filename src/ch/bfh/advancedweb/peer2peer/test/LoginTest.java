package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.constraints.AssertTrue;

import junit.framework.Assert;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.User;

public class LoginTest {

	@Test
	public void successfulLogin() {
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = em.createQuery("select a from User a where a.email=:email AND a.password=:password");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		q.setParameter("password", "teddibaer");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			Assert.assertTrue(firstUser.getEmail().equals("mail.martinmoser@gmail.com") && firstUser.getPassword().equals("teddibaer"));
		}
		
	}
	
	@Test
	public void errorLogin(){
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = em.createQuery("select a from User a where a.email=:email AND a.password=:password");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		q.setParameter("password", "teddibaer");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			Assert.assertFalse(firstUser.getEmail().equals("") && firstUser.getPassword().equals(""));
		}
		
	}

}
