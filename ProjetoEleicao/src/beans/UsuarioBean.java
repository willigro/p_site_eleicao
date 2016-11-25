package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import classesBasicas.Usuario;
import facade.Facade;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	private Facade fachada;
	private List<Usuario> usuarios;
	public List<Usuario> consultarUsuarios;
	public Usuario selectedUser;
	private String search;
	

	public UsuarioBean() {
		this.consultarUsuarios = new ArrayList<Usuario>();
		this.usuarios = new ArrayList<>();
		this.usuario = new Usuario();
		this.fachada = new Facade();
		this.selectedUser = new Usuario();
	}
	

	//continuar
	public Usuario getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(Usuario selectedUser) {
		this.selectedUser = selectedUser;
	}
	

	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}



	public List<Usuario> getConsultarUsuarios() {
		try {
			consultarUsuarios = fachada.consultarUsuarios();
			usuarios = consultarUsuarios;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consultarUsuarios;
	}
	
	public void setConsultarUsuarios(List<Usuario> consultarUsuarios) {
		this.consultarUsuarios = consultarUsuarios;
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
	
	
	public List<Usuario> searchUser(){
		List<Usuario> retorno = new ArrayList<>();
		try{
			if(search.equals("")){
				this.fachada.consultarUsuarios();
			}else{
				Usuario u = new Usuario();
				u.setNome_user(search);
				this.fachada.consultarUsuarioPorFiltro(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return retorno;
		
	}
	
	//continuar
	public void banirUsuario(){
		Usuario usuario = getSelectedUser(); 
		
		try {
			this.fachada.banirUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}