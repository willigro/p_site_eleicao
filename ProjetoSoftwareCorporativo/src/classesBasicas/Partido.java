package classesBasicas;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "tb_partido")
public class Partido {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_part;

	@Column(nullable = false, length = 40)
	private String nome_part;

	@OneToMany(mappedBy = "partido_cand")
	private List<Candidato> lista_Candidato_part;

	@Column(nullable = false, length = 8)
	private String sigla_part;

	// Constructor
	public Partido() {
		this.lista_Candidato_part = new ArrayList<>();
	}

	// Gets e Sets
	public String getNome_part() {
		return nome_part;
	}

	public void setNome_part(String nome_part) {
		this.nome_part = nome_part;
	}

	public int getId_part() {
		return id_part;
	}

	// Methods
}
