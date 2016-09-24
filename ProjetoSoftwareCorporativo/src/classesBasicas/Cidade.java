package classesBasicas;


import java.util.ArrayList;
import java.util.List;

public class Cidade {
	// Attributes
	private int id_cid;
	private String nome_cid;	
	private Estado estado_cid;
	private List<Candidato> lista_Candidato_cid;

	// Constructor
	public Cidade() {
		this.estado_cid = new Estado();
		this.lista_Candidato_cid = new ArrayList<Candidato>();
	}

	// Methods
}
