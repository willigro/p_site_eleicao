package beans;

import javax.faces.bean.ManagedBean;
import classesBasicas.Usuario;
import facade.Facade;

@ManagedBean()
public class UsuarioBean {
	
	private Usuario usuario;
	private Facade fachada;
	
	public UsuarioBean(){
		this.usuario = new Usuario();
		this.fachada = new Facade();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String cadastrarUsuario() throws Exception{
		usuario.setAtivo_user(true);
		this.fachada.cadastrarUsuario(usuario);
		return "";
	}
}
