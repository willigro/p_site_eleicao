package classesBasicas;

public class Comentario {
	// Attributes
	String texto;
	Usuario usuario;
	Projeto projeto;
	Candidato candidato;
	
	// Constructor
	public Comentario(){
		this.usuario = new Usuario();
		this.projeto = new Projeto();
		this.candidato = new Candidato();
	}

	// Methods
}
