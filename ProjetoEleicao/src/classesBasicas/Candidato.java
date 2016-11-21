package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

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

	@ManyToOne
	@JoinColumn(name = "id_part")
	private Partido partido_cand;

	@ManyToOne
	@JoinColumn(name = "id_cid")
	private Cidade cidade_cand;

	@ManyToOne
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
		//this.data_Nasc_cand = Calendar.getInstance();
	}

	// Gets and Sets
	public void setId_cand(int id_cand) {
		this.id_cand = id_cand;
	}
	
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

	public String getTipo_Cargo_cand() {
		return tipo_Cargo_cand;
	}

	public void setTipo_Cargo_cand(String tipo_Cargo_cand) {
		this.tipo_Cargo_cand = tipo_Cargo_cand;
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

	@Override
	public String toString() {
		return "Candidato [id_cand=" + id_cand + ", nome_cand=" + nome_cand + ", data_Nasc_cand=" + data_Nasc_cand
				+ ", numero_cand=" + numero_cand + ", tipo_Cargo_cand=" + tipo_Cargo_cand + ", foto_cand=" + foto_cand
				+ ", partido_cand=" + partido_cand + ", cidade_cand=" + cidade_cand + ", estado_cand=" + estado_cand
				+ ", lista_Avaliacao_cand=" + lista_Avaliacao_cand + ", lista_Comentario_cand=" + lista_Comentario_cand
				+ ", lista_Projeto_cand=" + lista_Projeto_cand + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade_cand == null) ? 0 : cidade_cand.hashCode());
		result = prime * result + ((data_Nasc_cand == null) ? 0 : data_Nasc_cand.hashCode());
		result = prime * result + ((estado_cand == null) ? 0 : estado_cand.hashCode());
		result = prime * result + ((foto_cand == null) ? 0 : foto_cand.hashCode());
		result = prime * result + id_cand;
		result = prime * result + ((lista_Avaliacao_cand == null) ? 0 : lista_Avaliacao_cand.hashCode());
		result = prime * result + ((lista_Comentario_cand == null) ? 0 : lista_Comentario_cand.hashCode());
		result = prime * result + ((lista_Projeto_cand == null) ? 0 : lista_Projeto_cand.hashCode());
		result = prime * result + ((nome_cand == null) ? 0 : nome_cand.hashCode());
		result = prime * result + numero_cand;
		result = prime * result + ((partido_cand == null) ? 0 : partido_cand.hashCode());
		result = prime * result + ((tipo_Cargo_cand == null) ? 0 : tipo_Cargo_cand.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		if (cidade_cand == null) {
			if (other.cidade_cand != null)
				return false;
		} else if (!cidade_cand.equals(other.cidade_cand))
			return false;
		if (data_Nasc_cand == null) {
			if (other.data_Nasc_cand != null)
				return false;
		} else if (!data_Nasc_cand.equals(other.data_Nasc_cand))
			return false;
		if (estado_cand == null) {
			if (other.estado_cand != null)
				return false;
		} else if (!estado_cand.equals(other.estado_cand))
			return false;
		if (foto_cand == null) {
			if (other.foto_cand != null)
				return false;
		} else if (!foto_cand.equals(other.foto_cand))
			return false;
		if (id_cand != other.id_cand)
			return false;
		if (lista_Avaliacao_cand == null) {
			if (other.lista_Avaliacao_cand != null)
				return false;
		} else if (!lista_Avaliacao_cand.equals(other.lista_Avaliacao_cand))
			return false;
		if (lista_Comentario_cand == null) {
			if (other.lista_Comentario_cand != null)
				return false;
		} else if (!lista_Comentario_cand.equals(other.lista_Comentario_cand))
			return false;
		if (lista_Projeto_cand == null) {
			if (other.lista_Projeto_cand != null)
				return false;
		} else if (!lista_Projeto_cand.equals(other.lista_Projeto_cand))
			return false;
		if (nome_cand == null) {
			if (other.nome_cand != null)
				return false;
		} else if (!nome_cand.equals(other.nome_cand))
			return false;
		if (numero_cand != other.numero_cand)
			return false;
		if (partido_cand == null) {
			if (other.partido_cand != null)
				return false;
		} else if (!partido_cand.equals(other.partido_cand))
			return false;
		if (tipo_Cargo_cand == null) {
			if (other.tipo_Cargo_cand != null)
				return false;
		} else if (!tipo_Cargo_cand.equals(other.tipo_Cargo_cand))
			return false;
		return true;
	}

	// Methods
	
}
