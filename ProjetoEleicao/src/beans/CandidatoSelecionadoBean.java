package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import classesBasicas.Candidato;
import classesBasicas.Projeto;
import facade.Facade;

@ManagedBean
@ViewScoped
public class CandidatoSelecionadoBean implements Serializable {

	private Facade fachada;
	private Candidato candidato;
	private Projeto projeto;
	private List<Projeto> lista_projeto;
	
	public CandidatoSelecionadoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();		
	}

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
			this.fachada.consultarProjetosFiltrados(this.projeto);
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
}
