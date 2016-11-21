package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_aval;

	private int notaAvaliacao;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cand")
	private Candidato candidato_aval;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_proj")
	private Projeto projeto_aval;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private Usuario usuario_aval;

	// Constructor
	public Avaliacao() {
		this.candidato_aval = new Candidato();
		this.projeto_aval = new Projeto();
		this.usuario_aval = new Usuario();
	}

	// Get and Set
	public int getId_aval() {
		return id_aval;
	}

	public int getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(int notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}

	public void setId_aval(int id_aval) {
		this.id_aval = id_aval;
	}

	public Candidato getCandidato_aval() {
		return candidato_aval;
	}

	public void setCandidato_aval(Candidato candidato_aval) {
		this.candidato_aval = candidato_aval;
	}

	public Projeto getProjeto_aval() {
		return projeto_aval;
	}

	public void setProjeto_aval(Projeto projeto_aval) {
		this.projeto_aval = projeto_aval;
	}

	public Usuario getUsuario_aval() {
		return usuario_aval;
	}

	public void setUsuario_aval(Usuario usuario_aval) {
		this.usuario_aval = usuario_aval;
	}

	// Methods
}