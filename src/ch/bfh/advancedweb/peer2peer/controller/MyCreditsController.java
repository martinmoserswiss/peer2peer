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
public class MyCreditsController implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{entityManager}")
	private EntityManager entityManager;
	
	

	public MyCreditsController(){
		
	}
	
	public List<Credit> loadCredits(User user){
		
		List<Credit> creditList = new ArrayList<Credit>();
	
		this.entityManager = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query loanQuery = entityManager.createQuery("select l from Loan as l join l.user as u where u.id=:id");
		loanQuery.setParameter("id", user.getId());
		
		
		// For Loans
		@SuppressWarnings("unchecked")
		List<Loan> foundLoans = loanQuery.getResultList();
		System.out.println(foundLoans.size());
		if(foundLoans != null){
			for (Loan loan : foundLoans) {
				Credit credit =  new Credit();
				credit.setProjectName(loan.getProject().getProjectName());
				credit.setAmount(loan.getProject().getAmount());
				credit.setInterest_rate(loan.getInterest_rate());
				credit.setDuration(loan.getProject().getDuration());
				credit.setMark(loan.getProject().getMark());
				credit.setProjectStatus(loan.getProject().getStatus().toString());
				credit.setLoanStatus(loan.getStatus().toString());
				
				credit.setFirstname(loan.getUser().getFirstname());
				credit.setLastname(loan.getUser().getLastname());
				credit.setEmail(loan.getUser().getEmail());
				credit.setStreet(loan.getUser().getStreet());
				credit.setPostalcode(loan.getUser().getPostalcode());
				credit.setCity(loan.getUser().getCity());
				credit.setPhone(loan.getUser().getPhone());
				
				creditList.add(credit);
				
			}
		}

		return creditList;
		
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
	
	
	
}
