package ch.bfh.advancedweb.peer2peer.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;

import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {
	
	EntityManager em;
	boolean isLoggedIn = false;

	public UserController(){
		
	}
	
	public void instantEntityManager(){
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
	}
	
	public boolean isValid(String email, String password){
		
		Query q = em.createQuery("select a from User a");
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
