package classesBasicas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_denuncia")
public class Denuncia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_comentario_denunciado;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private Usuario usuario;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_coment")
	private Comentario comentario;
	
	
	public Denuncia(){
		this.usuario = new Usuario();
		this.comentario = new Comentario();
	}
	
	
	

	public int getId_comentario_denunciado() {
		return id_comentario_denunciado;
	}
	public void setId_comentario_denunciado(int id_comentario_denunciado) {
		this.id_comentario_denunciado = id_comentario_denunciado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Comentario getComentario() {
		return comentario;
	}
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}


}
