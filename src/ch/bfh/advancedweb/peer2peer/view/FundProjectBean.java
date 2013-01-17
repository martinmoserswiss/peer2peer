package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@ViewScoped
public class FundProjectBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{userController}")
	private UserController userController;
	
	private double fundRate;
	
	private boolean success = false;
	private String successMessage;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	private int totalFunds;
	private int maxPerProject;
	
	private List<Project> projects = new ArrayList<Project>();
	
	public FundProjectBean()
	{
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	
	public String search()
	{
		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Query q = em.createQuery("select a from Project a where a.amount<=:maxPerProject and a.amount <=:totalFunds");
		q.setParameter("maxPerProject", maxPerProject);
		q.setParameter("totalFunds", totalFunds);
		
		projects = q.getResultList();
		
		return "success";
	}
	
	//is this possible?
	public String fund(Project p) {

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		System.out.println("PROJECT TO FUND: " + fundRate +" "+ p.getProjectName());
		
		Loan loan = new Loan();
		loan.setStatus(LoanStatus.pending);
		loan.setInterest_rate(fundRate);
		loan.setUser(userController.getUser());
		loan.setProject(p);
		

		em.getTransaction().begin();
		em.persist(loan);
		em.getTransaction().commit();
		
		this.success=true;
		this.successMessage="Your fund has been registered!";
		
		return "hi";
	}

	public double getFundRate() {
		return fundRate;
	}

	public void setFundRate(double fundRate) {
		this.fundRate = fundRate;
	}

	public int getTotalFunds() {
		return totalFunds;
	}

	public void setTotalFunds(int totalFunds) {
		this.totalFunds = totalFunds;
	}

	public int getMaxPerProject() {
		return maxPerProject;
	}

	public void setMaxPerProject(int maxPerProject) {
		this.maxPerProject = maxPerProject;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
