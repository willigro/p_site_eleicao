package beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import classesBasicas.Candidato;
import classesBasicas.Cidade;
import classesBasicas.Comentario;
import classesBasicas.Denuncia;
import classesBasicas.Estado;
import classesBasicas.Partido;
import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;
import facade.Facade;

@ManagedBean
@ViewScoped
public class ComentarioBean {

	private Candidato candidato;
	private Facade fachada;
	private Estado estado;
	private Cidade cidade;
	private Partido partido;
	private List<Cidade> cidades;
	private List<Candidato> candidatos;
	private List<Estado> lista_estados;
	private List<Partido> lista_partidos;
	private List<Comentario> comentarios;
	private Denuncia denunciar;
	private Usuario usuarioLogado;
	private Comentario comentarioSelecionado;



	public ComentarioBean() {
		this.usuarioLogado = new Usuario();
		this.comentarioSelecionado = new Comentario();
		this.denunciar = new Denuncia();
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.estado = new Estado();
		this.cidade = new Cidade();
		this.partido = new Partido();
		this.cidades = new ArrayList<>();
		this.candidatos = new ArrayList<>();
		this.lista_estados = new ArrayList<>();
		this.comentarios = new ArrayList<>();
	}

	// Methods
	private void addMensagem(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void denunciarComentario(){
		this.denunciar.setUsuario(usuarioLogado);
		this.denunciar.setComentario(comentarioSelecionado);
		try {
			this.fachada.denunciarComentario(denunciar);
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Comentario denunciado!", null);
		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
		}
	}
	
	
	
	//Nao sei quem fez esse metodo mas vou talvez nao precise utiliza-lo
	public void consultarComentsDenunciados() {
		try {
			this.comentarios = fachada.visualizarComentsDenuncia();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover() {

	}

	// getters e setters

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Facade getFachada() {
		return fachada;
	}

	public void setFachada(Facade fachada) {
		this.fachada = fachada;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Estado> getLista_estados() {
		return lista_estados;
	}

	public void setLista_estados(List<Estado> lista_estados) {
		this.lista_estados = lista_estados;
	}

	public List<Partido> getLista_partidos() {
		return lista_partidos;
	}

	public void setLista_partidos(List<Partido> lista_partidos) {
		this.lista_partidos = lista_partidos;
	}

	public List<Comentario> getComentarios() {
		try {
			this.comentarios = this.fachada.visualizarComentsDenuncia();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comentarios;
	}

	public List<Cidade> getCidades() {
		return this.cidades;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public String pagComentarios() {
		return "paginaComentarios";
	}
	
	public Denuncia getDenunciar() {
		return denunciar;
	}

	public void setDenunciar(Denuncia denunciar) {
		this.denunciar = denunciar;
	}


	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Comentario getComentarioSelecionado() {
		return comentarioSelecionado;
	}

	public void setComentarioSelecionado(Comentario comentarioSelecionado) {
		this.comentarioSelecionado = comentarioSelecionado;
	}
}
