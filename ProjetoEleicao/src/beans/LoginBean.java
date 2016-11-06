package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



import classesBasicas.Administrador;
import classesBasicas.Usuario;
import facade.Facade;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	private boolean type;
	private Usuario usuario;
	private Administrador administrador;
	private Facade facade;
	
	
	
	public LoginBean(){
		
		this.administrador = new Administrador();
		this.facade = new Facade();
		this.usuario = new Usuario();
		
	}
	
	
	
	public String efetuarLogin(){
		
		try{
			if(type){
				System.out.println("entrou em adm");
				if(facade.loginAdministrador(administrador) != null){
					return "/admin/index.xhtml";
				}
			}else{
				System.out.println("entrou em usr");
				if(facade.loginUsuario(usuario) != null){
					return "/usr/index.xhtml";
				}
			}
			
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Login/Senha inexistente")); 
		}
		
		return "/login.xhtml";
	}
	
	public Object getUsuarioLogado(){
		if(!type){

			if(usuario != null){
				return this.usuario;
			}
		}else{
			if (administrador != null){
				return this.administrador;
			}

		}
		return null;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Administrador getAdministrador() {
		return administrador;
	}


	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}


	public Facade getFacade() {
		return facade;
	}


	public void setFacade(Facade facade) {
		this.facade = facade;
	}

}
