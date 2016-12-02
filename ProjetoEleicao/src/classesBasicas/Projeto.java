package classesBasicas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_projeto")
public class Projeto implements Serializable{
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_proj;

	@Column(nullable = false, length = 100)
	private String titulo_proj;

	@Column(nullable = false, length = 500)
	private String descricao_proj;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cand")
	private Candidato canditado_proj;

	@OneToMany(mappedBy = "projeto_coment")
	private List<Comentario> lista_Comentario_proj;

	@OneToMany(mappedBy = "projeto_aval")
	private List<Avaliacao> lista_Avaliacao_proj;

	// Constructor
	public Projeto() {
		this.canditado_proj = new Candidato();
		this.lista_Avaliacao_proj = new ArrayList<Avaliacao>();
		this.lista_Comentario_proj = new ArrayList<Comentario>();
	}
	
	//Get and Set
	public int getId_proj() {
		return id_proj;
	}

	public void setId_proj(int id_proj) {
		this.id_proj = id_proj;
	}

	public String getTitulo_proj() {
		return titulo_proj;
	}

	public void setTitulo_proj(String titulo_proj) {
		this.titulo_proj = titulo_proj;
	}

	public String getDescricao_proj() {
		return descricao_proj;
	}

	public void setDescricao_proj(String descricao_proj) {
		this.descricao_proj = descricao_proj;
	}

	public Candidato getCanditado_proj() {
		return canditado_proj;
	}

	public void setCanditado_proj(Candidato canditado_proj) {
		this.canditado_proj = canditado_proj;
	}

	public List<Comentario> getLista_Comentario_proj() {
		return lista_Comentario_proj;
	}

	public void setLista_Comentario_proj(List<Comentario> lista_Comentario_proj) {
		this.lista_Comentario_proj = lista_Comentario_proj;
	}

	public List<Avaliacao> getLista_Avaliacao_proj() {
		return lista_Avaliacao_proj;
	}

	public void setLista_Avaliacao_proj(List<Avaliacao> lista_Avaliacao_proj) {
		this.lista_Avaliacao_proj = lista_Avaliacao_proj;
	}

	// Methods
}