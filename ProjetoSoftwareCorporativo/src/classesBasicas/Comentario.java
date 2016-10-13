package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_comentario")
public class Comentario {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_coment;
	
	@Column(nullable=false,length=500)
	private String texto_coment;
	
	@ManyToOne
	private Administrador administrador_coment;
	private Usuario usuario_coment;
	private Projeto projeto_coment;
	private Candidato candidato_coment;
	
	// Constructor
	public Comentario(){
		this.usuario_coment = new Usuario();
		this.projeto_coment = new Projeto();
		this.candidato_coment = new Candidato();
		this.administrador_coment = new Administrador();
	}

	// Methods
}