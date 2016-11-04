package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import classesBasicas.Administrador;
import classesBasicas.Usuario;
import facade.Facade;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario;
	private Administrador administrador;
	private Facade facade;
	
	
	public String efetuarLogin(){
		try{
			if(facade.loginAdministrador(administrador) != null){
				return "/index_adm.xhtml";
			}
			if(facade.loginUsuario(usuario) != null){
				return "/index_usr.xhtml";
			}
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Login/Senha inexistente")); 
		}
		
		return "/login.xhtml/";
	}
	
	public Object getUsuarioLogado(){
		if(usuario != null){
			return this.usuario;
		}else if (administrador != null){
			return this.administrador;
		}
		return null;
	}


}
