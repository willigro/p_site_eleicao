package controller;

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
			throw new Exception("O nome deve conter no m�ximo 50 caracteres.");
		}
		if (usuario.getEmail_user().trim().isEmpty()) {
			throw new Exception("Informe o email.");
		} else if (usuario.getEmail_user().length() > 30) {
			throw new Exception("O email deve conter no m�ximo 30 caracteres.");
		}
		if (usuario.getSenha().trim().isEmpty()) {
			throw new Exception("Informe uma senha.");
		} else if (usuario.getSenha().length() < 8) {
			throw new Exception("A senha deve conter no m�nimo oito caracteres.");
		}
		if(usuarioDAO.retornaEmail(usuario) == false){
			throw new Exception("O email informado j� consta cadastrado, fa�a login.");
		}
		usuarioDAO.cadastrarUsuario(usuario);
	}

}
