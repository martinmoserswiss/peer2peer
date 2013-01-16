package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import ch.bfh.advancedweb.peer2peer.controller.ManageAccountController;
import ch.bfh.advancedweb.peer2peer.controller.MyCreditsController;
import ch.bfh.advancedweb.peer2peer.controller.RegisterController;
import ch.bfh.advancedweb.peer2peer.controller.UserController;
import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class MyCreditsBean implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@ManagedProperty("#{userController}")
	private UserController userController;
	private MyCreditsController myCreditsController;
	
	
	public MyCreditsBean(){
		
	}
	
	public void loadCredits(){
		
		
		
	}
	

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

}
