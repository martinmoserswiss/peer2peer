package ch.bfh.advancedweb.peer2peer.controller;

import java.io.Serializable;
import java.util.Date;
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
public class ManageAccountController implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{entityManager}")
	private EntityManager entityManager;
	
	

	public ManageAccountController(){
		
	}
	
	public boolean changePassword(User user){
	
		this.entityManager = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = this.entityManager.createQuery("select a from User a where a.email=:email");
		q.setParameter("email", user.getEmail());
		@SuppressWarnings("unchecked")
		List<User> foundUsers = q.getResultList();
		User firstUser = foundUsers.get(0);

		this.entityManager.getTransaction().begin();
		firstUser.setPassword(user.getPassword());
		this.entityManager.getTransaction().commit();
		
		return true;
		
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	
	
	
}
