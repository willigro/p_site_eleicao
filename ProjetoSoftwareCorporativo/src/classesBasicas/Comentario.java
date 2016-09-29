package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comentario {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_comentario;
	
	@Column(nullable=false,length=500)
	private String texto;
	
	private Usuario usuario;
	private Projeto projeto;
	private Candidato candidato;
	
	// Constructor
	public Comentario(){
		this.usuario = new Usuario();
		this.projeto = new Projeto();
		this.candidato = new Candidato();
	}

	// Methods
}
