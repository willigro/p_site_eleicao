package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_avaliacao")
public class Avaliacao {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_aval;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_cand")
	private Candidato candidato_aval;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_proj")
	private Projeto projeto_aval;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	private Usuario usuario_aval;
	
	// Constructor
	public Avaliacao(){
		this.candidato_aval = new Candidato();
		this.projeto_aval = new Projeto();
		this.usuario_aval = new Usuario();		
	}
	
	// Methods
}