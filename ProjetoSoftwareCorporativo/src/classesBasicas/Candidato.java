package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "tb_candidato")
public class Candidato {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_cand;

	@Column(nullable = false, length = 50)
	private String nome_cand;

	private Calendar data_Nasc_cand;
	
	@Column(nullable=false)
	private int numero_cand;

	@Column(nullable = false, length = 50)
	private String tipo_Cargo_cand;

	// Ignorar até decidir a estrategia
	private String foto_cand;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_part")
	private Partido partido_cand;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cid")
	private Cidade cidade_cand;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_est")
	private Estado estado_cand;

	@OneToMany(mappedBy = "candidato_aval")
	private List<Avaliacao> lista_Avaliacao_cand;

	@OneToMany(mappedBy = "candidato_coment")
	private List<Comentario> lista_Comentario_cand;

	@OneToMany(mappedBy = "canditado_proj")
	private List<Projeto> lista_Projeto_cand;

	// Constructor
	public Candidato() {
		this.partido_cand = new Partido();
		this.lista_Avaliacao_cand = new ArrayList<Avaliacao>();
		this.lista_Comentario_cand = new ArrayList<Comentario>();
		this.lista_Projeto_cand = new ArrayList<Projeto>();
		this.cidade_cand = new Cidade();
		this.estado_cand = new Estado();
		this.data_Nasc_cand = Calendar.getInstance();
	}

	// Gets and Sets
	public String getNome_cand() {
		return nome_cand;
	}

	public void setNome_cand(String nome_cand) {
		this.nome_cand = nome_cand;
	}

	public Partido getPartido_cand() {
		return partido_cand;
	}

	public void setPartido_cand(Partido partido_cand) {
		this.partido_cand = partido_cand;
	}

	public Calendar getData_Nasc_cand() {
		return data_Nasc_cand;
	}

	public void setData_Nasc_cand(Calendar data_Nasc_cand) {
		this.data_Nasc_cand = data_Nasc_cand;
	}

	public int getNumero_cand() {
		return numero_cand;
	}

	public void setNumero_cand(int numero_cand) {
		this.numero_cand = numero_cand;
	}

	public String getTipo_Elegivel_cand() {
		return tipo_Elegivel_cand;
	}

	public void setTipo_Elegivel_cand(String tipo_Elegivel_cand) {
		this.tipo_Elegivel_cand = tipo_Elegivel_cand;
	}

	public Cidade getCidade_cand() {
		return cidade_cand;
	}

	public void setCidade_cand(Cidade cidade_cand) {
		this.cidade_cand = cidade_cand;
	}

	public Estado getEstado_cand() {
		return estado_cand;
	}

	public void setEstado_cand(Estado estado_cand) {
		this.estado_cand = estado_cand;
	}

	public String getFoto_cand() {
		return foto_cand;
	}

	public void setFoto_cand(String foto_cand) {
		this.foto_cand = foto_cand;
	}

	public List<Avaliacao> getLista_Avaliacao_cand() {
		return lista_Avaliacao_cand;
	}

	public void setLista_Avaliacao_cand(List<Avaliacao> lista_Avaliacao_cand) {
		this.lista_Avaliacao_cand = lista_Avaliacao_cand;
	}

	public List<Comentario> getLista_Comentario_cand() {
		return lista_Comentario_cand;
	}

	public void setLista_Comentario_cand(List<Comentario> lista_Comentario_cand) {
		this.lista_Comentario_cand = lista_Comentario_cand;
	}

	public List<Projeto> getLista_Projeto_cand() {
		return lista_Projeto_cand;
	}

	public void setLista_Projeto_cand(List<Projeto> lista_Projeto_cand) {
		this.lista_Projeto_cand = lista_Projeto_cand;
	}

	public int getId_cand() {
		return id_cand;
	}

	// Methods
}
