package ch.bfh.advancedweb.peer2peer.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;
import ch.bfh.advancedweb.peer2peer.model.User;

public class CreateProjectTest {
	
	@Test
	public void createProject(){
		
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
		
		/* ------ Create project -------*/
		
		Project project1 = new Project();
		project1.setProjectName("Startup-Gründung");
		project1.setMark(10);
		project1.setAmount(100000);
		project1.setCreationdate(new Date(2013,01,01));
		project1.setDuration(2);
		project1.setEnddate(new Date(2013,12,31));
		project1.setStartdate(new Date(2012,12,04));
		project1.setStatus(ProjectStatus.pending);

		Query q = em.createQuery("select a from User a where a.email =:email");
		q.setParameter("email", "sergebuehler@gmail.com");
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User foundUser = null;
		if(foundUsers != null){
			foundUser = (User)foundUsers.get(0);
		}
		project1.setUser(foundUser);
		ArrayList<Project> projects = new ArrayList<Project>();
		projects.add(project1);
		foundUser.setProjects(projects);
		
		em.getTransaction().begin();
		em.persist(foundUser);
		em.getTransaction().commit();
		
		/* ------ Project created -------*/
		
		/* ------ Delete user-------*/
		
		Query deleteQuery = em.createQuery("select a from User a where a.email=:email");
		deleteQuery.setParameter("email", "sergebuehler@gmail.com");
		@SuppressWarnings("unchecked")
		List<User> foundUsersToDelete = deleteQuery.getResultList();
		User firstUserToDelte = foundUsersToDelete.get(0);
		
		if(firstUserToDelte != null){
			
			em.getTransaction().begin();
			em.remove(firstUserToDelte);
			em.getTransaction().commit();
			
		}
		
		/* ------ User deleted -------*/
	}

}
