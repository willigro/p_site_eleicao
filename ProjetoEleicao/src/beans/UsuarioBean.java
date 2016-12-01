package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RateEvent;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
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
	private boolean termosUso;
	private Avaliacao avaliacao;
	

	private String search = ""; // String de pesquisa

	public UsuarioBean() {
		this.usuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.fachada = new Facade();
		this.selectedUser = new Usuario();
		this.loginBean = new LoginBean();
		this.avaliacao = new Avaliacao();

	}

	// construtores
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

	public boolean isTermosUso() {
		return termosUso;
	}

	public void setTermosUso(boolean termosUso) {
		this.termosUso = termosUso;
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

	// Metodos
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

	public void onrate(RateEvent rateEvent) {
		try {
			Usuario user = new Usuario();
			user.setId_user(16);
			Candidato cand = new Candidato();
			cand.setId_cand(3);
			this.avaliacao.setCandidato_aval(cand);
			this.avaliacao.setUsuario_aval(user);
			this.avaliacao.setProjeto_aval(null);
			this.fachada.inserirAvaliacaoCandidato(avaliacao);
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}

	}

	public void buttonAction(ActionEvent actionEvent) {
		try {
			if (this.termosUso == true) {
				this.usuario.setAtivo_user(true);
				this.loginBean.username = usuario.getEmail_user();
				this.loginBean.password = usuario.getSenha();
				this.loginBean.setType(false);
				this.fachada.cadastrarUsuario(usuario);
				//this.loginBean.efetuarLogin();
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ",
						"Aceite os termos de uso");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
			}
		} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
		}
	}

	public String cadastrarUsuario() {
		try {
			usuario.setAtivo_user(true);
			this.fachada.cadastrarUsuario(usuario);
		} catch (Exception e) {

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

	public void banirUsuario() {
		Usuario usuario = getSelectedUser();

		try {
			this.fachada.banirUsuario(usuario);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacao", "Usuario Salvo com sucesso!"));
		} catch (Exception e) {
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Flash flash = facesContext.getExternalContext().getFlash();
			flash.setKeepMessages(true);
			flash.setRedirect(true);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Advertencia", e.getMessage()));
		}

	}

}