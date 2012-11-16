package ch.bfh.advancedweb.peer2peer.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ch.bfh.advancedweb.peer2peer.model.User;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public LoginController(){
		this.user = new User();
	}
	
	public void submit(){
		FacesMessage message = new FacesMessage("Hello Peer2Peer");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public User getUser(){
		return this.user;
	}

}
