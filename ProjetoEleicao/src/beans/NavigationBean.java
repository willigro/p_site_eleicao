package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
/**
 * Simple navigation bean
 * @author jaime
 *
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {
 
    private static final long serialVersionUID = 1520318172495977648L;
 
    
    public NavigationBean() {
	
	}
    /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }
     
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/login.xhtml";
    }
    /**
     * Redirect to admin index page.
     * @return Index page name.
     */
    public String redirectToMainAdministrador() {
        return "/admin/index.xhtml?faces-redirect=true";
    }
     
    /**
     * Go to admin index page.
     * @return Index page name.
     */
    public String toMainAdministrador() {
        return "/admin/index.xhtml";
    }

     
    /**
     * Redirect to main page.
     * @return Index page name.
     */
    public String redirectToWelcome() {
        return "/principal.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to admin main page.
     * @return Index page name.
     */
    public String toMainUsuario() {
        return "/usr/index.xhtml";
    }

    /**
     * Redirect to welcome page.
     * @return Index page name.
     */
    public String redirectToMainUsuario() {
        return "/usr/index.xhtml?faces-redirect=true";
    }
    
     
    /**
     * Go to principal page.
     * @return Principal page name.
     */
    public String toWelcome() {
        return "/principal.xhtml";
    }
}
