package classesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Partido {
	// Attributes
	private String nome_part;
	private int id_part;
	private List<Candidato> lista_Candidato_part;
	private String sigla_part;
	
	// Constructor
	public Partido(){
		this.lista_Candidato_part = new ArrayList<>();
	}
	
	// Methods
}
