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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_cidade")
public class Cidade implements Serializable{
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_cid;
	
	@Column(nullable=false,length=100)
	private String nome_cid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_estado", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	private Estado estado_cid;
	
	@OneToMany(mappedBy="cidade_cand", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Candidato> lista_Candidato_cid;

	// Constructor
	public Cidade() {
		this.estado_cid = new Estado();
		this.lista_Candidato_cid = new ArrayList<Candidato>();
	}

	// Gets e Sets
	public String getNome_cid() {
		return nome_cid;
	}

	public void setNome_cid(String nome_cid) {
		this.nome_cid = nome_cid;
	}

	public int getId_cid() {
		return id_cid;
	}

	public Estado getEstado_cid() {
		return estado_cid;
	}

	public void setEstado_cid(Estado estado_cid) {
		this.estado_cid = estado_cid;
	}

	public List<Candidato> getLista_Candidato_cid() {
		return lista_Candidato_cid;
	}

	public void setLista_Candidato_cid(List<Candidato> lista_Candidato_cid) {
		this.lista_Candidato_cid = lista_Candidato_cid;
	}

	public void setId_cid(int id_cid) {
		this.id_cid = id_cid;
	}	

	// Methods
}
