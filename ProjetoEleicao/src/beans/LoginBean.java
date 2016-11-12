package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.log.Log;

import classesBasicas.Administrador;
import classesBasicas.Usuario;
import facade.Facade;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {

	String username;
	String password;
	private boolean type;
	private Usuario usuario;
	private Administrador administrador;
	private Facade facade;
	
	
	
	
	
	public String efetuarLogin(){
		System.out.println(type);
		this.facade = new Facade();
		try{
			if(type){
				this.administrador = new Administrador();
				this.administrador.setEmail(username);
				this.administrador.setSenha_admin(password);
				
				
				if(facade.loginAdministrador(administrador) != null){
					return "/admin/index.xhtml";
				}
			}else{
				this.usuario = new Usuario();
				this.usuario.setEmail_user(username);
				this.usuario.setSenha(password);
				
				if(facade.loginUsuario(this.usuario) != null){
					return "/usr/index.xhtml";
				}
			}
			
		}catch(Exception e){
//			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Login/Senha inexistente"));
			e.printStackTrace();
		}
		
		return "/login.xhtml";
	}
	
	public Object getUsuarioLogado(){
		if(!type){

			if(this.usuario != null){
				return this.usuario;
			}
		}else{
			if (this.administrador != null){
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

	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


}
