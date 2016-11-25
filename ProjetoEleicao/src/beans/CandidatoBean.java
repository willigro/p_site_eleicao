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
import classesBasicas.Estado;
import classesBasicas.Partido;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;
import facade.Facade;

@ManagedBean
@ViewScoped
public class CandidatoBean {

	private int idEstado;
	private Candidato candidato;
	private Facade fachada;
	private Estado estado;
	private Cidade cidade;
	private Partido partido;
	private List<Cidade> cidades;
	private List<Candidato> candidatos;
	private List<Estado> lista_estados;
	private List<Partido> lista_partidos;

	public CandidatoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.estado = new Estado();
		this.cidade = new Cidade();
		this.partido = new Partido();
		this.cidades = new ArrayList<>();
		this.candidatos = new ArrayList<>();
		this.lista_estados = new ArrayList<>();
	}

	// Methods
	/**
	 * Metodo para confirmação, apenas.
	 */
	public void estadoSelecionado() {
		System.out.println(this.idEstado);
		// System.out.println(this.candidato.getPartido_cand().getId_part());
		candidato.getEstado_cand().setId_est(idEstado);
	}

	public void cidadeSelecionada() {
		System.out.println(this.candidato.getCidade_cand().getId_cid());
	}

	private void addMensagem(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, null);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public String remover() throws Exception {
		try {
			this.fachada.removerCandidato(this.candidato);
			// addMensagem("Removido com Sucesso!");
			this.candidatos = this.fachada.consultarTodosCandidatos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "paginaAdmin";
	}

	public String pagComentarios() {
		return "paginaComentarios";
	}

	public String pagConsultarCandidato() {
		return "consultaCandidatos";
	}

	public String pagEditarCandidato() {
		return "paginaEditarCand";
	}
	
	public String pagAdmin(){
		return "paginaAdmin";
	}

	public String cadastrar() throws Exception {
		try {
<<<<<<< HEAD
			this.candidato.getCidade_cand().setId_cid(1);
			// this.candidato.getEstado_cand().setId_est(this.idEstado);
			this.candidato.getPartido_cand().setId_part(1);
=======
>>>>>>> f24b954557bf06569891711a398d76779040995b
			fachada.cadastrarCandidato(candidato);
			addMensagem("Cadastrado com Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "paginaAdmin";
	}

	public String editar() throws Exception {
		try {
			fachada.alterarCandidato(candidato);
			addMensagem("Editado com Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "paginaEditarCand";
	}

	public void consultarCandidatoFiltrado() {
		try {
			System.out.println(idEstado + "");
			this.candidato.getEstado_cand().setId_est(idEstado);
			System.out.println(this.candidato.toString());
			this.candidatos = fachada.consultarCandidatosFiltrados(this.candidato);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarTodosCandidatos() {
		try {
			candidatos = fachada.consultarTodosCandidatos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Getters and Setters
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
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

	public List<Cidade> getCidades() {
		try {
			this.cidades = this.fachada.consultarTodasCidade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.cidades;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Estado> getLista_estados() {
		try {
			return this.lista_estados = fachada.consultarTodosEstado();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Partido> getLista_partidos() {
		try {
			return this.lista_partidos = fachada.consultarTodosPartidos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
}
