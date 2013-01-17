package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.advancedweb.peer2peer.controller.ManageAccountController;
import ch.bfh.advancedweb.peer2peer.controller.MyCreditsController;
import ch.bfh.advancedweb.peer2peer.controller.MyProjectsController;
import ch.bfh.advancedweb.peer2peer.controller.RegisterController;
import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.Credit;
import ch.bfh.advancedweb.peer2peer.model.Loan;
import ch.bfh.advancedweb.peer2peer.model.LoanStatus;
import ch.bfh.advancedweb.peer2peer.model.Project;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@ViewScoped
public class MyProjectsBean implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@ManagedProperty("#{userController}")
	private UserController userController;
	private MyProjectsController myProjectsController;
	private List<Project> projectList;
	
	
	public MyProjectsBean(){
		System.out.println("hello");
	}
	
	public void loadProjects(){
		System.out.println("fuck you");
		this.myProjectsController = new MyProjectsController();
		this.projectList = this.myProjectsController.loadProjects(this.userController.getUser());
		
	}
	
	public String acceptFund(Loan loan){
		this.myProjectsController.acceptFund(loan);
		return "myprojects";
	}
	
	public String denieFund(Loan loan){
		this.myProjectsController.denieFund(loan);
		return "myprojects";
	}
	

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

}
