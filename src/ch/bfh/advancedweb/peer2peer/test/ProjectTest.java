package ch.bfh.advancedweb.peer2peer.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;

public class ProjectTest {
	
	@Test
	public void crud(){

		/* ------ Create -------*/
		
		Project project = new Project();
		project.setProjectName("Kran kaufen");
		project.setAmount(10000);
		project.setStatus(ProjectStatus.pending);

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		em.getTransaction().begin();
		em.persist(project);
		em.getTransaction().commit();
		
		/* ------ Created -------*/

		/* ------ Udpate -------*/
		
		Query q = em.createQuery("select a from Project a where a.projectName=:projectname");
		q.setParameter("projectname", "Kran kaufen");
		
		@SuppressWarnings("unchecked")
		List<Project> foundProjects = q.getResultList();
		if(foundProjects != null){
			Project firstProject = (Project)foundProjects.get(0);
			
			em.getTransaction().begin();
			firstProject.setProjectName("Lastwagen kaufen");
			em.getTransaction().commit();
		}
		
		/* ------ Udpated -------*/
		
		/* ------ Delete -------*/
		
		Query queryDelete = em.createQuery("select a from Project a where a.projectName=:projectname");
		queryDelete.setParameter("projectname", "Lastwagen kaufen");
		
		@SuppressWarnings("unchecked")
		List<Project> foundProjectsToDelete = queryDelete.getResultList();
		if(foundProjectsToDelete != null){
			Project firstProject = (Project)foundProjectsToDelete.get(0);
			
			if(firstProject != null){
				
				// Write access needs a transaction
				em.getTransaction().begin();
				em.remove(firstProject);
				em.getTransaction().commit();
				
			}
		}
		
		/* ------ Deleted -------*/
		
	}
}
