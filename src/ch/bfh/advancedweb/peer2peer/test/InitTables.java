package ch.bfh.advancedweb.peer2peer.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;
import ch.bfh.advancedweb.peer2peer.model.User;

public class InitTables {
	
	@Test
	public void initTables(){
		
		/* ------ Create user-------*/
		
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
		
		/* ------ User created -------*/
		
		/* ------ Delete user -------*/
		
		Query deleteQueryUser = em.createQuery("select a from User a where a.email=:email");
		deleteQueryUser.setParameter("email", "basilKraehenbuehl@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsersToDelete = deleteQueryUser.getResultList();
		User firstUserToDelte = foundUsersToDelete.get(0);
		
		if(firstUserToDelte != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstUserToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ User deleted -------*/
		
		/* ------ Create project-------*/
		
		Project project = new Project();
		project.setProjectName("Kran kaufen");
		project.setAmount(10000);
		project.setStatus(ProjectStatus.pending);

		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
		
		/* ------ Project created -------*/
		
		/* ------ Delete project -------*/
		
		Query queryDeleteProject = em.createQuery("select a from Project a where a.projectName=:projectname");
		queryDeleteProject.setParameter("projectname", "Kran kaufen");
		
		@SuppressWarnings("unchecked")
		List<Project> foundProjectsToDelete = queryDeleteProject.getResultList();
		if(foundProjectsToDelete != null){
			Project firstProject = (Project)foundProjectsToDelete.get(0);
			
			if(firstProject != null){
				
				// Write access needs a transaction
				em.getTransaction().begin();
				em.remove(firstProject);
				em.getTransaction().commit();
				
			}
		}
		
		/* ------ Project deleted -------*/
		
		/* ------ Create loan -------*/
		
		Loan loan = new Loan();
		loan.setStatus(LoanStatus.pending);
		loan.setInterest_rate(10.0);

		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		
		/* ------ Loan Created -------*/
		
		/* ------ Delete loan-------*/
		
		Query deleteQueryLoan = em.createQuery("select a from Loan a where a.interest_rate=:rate");
		deleteQueryLoan.setParameter("rate", 10.0);
		@SuppressWarnings("unchecked")
		List<Loan> foundLoansToDelete = deleteQueryLoan.getResultList();
		Loan firstLoanToDelte = foundLoansToDelete.get(0);
		
		if(firstLoanToDelte != null){
			
			// Write access needs a transaction
			em.getTransaction().begin();
			em.remove(firstLoanToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ Loan Deleted -------*/
	}
}
