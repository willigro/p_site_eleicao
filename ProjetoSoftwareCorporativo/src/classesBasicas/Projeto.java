package classesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
	// Attributes
	private int id_proj;
	private String titulo_proj;
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