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
     * Go to Principal page.
     * @return Principal page name.
     */
    public String toWelcome() {
        return "/principal.xhtml";
    }
    
    
    
    
    /**
     * Redirect to CriarCandidato page.
     * @return CriarCandidato page name.
     */
    public String redirectToCriarCandidato() {
        return "/admin/candidate/criarCandidato.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to CriarCandidato page.
     * @return CriarCandidato page name.
     */
    public String toCriarCandidato(){
    	return "/admin/candidate/criarCandidato.xhtml";
    }
    
    
    
    /**
     * Redirect to EditarCandidato page.
     * @return EditarCandidato page name.
     */
    public String redirectToEditarCandidato() {
        return "/admin/candidate/editarCandidato.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to EditarCandidato page.
     * @return EditarCandidato page name.
     */
    public String toEditarCandidato(){
    	return "/admin/candidate/editarCandidato.xhtml";
    }
    
    
    
    /**
     * Redirect to ConsultarCandidato page.
     * @return ConsultarCandidato page name.
     */
    public String redirectToConsultarCandidato() {
        return "/admin/candidate/consultarCandidato.xhtml?faces-redirect=true";
    }
    /**
     * Go to ConsultarCandidato page.
     * @return ConsultarCandidato page name.
     */
    public String toConsultarCandidato(){
    	return "/admin/candidate/consultarCandidato.xhtml";
    }
    
    

    /**
     * Redirect to ConsultarUsuario page.
     * @return ConsultarUsuario page name.
     */
    public String redirectToConsultrUsuario() {
        return "/admin/users/consultarUsuario.xhtml?faces-redirect=true";
    }
    /**
     * Go to ConsultrUsuario page.
     * @return ConsultarUsuario page name.
     */
    public String toConsultrUsuario(){
    	return "/admin/users/consultarUsuario.xhtml";
    }
    
    
    /**
     * Redirect to ConsultarUsuario page.
     * @return ConsultarUsuario page name.
     */
    public String redirectToConsultarErro() {
        return "/admin/system/tools/consultarErros.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to ConsultarErros page.
     * @return ConsultarErros page name.
     */
    public String toConsultarErro(){
    	return "/admin/system/tools/consultarErros.xhtml";
    }
    
    
    /**
     * Redirect to ConsultarDenunciaComentarios page.
     * @return ConsultarDenunciaComentarios page name.
     */
    public String redirectToConsultarDenunciaComentarios() {
        return "/admin/denouncements/consultarComentarios.xhtml?faces-redirect=true";
    }
    
    /**
     * Go to ConsultarDenunciaComentarios page.
     * @return ConsultarDenunciaComentarios page name.
     */
    public String toConsultarDenunciaComentarios(){
    	return "/admin/denouncements/consultarComentarios.xhtml";
    }
    
}
