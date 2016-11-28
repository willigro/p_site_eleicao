package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import classesBasicas.Candidato;
import facade.Facade;

@ManagedBean
@ViewScoped
public class CandidatoSelecionadoBean implements Serializable {

	private Candidato candidato;
	private Facade fachada;
	
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

}
