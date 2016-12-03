package classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
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
	
	private static final int DB_LIMIT_CHARS_NOME_USER = 50;
	private static final int DB_LIMIT_CHARS_EMAIL_USER = 30;
	private static final int SYS_LIMIT_CARACTER_PASSWORD = 8; // Tem que ser 8 caracter por causa da criptografia MD5
	private static final int DB_LIMIT_CARACTER_EMAIL = 30;
	private static final int DB_LIMIT_PASSWORD_EMAIL = 32;
	
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_user;
	
	@Column(nullable=false,length=DB_LIMIT_CHARS_NOME_USER)
	private String nome_user;
	
	@Column(nullable=false,length=DB_LIMIT_CHARS_EMAIL_USER)
	private String email_user;
	
	@OneToMany(mappedBy = "usuario_coment")
	private List<Comentario> lista_Comentario_user;
	
	@OneToMany(mappedBy = "usuario_aval")
	private List<Avaliacao> lista_Avaliacao_user;
	
	@Column(nullable=false)
	private boolean ativo_user;
	
	@Column(nullable=false,length=DB_LIMIT_PASSWORD_EMAIL)
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	private List<Denuncia> denuncias;
	
	
	

	// Constructor
	public Usuario() {
		this.denuncias = new ArrayList<Denuncia>();
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
	

	public List<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}
	
	public static int getSystemLimitCaracterPassword() {
		return SYS_LIMIT_CARACTER_PASSWORD;
	}

	public static int getLimitCaracterEmail() {
		return DB_LIMIT_CARACTER_EMAIL;
	}
	
	public static int getLimitCaracterName() {
		return DB_LIMIT_CHARS_NOME_USER;
	}

}	
