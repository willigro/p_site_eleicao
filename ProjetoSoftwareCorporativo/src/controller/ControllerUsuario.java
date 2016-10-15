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
			throw new Exception("Informe o nome");
		}
		if (usuario.getNome_user().length() > 50) {
			throw new Exception("O nome deve conter no máximo 50 caracteres");
		}
		if (usuario.getEmail_user().trim().isEmpty()) {
			throw new Exception("Informe o email");
		}
		if (usuario.getEmail_user().length() > 30) {
			throw new Exception("O email deve conter no máximo 30 caracteres");
		}
		if (usuario.getSenha().trim().isEmpty()) {
			throw new Exception("Informe uma senha");
		}
		if (usuario.getNome_user().length() < 8) {
			throw new Exception("A senha deve conter no mínimo oito caracteres");
		}
		usuarioDAO.insert(usuario);
	}

}
