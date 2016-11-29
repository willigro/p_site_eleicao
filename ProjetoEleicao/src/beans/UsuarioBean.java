package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.UsuarioDAO;
import facade.Facade;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	private Facade fachada;
	private List<Usuario> usuarios;
	public Usuario selectedUser;
	private LoginBean loginBean;
	private boolean type; // para verificar se o usuario e adm ou usr
	private boolean termosUso;

	private String search = ""; // String de pesquisa

	public UsuarioBean() {
		this.usuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.fachada = new Facade();
		this.selectedUser = new Usuario();
		this.loginBean = new LoginBean();

	}

	// continuar
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

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public List<Usuario> getUsuarios() {
		try {
			if (search.toString().isEmpty()) {
				usuarios = fachada.consultarUsuarios();
			} else {
				Usuario u = new Usuario();
				u.setNome_user(search);
				usuarios = fachada.consultarUsuarioPorFiltro(usuario);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}

	public void setUsuarios(List<Usuario> list) {
		this.usuarios = list;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void buttonAction(ActionEvent actionEvent) {
		try {
			if (this.termosUso == true) {
				this.usuario.setAtivo_user(true);
				this.loginBean.username = usuario.getEmail_user();
				this.loginBean.password = usuario.getSenha();
				this.loginBean.setType(false);
				this.fachada.cadastrarUsuario(usuario);
				this.loginBean.efetuarLogin();
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ", "Aceite os termos de uso");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
			}
		} catch (Exception e) {
			addMensagem(e.getMessage());
		}
	}

	private void addMensagem(String texto) {
		
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

	public void searchUser() {

		try {
			if (search.toString().isEmpty()) {
				this.usuarios = this.fachada.consultarUsuarios();
			} else {
				Usuario u = new Usuario();
				u.setNome_user(search);
				System.out.println("valor do filtro: " + search);
				this.usuarios = this.fachada.consultarUsuarioPorFiltro(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// continuar
	public void banirUsuario() {
		Usuario usuario = getSelectedUser();

		try {
			this.fachada.banirUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isTermosUso() {
		return termosUso;
	}

	public void setTermosUso(boolean termosUso) {
		this.termosUso = termosUso;
	}

}