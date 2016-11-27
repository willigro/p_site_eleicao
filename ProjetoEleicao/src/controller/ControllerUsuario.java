package controller;


import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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
		
		if(usuario == null){
			throw new Exception("Usuario nulo.");
		}
		if(usuario.getEmail_user().trim().isEmpty()){
			throw new Exception("Informe o email.");
		}
		if(usuario.getEmail_user().length() > 30){
			throw new Exception("O email deve conter no maximo 30 caracteres.");
		}
		if(!isValidEmailAddress(usuario.getEmail_user())){
			throw new Exception("E-mail invalido.");
		}
		if(usuario.getSenha().trim().isEmpty()){
			throw new Exception("Informe uma senha.");
		}
		if(usuario.getSenha().length() < 8){
			throw new Exception("A senha deve conter no manimo oito caracteres.");
		}

		return this.usuarioDAO.loginUsuario(usuario);

	}	
	
	public List<Usuario> consultarUsuarios() throws Exception{
		
		//validate user
		return usuarioDAO.consultarUsuarios();
	}
	
	public List<Usuario> consultarUsuarioPorFiltro(Usuario usuario) throws Exception{
		if(usuario == null){
			throw new Exception("O usuario informado e nulo.");
		}
		if(usuario.getNome_user().trim().isEmpty()){
			throw new Exception("O nome informado nao foi preenchido.");
		}
		if(usuario.getNome_user().length() > 50){
			throw new Exception("O nome nao pode conter mais de 50 caracteres.");
		}
		return usuarioDAO.consultarUsuarioPorFiltro(usuario);
	}
	
	public void banirUsuario(Usuario usuario) throws Exception {
		
		if(consultarStatusUsuarioBanido(usuario) == null){
			throw new Exception("O usuario por que o usuario informado nao corresponde ao ja existente na base de dados.");
		}
		if(usuario.getEmail_user().trim().isEmpty()){
			throw new Exception("O usuario por que o email nao foi preenchido");
		}
		if(consultarStatusUsuarioBanido(usuario).getEmail_user().length() > 30){
			throw new Exception("O usuario por que o email nao pode conter mais de 30 caracteres.");
		}
		if(!consultarStatusUsuarioBanido(usuario).getEmail_user().equals(usuario.getEmail_user())){
			throw new Exception("O email informado nao corresponde ao ja existente na base de dados.");	
		}
		if(usuario.getNome_user().trim().isEmpty()){
			throw new Exception("O nome informado nao foi preenchido.");
		}
		if(consultarStatusUsuarioBanido(usuario).getNome_user().length() > 50){
			throw new Exception("O nome nao pode conter mais de 50 caracteres.");
		}
		if(!consultarStatusUsuarioBanido(usuario).getNome_user().equals(usuario.getNome_user())){
			throw new Exception("O nome informado nao corresponde ao ja existente na base de dados.");
		}
		if(usuario.getSenha().trim().isEmpty()){
			throw new Exception("A senha informada nao foi preenchida.");
		}
		if(consultarStatusUsuarioBanido(usuario).getEmail_user().length() > 30){
			throw new Exception("A senha nao pode conter mais de 32 caracteres.");
		}
		if(!consultarStatusUsuarioBanido(usuario).getSenha().equals(usuario.getSenha())){
			throw new Exception("A senha informada nao corresponde com a existente na base de dados.");
		}
		
			usuarioDAO.banirUsuario(usuario);
	}
	
	
	public Usuario consultarStatusUsuarioBanido(Usuario usuario) throws Exception{
		if(usuario == null){
			throw new Exception("O usuario informado nao corresponde ao ja existente na base de dados.");
		}
		return (Usuario) this.usuarioDAO.consultarUsuarioBanido(usuario);
	}
	
	/*
	 * VALIDAR EMAIL
	 */
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}

}
