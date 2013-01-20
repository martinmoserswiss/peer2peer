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

@ManagedBean(name="lang")
@SessionScoped
/**
 * bean to hold locale data
 *
 */
public class LanguageBean implements Serializable {

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}
