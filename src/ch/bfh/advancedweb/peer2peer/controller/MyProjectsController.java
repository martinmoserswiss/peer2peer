package ch.bfh.advancedweb.peer2peer.controller;

import java.io.Serializable;
import java.util.ArrayList;
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

import ch.bfh.advancedweb.peer2peer.model.Credit;
import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class MyProjectsController implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{entityManager}")
	private EntityManager entityManager;
	
	

	public MyProjectsController(){
		
	}
	
	public List<Project> loadProjects(User user){
		
		this.entityManager = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query projectQuery = entityManager.createQuery("select p from Project as p join p.user as u where u.id=:id");
		projectQuery.setParameter("id", user.getId());
		
		// For Loans
		@SuppressWarnings("unchecked")
		List<Project> foundProjects = projectQuery.getResultList();
		System.out.println(foundProjects.size());
		
		return foundProjects;
		
	}
	
	public void acceptFund(Loan loan){
		
		Query q = this.entityManager.createQuery("select a from Loan a where a.project =: project");
		q.setParameter("project", loan.getProject());
		
		@SuppressWarnings("unchecked")
		List<Loan> foundLoans = q.getResultList();
		
		for (Loan foundloan : foundLoans) {
			this.entityManager.getTransaction().begin();
			foundloan.setStatus(LoanStatus.denied);
			this.entityManager.getTransaction().commit();
		}
		
		Query q2 = this.entityManager.createQuery("select a from Loan a where a =: loan");
		q2.setParameter("loan", loan);
		
		@SuppressWarnings("unchecked")
		List<Loan> foundLoans2 = q2.getResultList();
		Loan firstLoan = foundLoans2.get(0);

		this.entityManager.getTransaction().begin();
		firstLoan.setStatus(LoanStatus.accepted);
		this.entityManager.getTransaction().commit();
		
	}
	
	public void denieFund(Loan loan){

		
		Query q = this.entityManager.createQuery("select a from Loan a where a =: loan");
		q.setParameter("loan", loan);
		
		@SuppressWarnings("unchecked")
		List<Loan> foundLoans = q.getResultList();
		Loan firstLoan = foundLoans.get(0);

		this.entityManager.getTransaction().begin();
		firstLoan.setStatus(LoanStatus.denied);
		this.entityManager.getTransaction().commit();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	
	
	
}
