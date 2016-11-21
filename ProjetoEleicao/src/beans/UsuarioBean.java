package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import classesBasicas.Usuario;
import facade.Facade;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	private Facade fachada;
	private ArrayList<Usuario> usuarios;

	public UsuarioBean() {
		this.usuarios = new ArrayList<>();
		this.usuario = new Usuario();
		this.fachada = new Facade();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void buttonAction(ActionEvent actionEvent) {
		try {
			usuario.setAtivo_user(true);
			this.fachada.cadastrarUsuario(usuario);
			addMensagem("Cadastrado com Sucesso!");
		} catch (Exception e) {
			addMensagem(e.getMessage());
		}
	}

	private void addMensagem(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public String cadastrarUsuario() {
		try {
			usuario.setAtivo_user(true);
			this.fachada.cadastrarUsuario(usuario);
			addMensagem("Cadastrado com Sucesso!");
		} catch (Exception e) {
			addMensagem(e.getMessage());
		}
		return "";
	}
}