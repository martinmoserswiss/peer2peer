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
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.ProjectStatus;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@ViewScoped
/**
 * Backing bean for the Create a Project page
 *
 */
public class CreateProjectBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{userController}")
	private UserController userController;
	
	private String projectName;
	private int creditAmount;
	private int duration;
	private boolean success = false;
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

	private String successMessage;
	

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	private int generateProjectMark(int amount, int duration)
	{
		double income = userController.getUser().getIncome();
		double expenses = userController.getUser().getExpenses();
		int existingCredits = userController.getUser().getExsisting_credits();
		
		double netIncome = income-expenses-existingCredits;
		
		double fluidityOverTimeFrame = netIncome*duration;
		
		if(fluidityOverTimeFrame > amount	)
		{
			double fluidityAfterPayment = fluidityOverTimeFrame-amount;
			int mark = (int)fluidityAfterPayment/(int)netIncome*10;
			return Math.min(mark, 10);
		}
			
		
		return 1;
	}
	
	/**
	 * creates a new project by the currently logged in user
	 * @return
	 */
	public String create()
	{

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.advancedweb.peer2peer.model").createEntityManager();
		
		Project project = new Project();
		project.setProjectName(projectName);
		project.setMark(this.generateProjectMark(creditAmount, duration));
		project.setAmount(creditAmount);
		project.setCreationdate(new Date());
		project.setDuration(duration);
		project.setEnddate(null);
		project.setStartdate(null);
		project.setStatus(ProjectStatus.pending);

		project.setUser(userController.getUser());
		ArrayList<Project> projects = new ArrayList<Project>();
		projects.add(project);
		userController.getUser().setProjects(projects);
		
		em.getTransaction().begin();
		em.persist(userController.getUser());
		em.getTransaction().commit();
		
		System.out.println("created project!!");
		this.successMessage = "test";
		this.success = true;
		return "success";
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(int creditAmount) {
		this.creditAmount = creditAmount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
}
