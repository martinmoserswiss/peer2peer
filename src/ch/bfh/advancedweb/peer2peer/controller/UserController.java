package ch.bfh.advancedweb.peer2peer.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;

import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {
	
	@ManagedProperty(value="#{entityManager}")
	EntityManager em;
	
	boolean isLoggedIn = false;

	public UserController(){
		
	}
	
	public boolean isValid(String email, String password){
		
		em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = em.createQuery("select u from User AS u where u.email = :email AND u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null){
			User firstUser = (User)foundUsers.get(0);
			if(firstUser.getEmail().equals(email)&&firstUser.getPassword().equals(password)){
				this.isLoggedIn = true;
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	
}
