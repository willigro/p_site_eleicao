package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import classesBasicas.Candidato;
import facade.Facade;

@ManagedBean
@SessionScoped
public class CandidatoBean {

	private Candidato candidato;
	private Facade fachada = new Facade();

	public void CandiatoBean() {
	}

	public String cadastrar() throws Exception {
		candidato = new Candidato();
		fachada.cadastrarCandidato(candidato);
		return null;
		// return "retornar pro index";
	}

	// Getters and Setters
	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}
