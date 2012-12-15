package ch.bfh.advancedweb.peer2peer.common;

import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.AbortProcessingException;
//import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.util.Locale;
import javax.servlet.http.HttpSession;

import ch.bfh.advancedweb.peer2peer.view.LanguageBean;

public class LanguageChangedActionEvent implements ActionListener {
    
    public void processAction(ActionEvent e) throws AbortProcessingException {
	System.out.println("-------------------------");
	System.out.println("Change language: "+e.getComponent().getId());
	String language = e.getComponent().getId();
	FacesContext context = FacesContext.getCurrentInstance();
	Locale locale = new Locale(language);
	context.getViewRoot().setLocale(locale);
	
	System.out.println("Changed to locale: "+locale);
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);	
	LanguageBean lb = (LanguageBean)(session.getAttribute("lang"));
	lb.setLanguage(language);
	System.out.println(lb);
	System.out.println("-------------------------");

	

    }

}