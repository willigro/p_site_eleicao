package classesBasicas;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Candidato{
	// Attributes
	private int id_cand;
	private String nome_cand;
	private Partido partido_cand;
	private Calendar data_Nasc_cand;
	private int numero_cand;
	private String tipo_Elegivel_cand;
	private Cidade cidade_cand;
	private Estado estado_cand;
	private String foto_cand;
	private List<Avaliacao> lista_Avaliacao_cand;
	private List<Comentario> lista_Comentario_cand;
	private List<Projeto> lista_Projeto_cand;
	
	// Constructor
	public Candidato(){
		this.partido_cand = new Partido();
		this.lista_Avaliacao_cand = new ArrayList<Avaliacao>();
		this.lista_Comentario_cand = new ArrayList<Comentario>();
		this.lista_Projeto_cand = new ArrayList<Projeto>();
		this.cidade_cand = new Cidade();
		this.estado_cand = new Estado();
		this.data_Nasc_cand = Calendar.getInstance();
	}
	
	// Methods
}
