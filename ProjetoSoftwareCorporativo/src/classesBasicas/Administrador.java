package classesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
	// Attributes
	private int id_admin;
	private String nome_admin;
	private String senha_admin;
	private List<Comentario> lista_Comentario_admin;
	private String email;
	
	// Constructor
	public Administrador(){
		this.lista_Comentario_admin = new ArrayList<>();
	}
	
	// Methods
}
