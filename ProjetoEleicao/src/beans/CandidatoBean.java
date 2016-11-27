package beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import classesBasicas.Candidato;
import classesBasicas.Cargo;
import classesBasicas.Cidade;
import classesBasicas.Estado;
import classesBasicas.Partido;
import facade.Facade;

@ManagedBean
@ViewScoped
public class CandidatoBean implements Serializable {

	private Cargo cargo;
	private Candidato candidato;
	private Facade fachada;
	private Estado estado;
	private Cidade cidade;
	private Partido partido;
	private List<Cargo> lista_cargos;
	private List<Cidade> cidades;
	private List<Cidade> lista_cidades_filtrados;
	private List<Candidato> candidatos;
	private List<Estado> lista_estados;
	private List<Partido> lista_partidos;

	public CandidatoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.cargo = new Cargo();
		this.estado = new Estado();
		this.cidade = new Cidade();
		this.partido = new Partido();
		this.cidades = new ArrayList<>();
		this.candidatos = new ArrayList<>();
		this.lista_estados = new ArrayList<>();
		this.lista_cidades_filtrados = new ArrayList<>();
	}

	// Methods
	/**
	 * Metodo para confirma��o, apenas.
	 */
	public void estadoSelecionaCidade() {
		try {
			this.cidade.getEstado_cid().setId_est(candidato.getEstado_cand().getId_est());
			if (cidade.getEstado_cid().getId_est() > 0)
				this.lista_cidades_filtrados = this.fachada.consultarCidadeFiltrada(this.cidade);
			else
				this.lista_cidades_filtrados = new ArrayList<>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cidadeSelecionada() {
		System.out.println(this.candidato.getCidade_cand().getId_cid());
	}

	private void addMensagem(String texto) {
		FacesContext mensagem = FacesContext.getCurrentInstance();
		mensagem.addMessage(null, new FacesMessage("Cadastrado com Sucesso", "!"));
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

	public String pagAdmin() {
		return "paginaAdmin";
	}

	public void pagCandidato(Candidato candidato) {
		try {
			System.out.println("id cand: " + candidato.getId_cand() + " nome: "  + candidato.getNome_cand());
			this.fachada.armazenarVariavel(candidato);
			System.out.println("pag: " + candidato.toString());
			FacesContext.getCurrentInstance().getExternalContext().redirect("telaCandidato.xhtml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String cadastrar() throws Exception {
		try {
			this.candidato.getCidade_cand().setId_cid(1);
			// this.candidato.getEstado_cand().setId_est(this.idEstado);
			this.candidato.getPartido_cand().setId_part(1);

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
			if (cargo.getNome_cargo() != null && !cargo.getNome_cargo().trim().equals(""))
				this.candidato.setTipo_Cargo_cand(cargo.getNome_cargo());
			else
				this.candidato.setTipo_Cargo_cand(null);
			System.out.println("consul: " + this.candidato.toString());
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

	public List<Cidade> getLista_cidades_filtrados() {
		return lista_cidades_filtrados;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public List<Cargo> getLista_cargos() {
		this.lista_cargos = new ArrayList();
		Cargo presidente = new Cargo();
		presidente.setId_cargo(1);
		presidente.setNome_cargo("Presidente");
		Cargo deputado = new Cargo();
		deputado.setId_cargo(2);
		deputado.setNome_cargo("Deputado");
		Cargo vereador = new Cargo();
		vereador.setId_cargo(3);
		vereador.setNome_cargo("Vereador");
		this.lista_cargos.add(presidente);
		this.lista_cargos.add(deputado);
		this.lista_cargos.add(vereador);
		return lista_cargos;
	}
}
