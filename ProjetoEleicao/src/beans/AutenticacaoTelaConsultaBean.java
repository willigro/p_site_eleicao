package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import classesBasicas.Administrador;
import classesBasicas.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoTelaConsultaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Administrador adm;
	private boolean renderizarLogin;

	public AutenticacaoTelaConsultaBean() {

	}

	public boolean comentar() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			this.usuario = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuarioLogado");
			if (this.usuario == null) {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", "realizar login");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				this.renderizarLogin = true;
				return false;
			} else
				this.renderizarLogin = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean renderizarEditarComentario(int id) {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			this.usuario = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuarioLogado");			
			if (this.usuario != null && this.usuario.getId_user() == id)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean getRenderizarLogin() {
		if(this.renderizarLogin)
			System.out.println("renderizado");
		else
			System.out.println("nao renderizado");
		return renderizarLogin;
	}
}
