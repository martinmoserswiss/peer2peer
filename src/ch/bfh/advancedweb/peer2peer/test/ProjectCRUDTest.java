package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;

public class ProjectCRUDTest {

	@Test
	public void createUser() {
		
		Project project = new Project();
		project.setProjectName("Kran kaufen");
		project.setAmount(10000);
		project.setStatus(ProjectStatus.pending);
		

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		//
		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
		
	}
	
	
	
	/*
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
			Assert.assertTrue(firstUser.getFirstname().equals("Martin") && firstUser.getLastname().equals("Moser") && firstUser.getEmail().equals("mail.martinmoser@gmail.com"));
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

		// Write access needs a transaction
		em.getTransaction().begin();
		firstUser.setFirstname("Christian");
		em.getTransaction().commit();
		// Entity is persisted automatically after commit because it is managed
		// by jpa.

		Assert.assertTrue(firstUser.getFirstname().equals("Christian"));
		
	}
	
	@Test
	public void deleteTest(){
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a where a.email=:email");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		em.remove(firstUser);
		em.getTransaction().commit();
		
	}
	
	*/

}
