package ch.bfh.advancedweb.peer2peer.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;

import ch.bfh.advancedweb.peer2peer.model.User;

public class ReadTest {

	@Test
	public void test() {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		Query q = em.createQuery("SELECT  FROM User");
		List<?> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			Assert.assertTrue(firstUser.getFirstname().equals("Martin"));
		}
	}

}
