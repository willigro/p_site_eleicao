package controller;


import java.util.List;

import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.UsuarioDAO;

public class ControllerUsuario {

	private UsuarioDAO usuarioDAO;

	public ControllerUsuario() {
		this.usuarioDAO = DAOFactory.getUsuarioDAO();
	}

	public void cadastrarUsuario(Usuario usuario) throws Exception {
		if (usuario.getNome_user().trim().isEmpty()) {
			throw new Exception("Informe o nome.");
		} else if (usuario.getNome_user().length() > 50) {
			throw new Exception("O nome deve conter no maximo 50 caracteres.");
		}
		if (usuario.getEmail_user().trim().isEmpty()) {
			throw new Exception("Informe o email.");
		} else if (usuario.getEmail_user().length() > 30) {
			throw new Exception("O email deve conter no maximo 30 caracteres.");
		}
		if (usuario.getSenha().trim().isEmpty()) {
			throw new Exception("Informe uma senha.");
		} else if (usuario.getSenha().length() < 8) {
			throw new Exception("A senha deve conter no manimo oito caracteres.");
		}
		if(usuarioDAO.retornaEmail(usuario) == false){
			throw new Exception("O email informado ja consta cadastrado, faca login.");
		}
		usuarioDAO.cadastrarUsuario(usuario);
	}
	
	
	public Usuario loginUsuario(Usuario usuario) throws Exception{
//		validateLoginAdministrador(usuario);
		return this.usuarioDAO.loginUsuario(usuario);

	}

	public List<Usuario> consultarUsuarios() throws Exception{
		
		//validate user
		return usuarioDAO.consultarUsuarios();
	}
	
	

}
