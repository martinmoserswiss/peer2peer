package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import junit.framework.Assert;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;
import ch.bfh.advancedweb.peer2peer.model.User;

public class CreateProjectTest {

	@Test
	public void createUser() {
		
		User creditor = new User();
		creditor.setFirstname("Nico");
		creditor.setLastname("Rohr");
		creditor.setBirthdate(new Date(1988,03,22));
		creditor.setCity("Fraubrunnen");
		creditor.setCountry("Switzerland");
		creditor.setEmail("mail.martinmoser@gmail.com");
		creditor.setExpenses(1000.0);
		creditor.setExsisting_credits(0);
		creditor.setIncome(500);
		creditor.setPassword("teddibaer");
		creditor.setPhone("0796901032");
		creditor.setPostalcode(3312);
		creditor.setRegistration_date(new Date(2012,11,29));
		creditor.setStreet("Schuetzenmattweg 30");


		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(creditor);
		em.getTransaction().commit();
	
	}
	
	@Test
	public void createProject(){
		Project project1 = new Project();
		project1.setProjectName("Startup-Gründung");
		project1.setMark(10);
		project1.setAmount(100000);
		project1.setCreationdate(new Date(2013,01,01));
		project1.setDuration(2);
		project1.setEnddate(new Date(2013,12,31));
		project1.setStartdate(new Date(2012,12,04));
		project1.setStatus(ProjectStatus.pending);
		
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("select a from User a where a.email =:email");
		q.setParameter("email", "mail.martinmoser@gmail.com");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User foundUser = null;
		if(foundUsers != null){
			foundUser = (User)foundUsers.get(0);
		}
		if(foundUser != null) project1.setUser(foundUser);
		ArrayList<Project> projects = new ArrayList<Project>();
		foundUser.setProjects(projects);
		
		em.getTransaction().begin();
		em.persist(foundUser);
		em.getTransaction().commit();

	}

}
