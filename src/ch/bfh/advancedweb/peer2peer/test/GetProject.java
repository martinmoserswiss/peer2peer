package ch.bfh.advancedweb.peer2peer.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.advancedweb.peer2peer.model.Project;

public class GetProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Simple Table join

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = em.createQuery("select p from Project as p join p.user as u where u.id=:id");
		q.setParameter("id", 10);
		
		
		@SuppressWarnings("unchecked")
		List<Project> foundProjects = q.getResultList();
		if(foundProjects != null){
			for (Project project : foundProjects) {
				System.out.println(project.getAmount());
			}
			
		}
	}

}
