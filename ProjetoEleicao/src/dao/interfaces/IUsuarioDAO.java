package dao.interfaces;

import classesBasicas.Usuario;

public interface IUsuarioDAO {
	public void cadastrarUsuario(Usuario usuario) throws Exception;
	public Usuario loginUsuario(Usuario usuario) throws Exception;
}
