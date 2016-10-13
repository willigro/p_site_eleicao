package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_admin")
	private Administrador administrador_coment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	private Usuario usuario_coment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_proj")
	private Projeto projeto_coment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_cand")
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
