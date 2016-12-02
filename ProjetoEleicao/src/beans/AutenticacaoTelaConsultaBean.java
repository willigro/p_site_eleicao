package beans;

import java.io.Serializable;

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

	public AutenticacaoTelaConsultaBean() {

	}

	public boolean renderizarEditarComentario() {
		try {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			usuario = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuarioLogado");;
			if(usuario == null)
				System.out.println("usuario nulo, n logado");
			else
				System.out.println("usuario logado nome: " + usuario.getNome_user());
//			(true);
//			session.getAttribute("temp");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
