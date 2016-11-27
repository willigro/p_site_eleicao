package classesBasicas;

import java.io.Serializable;
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
public class Partido implements Serializable{
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_part;

	@Column(nullable = false, length = 100)
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

	public List<Candidato> getLista_Candidato_part() {
		return lista_Candidato_part;
	}

	public void setLista_Candidato_part(List<Candidato> lista_Candidato_part) {
		this.lista_Candidato_part = lista_Candidato_part;
	}

	public String getSigla_part() {
		return sigla_part;
	}

	public void setSigla_part(String sigla_part) {
		this.sigla_part = sigla_part;
	}

	public void setId_part(int id_part) {
		this.id_part = id_part;
	}

	// Methods
}
