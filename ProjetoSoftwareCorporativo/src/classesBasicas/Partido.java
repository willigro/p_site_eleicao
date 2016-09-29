package classesBasicas;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Partido {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_part;
	
	@Column(nullable=false,length=40)
	private String nome_part;
	
	
	private List<Candidato> lista_Candidato_part;
	
	@Column(nullable=false,length=8)
	private String sigla_part;
	
	// Constructor
	public Partido(){
		this.lista_Candidato_part = new ArrayList<>();
	}
	
	// Methods
}
