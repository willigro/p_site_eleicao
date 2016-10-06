package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_administrador")
public class Administrador {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_admin;
	
	@Column(nullable=false,length=50)
	private String nome_admin;
	
	@Column(nullable=false,length=100)
	private String senha_admin;
	
	@OneToMany
	private List<Comentario> lista_Comentario_admin;
	
	@Column(nullable=false,length=100)
	private String email;
	
	
	//Relacionamentos
	
	// Constructor
	public Administrador(){
		this.lista_Comentario_admin = new ArrayList<>();
	}
	
	//Gets e Sets
	
	// Methods
}
