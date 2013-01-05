package ch.bfh.advancedweb.peer2peer.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ch.bfh.advancedweb.peer2peer.controller.UserController;

@ManagedBean
@SessionScoped
public class LogoutBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{userController}")
	private UserController userController;

	private String message;
	private boolean isLoggedOut = false;
	
	public LogoutBean(){
		
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	
	public void logout(){

		this.message = "isLoggedOut wurde auf true gesetzt";
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

	}
	
	public String getMessage(){
		return this.message;
	}
	
	public boolean isLoggedOut() {
		return isLoggedOut;
	}

}
