package ch.bfh.advancedweb.peer2peer.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.User;

public class CompleteCRUDTest {

	@Test
	public void create() {
		
		Loan loan = new Loan();
		loan.setInterest_rate(2.2);
		loan.setStatus(false);
		
		
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
		
		
		User recipient = new User();
		recipient.setFirstname("Basil");
		recipient.setLastname("Krähenbühl");
		recipient.setBirthdate(new Date(1988,03,22));
		recipient.setCity("Fraubrunnen");
		recipient.setCountry("Switzerland");
		recipient.setEmail("mail.martinmoser@gmail.com");
		recipient.setExpenses(1000.0);
		recipient.setExsisting_credits(0);
		recipient.setIncome(500);
		recipient.setPassword("teddibaer");
		recipient.setPhone("0796901032");
		recipient.setPostalcode(3312);
		recipient.setRegistration_date(new Date(2012,11,29));
		recipient.setStreet("Schuetzenmattweg 30");

		
		Project project1 = new Project();
		project1.setMark("CD Produzieren");
		project1.setAmount(100000);
		project1.setCreationdate(new Date(2013,01,01));
		project1.setDuration(2);
		project1.setEnddate(new Date(2013,12,31));
		project1.setStartdate(new Date(2012,12,04));
		project1.setStatus(false);
		
		creditor.setProject(project1);
		creditor.setLoan(loan);
		
		recipient.setProject(project1);
		recipient.setLoan(loan);
		
		/*---------------*/
		ArrayList<User> recipients = new ArrayList<User>();
		recipients.add(recipient);
		
		project1.setLoan(loan);
		project1.setUsers(recipients);
		/*---------------*/

		/*---------------*/
		ArrayList<Project> projects = new ArrayList<Project>();
		projects.add(project1);	
		ArrayList<User> creditors = new ArrayList<User>();
		creditors.add(creditor);
		loan.setProjects(projects);
		loan.setUsers(creditors);
		/*---------------*/
		
		

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		
		
	}

}
