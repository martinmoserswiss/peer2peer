package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ch.bfh.advancedweb.peer2peer.controller.ManageAccountController;
import ch.bfh.advancedweb.peer2peer.controller.MyCreditsController;
import ch.bfh.advancedweb.peer2peer.controller.RegisterController;
import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.Credit;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class MyCreditsBean implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@ManagedProperty("#{userController}")
	private UserController userController;
	private MyCreditsController myCreditsController;
	private List<Credit> creditList;
	
	
	public MyCreditsBean(){
		
	}
	
	public void loadCredits(){
		this.myCreditsController = new MyCreditsController();
		this.creditList = this.myCreditsController.loadCredits(this.userController.getUser());
	}
	

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public List<Credit> getCreditList() {
		return creditList;
	}

	public void setCreditList(List<Credit> creditList) {
		this.creditList = creditList;
	}

}
