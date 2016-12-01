package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

	private Facade fachada;
	private Candidato candidato;
	private Projeto projeto;
	private List<Projeto> lista_projeto;
	private Usuario usuario;
	private Comentario comentario;
	private Comentario comentarioEditar;
	private List<Comentario> lista_comentario;
	private Administrador adm;

	public CandidatoSelecionadoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.projeto = new Projeto();
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.projeto = new Projeto();
		this.usuario = new Usuario();
		this.comentario = new Comentario();
		this.comentarioEditar = new Comentario();
		this.adm = new Administrador();
	}

	// Methods
	public String comentarioProsposta() {
		try {
			this.adm.setId_admin(1);
			this.usuario.setId_user(1);
			this.comentario.setUsuario_coment(this.usuario);
			this.comentario.setCandidato_coment(this.projeto.getCanditado_proj());
			this.comentario.setAdministrador_coment(adm);
			this.comentario.setProjeto_coment(this.projeto);
			this.comentario.setId_coment(0);
			this.fachada.inserirComentarioProjeto(this.comentario);
			popularComentariosProposta(this.projeto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
<<<<<<< HEAD

	public String comentarioCandidato() {
		try {
			this.adm.setId_admin(1);
			this.usuario.setId_user(1);
			this.comentario.setUsuario_coment(this.usuario);
			this.comentario.setCandidato_coment(this.candidato);
			this.comentario.setAdministrador_coment(adm);
			this.comentario.setProjeto_coment(null);
			this.comentario.setId_coment(0);
			this.fachada.inserirComentarioCandidato(this.comentario);
			getLista_comentarioCandidato();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String editarComentarioProposta() {
		try {
			this.fachada.atualizarComentario(this.comentarioEditarProjeto);
=======
	
	public String editarComentarioProposta(){
		try{			
			this.fachada.atualizarComentario(this.comentarioEditar);
>>>>>>> c7f75cb252a9cc772f3054a0a6ddced13f5ac8ca
			popularComentariosProposta(this.projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void popularComentariosProposta(Projeto projeto) {
		try {
			this.projeto = projeto;
			lista_comentario = this.fachada.consultarComentarioFiltradosIdProjt(projeto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void catchIdCandidato() {
		try {
			this.candidato = (Candidato) fachada.retornarVariavel();
<<<<<<< HEAD
=======
			System.out.println(this.candidato.getId_cand());
>>>>>>> c7f75cb252a9cc772f3054a0a6ddced13f5ac8ca
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Projeto> getLista_projeto() {
		try {
<<<<<<< HEAD
			if (this.candidato != null) {
				this.projeto.getCanditado_proj().setId_cand(this.candidato.getId_cand());
				lista_projeto = this.fachada.consultarProjetosFiltradosIdCand(this.projeto);
			} else {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				context.redirect("consultaCandidato.xhtml");
			}
=======
			this.projeto.getCanditado_proj().setId_cand(this.candidato.getId_cand());
			lista_projeto = this.fachada.consultarProjetosFiltradosIdCand(this.projeto);
			System.out.println(lista_projeto.get(0).getId_proj());
>>>>>>> c7f75cb252a9cc772f3054a0a6ddced13f5ac8ca
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista_projeto;
	}

	public String editar() throws Exception {
		try {

			System.out.println("ID DEPOIS DO BOTÃO EDITAR: " + candidato.getId_cand());
			System.out.println("NUMERO DEPOIS DO BOTÃO EDITAR: " + candidato.getNumero_cand());
			System.out.println("CIDADE ID DEPOIS DO BOTÃO EDITAR: " + candidato.getCidade_cand().getId_cid());
			System.out.println("CIDADE ID DEPOIS DO BOTÃO EDITAR: " + candidato.getCidade_cand().getNome_cid());

			fachada.alterarCandidato(candidato);
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

	// Getters e Setters
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
<<<<<<< HEAD
=======
		System.out.println("candS set: " + this.candidato.getId_cand());
>>>>>>> c7f75cb252a9cc772f3054a0a6ddced13f5ac8ca
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

<<<<<<< HEAD
	public List<Comentario> getLista_comentarioProjeto() {
		return lista_comentarioProjeto;
	}

	public Comentario getComentarioEditarProjeto() {
		return comentarioEditarProjeto;
	}

	public void setComentarioEditarProjeto(Comentario comentarioEditar) {
		this.comentarioEditarProjeto = comentarioEditar;
	}

	public List<Comentario> getLista_comentarioCandidato() {
		try {
			if (this.candidato != null) {
				this.lista_comentarioCandidato = this.fachada.consultarComentarioFiltradosIdCand(this.candidato);
			} else {
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				context.redirect("consultaCandidato.xhtml");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_comentarioCandidato;
=======
	public List<Comentario> getLista_comentario() {
		return lista_comentario;
>>>>>>> c7f75cb252a9cc772f3054a0a6ddced13f5ac8ca
	}

	public Comentario getComentarioEditar() {
		return comentarioEditar;
	}

	public void setComentarioEditar(Comentario comentarioEditar) {
		System.out.println("Sera que setou: " + comentarioEditar.getTexto_coment());
		this.comentarioEditar = comentarioEditar;
	}

}
