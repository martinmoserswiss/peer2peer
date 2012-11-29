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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value="#{LoginBean}")
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
			this.message = "Not right password";
		}
		return null;
	}
	
	public String getMessage(){
		return this.message;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
