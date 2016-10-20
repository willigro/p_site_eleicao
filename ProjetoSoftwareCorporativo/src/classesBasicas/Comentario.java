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
@Table(name = "tb_comentario")
public class Comentario {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_coment;

	@Column(nullable = false, length = 500)
	private String texto_coment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_admin")
	private Administrador administrador_coment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private Usuario usuario_coment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_proj")
	private Projeto projeto_coment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cand")
	private Candidato candidato_coment;
	
	
	private int qtd_denuncia;


	// Constructor
	public Comentario() {
		this.usuario_coment = new Usuario();
		this.projeto_coment = new Projeto();
		this.candidato_coment = new Candidato();
		this.administrador_coment = new Administrador();
	}
	


	//Get and Set
	public int getId_coment() {
		return id_coment;
	}

	public void setId_coment(int id_coment) {
		this.id_coment = id_coment;
	}

	public String getTexto_coment() {
		return texto_coment;
	}

	public void setTexto_coment(String texto_coment) {
		this.texto_coment = texto_coment;
	}

	public Administrador getAdministrador_coment() {
		return administrador_coment;
	}

	public void setAdministrador_coment(Administrador administrador_coment) {
		this.administrador_coment = administrador_coment;
	}

	public Usuario getUsuario_coment() {
		return usuario_coment;
	}

	public void setUsuario_coment(Usuario usuario_coment) {
		this.usuario_coment = usuario_coment;
	}

	public Projeto getProjeto_coment() {
		return projeto_coment;
	}

	public void setProjeto_coment(Projeto projeto_coment) {
		this.projeto_coment = projeto_coment;
	}

	public Candidato getCandidato_coment() {
		return candidato_coment;
	}

	public void setCandidato_coment(Candidato candidato_coment) {
		this.candidato_coment = candidato_coment;
	}

	// Methods
	
	public int getQtd_denuncia() {
		return qtd_denuncia;
	}


	public void setQtd_denuncia(int qtd_denuncia) {
		this.qtd_denuncia = qtd_denuncia;
	}

	
}
