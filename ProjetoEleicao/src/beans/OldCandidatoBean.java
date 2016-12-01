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
public class OldCandidatoBean implements Serializable {

	private Facade fachada;
	private Candidato candidato;
	private Projeto projeto;
	
	public OldCandidatoBean() {
		this.candidato = new Candidato();
		this.fachada = new Facade();		
		this.projeto = new Projeto();
	}

	//Methods
	
	//Getters e Setters
	
}
