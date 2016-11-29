package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
import facade.Facade;

@ManagedBean
@ViewScoped
public class CandidatoSelecionadoBean implements Serializable {

	private Facade fachada;
	private Usuario usuario;
	private Candidato candidato;
	private Projeto projeto;
	private Comentario comentario;
	private List<Projeto> lista_projeto;
	private List<Comentario> lista_comentario;
	private Administrador adm;

	public CandidatoSelecionadoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();
		this.projeto = new Projeto();
		this.usuario = new Usuario();
		this.comentario = new Comentario();
		this.adm = new Administrador();
	}

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

	public void popularComentariosProposta(Projeto projeto) {
		try {
			this.projeto = projeto;
			lista_comentario = this.fachada.consultarComentarioFiltradosIdProjt(projeto);					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Captura um objeto
	public void catchIdCandidato() {
		try {
			this.candidato = (Candidato) fachada.retornarVariavel();
			System.out.println(this.candidato.getId_cand());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		System.out.println("candS set: " + this.candidato.getId_cand());
		this.candidato = candidato;
	}

	public List<Projeto> getLista_projeto() {
		try {
			this.projeto.getCanditado_proj().setId_cand(this.candidato.getId_cand());
			lista_projeto = this.fachada.consultarProjetosFiltradosIdCand(this.projeto);
			System.out.println("Lista atualizada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_projeto;
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

	public List<Comentario> getLista_comentario() {
		return lista_comentario;
	}
}

