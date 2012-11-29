package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ch.bfh.advancedweb.peer2peer.controller.UserController;

@ManagedBean(name="login")
@SessionScoped
public class LoginBean implements Serializable {
	
	@ManagedProperty(value="#{login}")
	private UserController userController;
	private String email;
	private String password;
	private String message;
	
	public LoginBean(){
		this.message = "idle";
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	
	public String login(){
		if(this.userController.isValid(this.email, this.password)){
			this.message = "Successful";
		}
		else{
			this.message = "Error";
		}
		return null;
	}
	
	public String getMessage(){
		return this.message;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
