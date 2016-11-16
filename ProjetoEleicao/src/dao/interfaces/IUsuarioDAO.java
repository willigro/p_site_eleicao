package dao.interfaces;


import java.util.List;

import classesBasicas.Usuario;

public interface IUsuarioDAO {
	public void cadastrarUsuario(Usuario usuario) throws Exception;
	public Usuario loginUsuario(Usuario usuario) throws Exception;
	public List<Usuario> consultarUsuarios() throws Exception;
}
