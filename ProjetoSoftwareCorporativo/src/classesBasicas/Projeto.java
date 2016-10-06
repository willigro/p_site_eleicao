package classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_projeto")
public class Projeto {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_proj;
	
	@Column(nullable=false,length=100)
	private String titulo_proj;
	
	@Column(nullable=false,length=500)
	private String descricao_proj;
	
	private Candidato canditado_proj;
	
	private List<Comentario> lista_Comentario_proj;
	
	private List<Avaliacao> lista_Avaliacao_proj;
	
	// Constructor
	public Projeto() {
		this.canditado_proj = new Candidato();
		this.lista_Avaliacao_proj = new ArrayList<Avaliacao>();
		this.lista_Comentario_proj = new ArrayList<Comentario>();
	}

	// Methods
}