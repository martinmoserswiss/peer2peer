package ch.bfh.advancedweb.peer2peer.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.junit.Assert;

import com.sun.xml.bind.v2.TODO;

import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class UserController implements Serializable {
	
	

	@ManagedProperty("#{entityManager}")
	private EntityManager entityManager;
	
	private boolean isLoggedIn = false;
	private User user;

	public UserController(){
		
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public boolean login(String email, String password){
		
		entityManager = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = entityManager.createQuery("select u from User AS u where u.email = :email AND u.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		if(foundUsers != null && foundUsers.size() != 0){
			User firstUser = (User)foundUsers.get(0);
			if(firstUser.getEmail().equals(email)&&firstUser.getPassword().equals(password)){
				this.isLoggedIn = true;
				this.setUser(firstUser);
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public boolean isLoggedIn(){
		return this.isLoggedIn ? true : false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
