package classesBasicas;

public class ErroSite {
	private int id_erroSite;
	private Usuario usuario;
	private String descricao;

	public ErroSite() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId_erroSite() {
		return id_erroSite;
	}
}
