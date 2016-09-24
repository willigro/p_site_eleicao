package classesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	// Attributes
	private int id_user;
	private String nome_user;
	private String email_user;
	private List<Comentario> lista_Comentario_user;
	private List<Avaliacao> lista_Avaliacao_user;
	private boolean ativo_user;
	
	// Constructor
	public Usuario() {
		this.lista_Avaliacao_user = new ArrayList<Avaliacao>();
		this.lista_Comentario_user = new ArrayList<Comentario>();
	}
	
	// Methods
}