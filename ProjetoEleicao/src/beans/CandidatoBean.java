package beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
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
	private StreamedContent foto;

	private NavigationBean navigationBean;

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
		this.navigationBean = new NavigationBean();
	}

	// Methods
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

	private void mensagemSucessoCadastrado(String texto) {
		FacesContext mensagem = FacesContext.getCurrentInstance();
		mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso", texto));
	}

	private void mensagemFalhaCadastro(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", texto);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	private void mensagemFalhaConsulta(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", texto);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public String remover() throws Exception {
		try {
			this.fachada.removerCandidato(this.candidato);
			this.candidatos = this.fachada.consultarTodosCandidatos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String pagComentarios() {
		return "paginaComentarios";
	}

	public String pagConsultarCandidato() {
		return "consultaCandidatos";
	}

	public String pagAdmin() {
		return "paginaAdmin";
	}

	public String paginaEditarCand(Candidato candidato) {
		try {
			this.fachada.armazenarVariavel(candidato);
			System.out.println("pag: " + candidato.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return navigationBean.toEditarCandidato();
	}

	public String pagCandidato(Candidato candidato) {
		try {
			this.fachada.armazenarVariavel(candidato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "telaCandidato.xhtml?faces-redirect=true";
	}

	public void fileUpload(FileUploadEvent event) {
		try {
			UploadedFile arq = event.getFile();
			byte[] imagem = event.getFile().getContents();
			this.candidato.setFoto_cand(imagem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String cadastrar() throws Exception {
		try {
			fachada.cadastrarCandidato(candidato);
			mensagemSucessoCadastrado("");
		} catch (Exception e) {
			e.printStackTrace();
			mensagemFalhaCadastro(e.getMessage());
		}
		return navigationBean.toConsultarCandidato();

	}

	/*
	 * public String editar() throws Exception { try { // setando manualmente o
	 * novo candidato ID (num e city pega na view) // candidato.setId_cand(113);
	 * // System.out.println(candidato.getId_cand());
	 * 
	 * System.out.println("DEPOIS DO BOT�O EDITAR: " +
	 * candidato.getId_cand());
	 * 
	 * fachada.alterarCandidato(this.candidato); //
	 * addMensagem("Editado com Sucesso!"); } catch (Exception e) {
	 * e.printStackTrace(); } return "paginaEditarCand"; }
	 */

	// return "paginaAdmin";
	// }

	public void consultarCandidatoFiltrado() {
		try {
			if (cargo.getNome_cargo() != null && !cargo.getNome_cargo().trim().equals(""))
				this.candidato.setTipo_Cargo_cand(cargo.getNome_cargo());
			else
				this.candidato.setTipo_Cargo_cand(null);
			System.out.println("consul: " + this.candidato.toString());
			this.candidatos = fachada.consultarCandidatosFiltrados(this.candidato);

			if (this.candidatos.get(0).getFoto_cand() != null)
				System.out.println("imagem aqui");
			else
				System.out.println("sem imagem");
		} catch (Exception e) {
			e.printStackTrace();
			mensagemFalhaConsulta(e.getMessage());
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

	public StreamedContent getFoto() {
		try {
			if (this.candidato.getFoto_cand() != null)
				return new DefaultStreamedContent(new ByteArrayInputStream(this.candidato.getFoto_cand()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
