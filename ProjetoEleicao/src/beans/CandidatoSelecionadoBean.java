package beans;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.sun.prism.Image;

import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Cargo;
import classesBasicas.Cidade;
import classesBasicas.Comentario;
import classesBasicas.Estado;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
import facade.Facade;

@ManagedBean
@SessionScoped
public class CandidatoSelecionadoBean implements Serializable {

	private List<Projeto> projetos;
	private Candidato oldCand;
	private Facade fachada;
	private Candidato candidato;
	private Projeto projeto;
	private List<Projeto> lista_projeto;
	private Usuario usuario;
	private Comentario comentario;
	private Comentario comentarioEditarProjeto;
	private Comentario comentarioEditarCandidato;
	private List<Comentario> lista_comentarioProjeto;
	private List<Comentario> lista_comentarioCandidato;
	private Administrador adm;
	private AutenticacaoTelaConsultaBean atcBean;

	public CandidatoSelecionadoBean() {
		this.projetos = new ArrayList<>();
		this.oldCand = new Candidato();
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.projeto = new Projeto();
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.projeto = new Projeto();
		this.usuario = new Usuario();
		this.comentario = new Comentario();
		this.comentarioEditarProjeto = new Comentario();
		this.comentarioEditarCandidato = new Comentario();
		this.adm = new Administrador();
		this.atcBean = new AutenticacaoTelaConsultaBean();
	}

	// Methods
	public String comentarioProsposta() {
		try {
			if (atcBean.comentar()) {
				this.adm.setId_admin(1);
				this.comentario.setUsuario_coment(atcBean.getUsuario());
				this.comentario.setCandidato_coment(this.projeto.getCanditado_proj());
				this.comentario.setAdministrador_coment(adm);
				this.comentario.setProjeto_coment(this.projeto);
				this.comentario.setId_coment(0);
				this.fachada.inserirComentarioProjeto(this.comentario);
				popularComentariosProposta(this.projeto);
			}
		} catch (Exception e) {
			FacesContext mensagem = FacesContext.getCurrentInstance();
			mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: ", e.getMessage()));
			e.printStackTrace();
		}
		return null;
	}

	public String comentarioCandidato() {
		try {
			if (atcBean.comentar()) {
				this.adm.setId_admin(1);
				this.comentario.setUsuario_coment(atcBean.getUsuario());
				this.comentario.setCandidato_coment(this.candidato);
				this.comentario.setAdministrador_coment(adm);
				this.comentario.setProjeto_coment(null);
				this.comentario.setId_coment(0);
				this.fachada.inserirComentarioCandidato(this.comentario);
				getLista_comentarioCandidato();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String editarComentarioProposta() {
		try {
			this.fachada.atualizarComentario(this.comentarioEditarProjeto);
			popularComentariosProposta(this.projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void popularComentariosProposta(Projeto projeto) {
		try {
			this.projeto = projeto;
			lista_comentarioProjeto = this.fachada.consultarComentarioFiltradosIdProjt(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void catchIdCandidato() {
		try {
			this.candidato = (Candidato) fachada.retornarVariavel();
			this.oldCand = this.candidato;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Projeto> getLista_projeto() {
		try {
			if (this.candidato != null) {
				this.projeto.getCanditado_proj().setId_cand(this.candidato.getId_cand());
				lista_projeto = this.fachada.consultarProjetosFiltradosIdCand(this.projeto);
			} else {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				context.redirect("consultaCandidato.xhtml");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista_projeto;
	}

	public void addProjeto() throws Exception {
		try {

			this.projeto.getCanditado_proj().setId_cand(this.candidato.getId_cand());

			lista_projeto.add(this.projeto);
			mensagemSucessoProposta("Adicionado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			mensagemSucessoFalha(e.getMessage());
		}
	}

	public String editar() throws Exception {
		try {
			fachada.alterarCandidato(candidato, oldCand);
			mensagemSucessoEdit("Editado com Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			mensagemFalhaEdit(e.getMessage());
		}
		return "paginaEditarCand";
	}

	private void mensagemSucessoEdit(String texto) {
		FacesContext mensagem = FacesContext.getCurrentInstance();
		mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com Sucesso", texto));
	}

	private void mensagemFalhaEdit(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", texto);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	private void mensagemSucessoProposta(String texto) {
		FacesContext mensagem = FacesContext.getCurrentInstance();
		mensagem.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado Proposta", texto));
	}

	private void mensagemSucessoFalha(String texto) {
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: ", texto);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	// Getters e Setters
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Candidato getOldCand() {
		return oldCand;
	}

	public void setOldCand(Candidato oldCand) {
		this.oldCand = oldCand;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public List<Comentario> getLista_comentarioProjeto() {
		return lista_comentarioProjeto;
	}

	public Comentario getComentarioEditarProjeto() {
		return comentarioEditarProjeto;
	}

	public void setComentarioEditarProjeto(Comentario comentarioEditar) {
		this.comentarioEditarProjeto = comentarioEditar;
	}

	public Comentario getComentarioEditarCandidato() {
		return comentarioEditarCandidato;
	}

	public void setComentarioEditar(Comentario comentarioEditar) {
		this.comentarioEditarCandidato = comentarioEditarCandidato;
	}

	public List<Comentario> getLista_comentarioCandidato() {
		try {
			this.lista_comentarioCandidato = this.fachada.consultarComentarioFiltradosIdCand(this.candidato);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lista_comentarioCandidato;
	}
}
