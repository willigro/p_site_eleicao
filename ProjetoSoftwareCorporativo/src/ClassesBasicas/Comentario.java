package ClassesBasicas;

public class Comentario {
	String texto;
	Usuario usuario;
	Projeto projeto;
	Candidato candidato;
	
	public Comentario(){
		this.usuario = new Usuario();
		this.projeto = new Projeto();
		this.candidato = new Candidato();
	}

}
