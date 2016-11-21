package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_administrador")
public class Administrador {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_admin;

	@Column(nullable = false, length = 50)
	private String nome_admin;

	@Column(nullable = false, length = 100)
	private String senha_admin;

	@OneToMany(mappedBy = "administrador_coment")
	private List<Comentario> lista_Comentario_admin;

	@Column(nullable = false, length = 100)
	private String email;

	// Relacionamentos

	// Constructor
	public Administrador() {
		this.lista_Comentario_admin = new ArrayList<>();
	}

	// Gets e Sets

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getNome_admin() {
		return nome_admin;
	}

	public void setNome_admin(String nome_admin) {
		this.nome_admin = nome_admin;
	}

	public String getSenha_admin() {
		return senha_admin;
	}

	public void setSenha_admin(String senha_admin) {
		this.senha_admin = senha_admin;
	}

	public List<Comentario> getLista_Comentario_admin() {
		return lista_Comentario_admin;
	}

	public void setLista_Comentario_admin(List<Comentario> lista_Comentario_admin) {
		this.lista_Comentario_admin = lista_Comentario_admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Methods
}
