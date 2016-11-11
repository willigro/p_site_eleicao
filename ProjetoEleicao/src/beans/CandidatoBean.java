package beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
@SessionScoped
public class CandidatoBean {

	private Candidato candidato;
	private Facade fachada;
	private Estado estado;
	private Cidade cidade;
	private Partido partido;
	private List<Cidade> cidades;
	private List<Candidato> candidatos;

	public CandidatoBean() {
		this.candidato = new Candidato();
		fachada = new Facade();
		estado = new Estado();
		cidade = new Cidade();
		partido = new Partido();
		cidades = new ArrayList<>();
		candidatos = new ArrayList<>();
	}

	// Methods
	public void pagRemover() throws Exception {
	}

	public void pagCadastrar() throws Exception {
		FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/ProjetoEleicao/cadastrarCandidato.xhtml");
	}

	public String remover() throws Exception {
		try {
			//consultarCandidatoFiltrado(candidato);
			//candidato.setNumero_cand(99999);
			//candidato.getCidade_cand().setNome_cid("cidade");
			candidato.setId_cand(25);
			fachada.removerCandidato(candidato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "removerCandidato";
	}

	public String cadastrar() throws Exception {
		try {
			this.cidade.setId_cid(1);
			this.estado.setId_est(1);
			this.partido.setId_part(13);
			// candidato.getCidade_cand().setId_cid(5);
			// candidato.getEstado_cand().setId_est(5);
			// candidato.getPartido_cand().setId_part(5);
			candidato.setPartido_cand(partido);
			// candidatos.add(candidato);
			// partido.setLista_Candidato_part(candidatos);
			// estado.setLista_Candidato_est(candidatos);
			// cidades.add(cidade);
			candidato.setEstado_cand(estado);
			// estado.setLista_Cidade_est(cidades);
			candidato.setCidade_cand(cidade);
			// cidade.setEstado_cid(estado);
			//
			fachada.cadastrarCandidato(candidato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cadastrarCandidato";
	}

	public void consultarCandidatoFiltrado(Candidato candidato) {
		try {
			candidatos = fachada.consultarCandidatosFiltrados(candidato);
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
		return cidades;
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
}
