package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;
import ch.bfh.advancedweb.peer2peer.model.User;

public class CompleteCRUDTest {

	@Test
	public void create() {
		
		Project project1 = new Project();
		project1.setProjectName("Startup-Gründung");
		project1.setMark(10);
		project1.setAmount(100000);
		project1.setCreationdate(new Date(2013,01,01));
		project1.setDuration(2);
		project1.setEnddate(new Date(2013,12,31));
		project1.setStartdate(new Date(2012,12,04));
		project1.setStatus(ProjectStatus.pending);
		

		Project project2 = new Project();
		project1.setProjectName("Kran-Kauf");
		project1.setMark(10);
		project1.setAmount(100000);
		project1.setCreationdate(new Date(2013,01,01));
		project1.setDuration(2);
		project1.setEnddate(new Date(2013,12,31));
		project1.setStartdate(new Date(2012,12,04));
		project1.setStatus(ProjectStatus.pending);
		
		
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
		
		
//		User recipient = new User();
//		recipient.setFirstname("Basil");
//		recipient.setLastname("Krähenbühl");
//		recipient.setBirthdate(new Date(1988,03,22));
//		recipient.setCity("Fraubrunnen");
//		recipient.setCountry("Switzerland");
//		recipient.setEmail("mail.martinmoser@gmail.com");
//		recipient.setExpenses(1000.0);
//		recipient.setExsisting_credits(0);
//		recipient.setIncome(500);
//		recipient.setPassword("teddibaer");
//		recipient.setPhone("0796901032");
//		recipient.setPostalcode(3312);
//		recipient.setRegistration_date(new Date(2012,11,29));
//		recipient.setStreet("Schuetzenmattweg 30");

		
//		project1.setUser(recipient);
//		ArrayList<Project> projects = new ArrayList<Project>();
//		projects.add(project1);
//		recipient.setProjects(projects);
		
		ArrayList<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		projects.add(project2);
		
		creditor.setProjects(projects);
		project1.setUser(creditor);


		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(creditor);
		em.getTransaction().commit();
		
		
	}

}
