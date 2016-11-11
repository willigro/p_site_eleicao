package classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Column(nullable=false,length=30)
	private String email_user;
	
	@OneToMany(mappedBy = "usuario_coment")
	private List<Comentario> lista_Comentario_user;
	
	@OneToMany(mappedBy = "usuario_aval")
	private List<Avaliacao> lista_Avaliacao_user;
	
	@Column(nullable=false)
	private boolean ativo_user;
	
	@Column(nullable=false,length=32)
	private String senha;
	
	// Constructor
	public Usuario() {
		this.lista_Avaliacao_user = new ArrayList<Avaliacao>();
		this.lista_Comentario_user = new ArrayList<Comentario>();
	}
	
	//Get and Set
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getNome_user() {
		return nome_user;
	}

	public void setNome_user(String nome_user) {
		this.nome_user = nome_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public List<Comentario> getLista_Comentario_user() {
		return lista_Comentario_user;
	}

	public void setLista_Comentario_user(List<Comentario> lista_Comentario_user) {
		this.lista_Comentario_user = lista_Comentario_user;
	}

	public List<Avaliacao> getLista_Avaliacao_user() {
		return lista_Avaliacao_user;
	}

	public void setLista_Avaliacao_user(List<Avaliacao> lista_Avaliacao_user) {
		this.lista_Avaliacao_user = lista_Avaliacao_user;
	}

	public boolean isAtivo_user() {
		return ativo_user;
	}

	public void setAtivo_user(boolean ativo_user) {
		this.ativo_user = ativo_user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// Methods
	
}