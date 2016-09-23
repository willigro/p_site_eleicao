package ClassesBasicas;

import java.util.List;

public class Cidade {
	String nome;
	int codigo;
	Estado estado;
	List candidatos;

	public Cidade() {
		this.estado = new Estado();
	}

}
