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

	// Methods
}
