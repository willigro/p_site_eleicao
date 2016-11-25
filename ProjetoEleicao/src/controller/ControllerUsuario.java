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
	
	public List<Usuario> consultarUsuarioPorFiltro(Usuario usuario) throws Exception{
		return usuarioDAO.consultarUsuarioPorFiltro(usuario);
	}
	
	public void banirUsuario(Usuario usuario) throws Exception {
		System.out.println("entrou no controller");
		//verificar
		if(usuario.getId_user() <= 0){
			throw new Exception("Nao sera possivel banir o usuario.  Usuario inexistente.");
		}
		if(usuario.getEmail_user().trim().isEmpty()){
			throw new Exception("Nao sera possivel banir o usuario. Favor, preencha o e-mail.");
		}
		if(usuario.getNome_user().trim().isEmpty()){
			throw new Exception("Nao sera possivel banir o usuario. Favor, preencha o nome.");
		}
		if(usuario.getSenha().trim().isEmpty()){
			throw new Exception("Nao sera possivel banir o usuario. Favor, preencha a senha.");
		}
//		if(usuario.getLista_Avaliacao_user().isEmpty()){
//			throw new Exception("Nao sera possivel banir o usuario. Favor, preencha a lista de avaliacao.");
//		}
//		if(usuario.getLista_Comentario_user().isEmpty()){
//			throw new Exception("Nao sera possivel banir o usuario. Favor, preencha a lista de comentarios.");
//		}
			
		if(usuario.isAtivo_user() != consultarStatusUsuarioBanido(usuario)){
			usuarioDAO.banirUsuario(usuario);
		}
		
		
		
	}
	
	public boolean consultarStatusUsuarioBanido(Usuario usuario) throws Exception{
		//verificar
		return this.usuarioDAO.consultarStatusUsuarioBanido(usuario);
	}
	

}
