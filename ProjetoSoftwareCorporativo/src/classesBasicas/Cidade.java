package classesBasicas;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade {
	// Attributes
	@Id
	private int id_cid;
	
	@Column(nullable=false,length=100)
	private String nome_cid;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_estado", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	private Estado estado_cid;
	
	private List<Candidato> lista_Candidato_cid;

	// Constructor
	public Cidade() {
		this.estado_cid = new Estado();
		this.lista_Candidato_cid = new ArrayList<Candidato>();
	}

	// Methods
}
