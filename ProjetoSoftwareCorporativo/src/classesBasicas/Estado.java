package classesBasicas;

import java.util.ArrayList;
import java.util.List;

public class Estado {
	// Attributes
	private int id_est;
	private String nome_est;
	private String sigla_est;
	private List<Cidade> lista_Cidade_est;
	private List<Candidato> lista_Candidato_est;
	
	// Constructor
	public Estado() {
		this.lista_Candidato_est = new ArrayList<>();
		this.lista_Cidade_est = new ArrayList<>();
	}

	// Methods
}
