package ch.bfh.advancedweb.peer2peer.view;

/*
Modification:
add the functionalities about the recognition of the chief (only answer to one's boss)
Author: Emmanuel Benoist
Date:  Octobre 7, 2010
 */


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Locale locale;

	public LanguageBean(){
		locale = null;
	}



	public Locale getUserLocale() { return locale;}

	public void setUserLocale(Locale locale) { this.locale = locale; }

/*
	private Locale getLocale() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale userLocale = facesContext.getExternalContext()
				.getRequestLocale();
		System.out.println("Set locale to: " + userLocale);
		try {
			System.out.println("Trying to get locale from user");
			if (facesContext.getExternalContext().getUserPrincipal() != null) {
				userLocale = UserLocalServiceUtil.getUserById(
						Long.parseLong(facesContext.getExternalContext()
								.getUserPrincipal().getName())).getLocale();
			}
			log.debug("Got locale from user. Now its: " + userLocale);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userLocale;
	}*/

}