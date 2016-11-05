package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_estado")
public class Estado {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_est;

	@Column(nullable = false, length = 100)
	private String nome_est;

	@Column(nullable = false, length = 2)
	private String sigla_est;

	@OneToMany(mappedBy = "estado_cid", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Cidade> lista_Cidade_est;

	@OneToMany(mappedBy = "estado_cand", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Candidato> lista_Candidato_est;

	// Constructor
	public Estado() {
		this.lista_Candidato_est = new ArrayList<>();
		this.lista_Cidade_est = new ArrayList<>();
	}

	// Gets e Sets
	public String getNome_est() {
		return nome_est;
	}

	public void setNome_est(String nome_est) {
		this.nome_est = nome_est;
	}

	public int getId_est() {
		return id_est;
	}

	public String getSigla_est() {
		return sigla_est;
	}

	public void setSigla_est(String sigla_est) {
		this.sigla_est = sigla_est;
	}

	public List<Cidade> getLista_Cidade_est() {
		return lista_Cidade_est;
	}

	public void setLista_Cidade_est(List<Cidade> lista_Cidade_est) {
		this.lista_Cidade_est = lista_Cidade_est;
	}

	public List<Candidato> getLista_Candidato_est() {
		return lista_Candidato_est;
	}

	public void setLista_Candidato_est(List<Candidato> lista_Candidato_est) {
		this.lista_Candidato_est = lista_Candidato_est;
	}

	public void setId_est(int id_est) {
		this.id_est = id_est;
	}

	// Methods
}
