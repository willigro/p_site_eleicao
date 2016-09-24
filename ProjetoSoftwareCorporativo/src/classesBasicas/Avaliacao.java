package classesBasicas;

public class Avaliacao {
	// Attributes
	private int id_aval;
	private Candidato candidato_aval;
	private Projeto projeto_aval;
	private Usuario usuario_aval;
	
	// Constructor
	public Avaliacao(){
		this.candidato_aval = new Candidato();
		this.projeto_aval = new Projeto();
		this.usuario_aval = new Usuario();		
	}
	
	// Methods
}