package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;

import classesBasicas.Administrador;
import classesBasicas.Usuario;
import facade.Facade;


@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean{

	//	private static final long serialVersionUID = 1094801825228386363L;

	String username;
	String password;
	private boolean type;
	private Usuario usuario;
	private Administrador administrador;
	private Facade facade;
	private boolean loggedIn;	
	@ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean;


	public String efetuarLogin(){
		this.facade = new Facade();
		try{
			if(type){
				this.administrador = new Administrador();
				this.administrador.setEmail(username);
				this.administrador.setSenha_admin(password);


				if(facade.loginAdministrador(administrador) != null){

					FacesContext facesContext = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
					session.setAttribute("username", administrador.getEmail());

					loggedIn = true;
					return navigationBean.toMainAdministrador();
				}else{
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"A Senha ou E-amil estao incorretos!",
									"Por favor, escreva seu E-mail e Senha corretamente"));		
				}

				return navigationBean.toLogin();

			}else{
				this.usuario = new Usuario();
				this.usuario.setEmail_user(username);
				this.usuario.setSenha(password);

				if(facade.loginUsuario(this.usuario) != null){
					FacesContext facesContext = FacesContext.getCurrentInstance();
					HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
					session.setAttribute("username", usuario.getEmail_user());
					loggedIn = true;
					return navigationBean.toMainUsuario();
				}else{
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"A Senha ou E-amil estao incorretos!",
									"Por favor, escreva seu E-mail e Senha corretamente"));		
				}
			}

		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Atencao! ",e.getMessage()));

		}

		return navigationBean.toLogin();
	}

	//logout event, invalidate session
	public String logout() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		loggedIn = false;

		// Set logout message
		FacesMessage msg = new FacesMessage("", "Desconectou-se com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return navigationBean.redirectToLogin();
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

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


}
