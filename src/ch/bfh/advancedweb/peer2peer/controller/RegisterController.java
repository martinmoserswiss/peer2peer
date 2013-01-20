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
/**
 * controls the registration process
 *
 */
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{entityManager}")
	private EntityManager entityManager;
	
	

	public RegisterController(){
		
	}
	
	/**
	 * adds the user entity to the database
	 * @param user
	 * @return
	 */
	public boolean register(User user){
	
		this.entityManager = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		return true;
		
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	
	
	
}
