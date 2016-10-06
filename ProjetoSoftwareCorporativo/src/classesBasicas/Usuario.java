package classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_user;
	
	@Column(nullable=false,length=50)
	private String nome_user;
	
	@Column(nullable=false,length=100)
	private String email_user;
	
	private List<Comentario> lista_Comentario_user;
	
	private List<Avaliacao> lista_Avaliacao_user;
	
	@Column(nullable=false)
	private boolean ativo_user;
	
	@Column(nullable=false,length=10)
	private String senha;
	
	// Constructor
	public Usuario() {
		this.lista_Avaliacao_user = new ArrayList<Avaliacao>();
		this.lista_Comentario_user = new ArrayList<Comentario>();
	}
	
	// Methods
}