package controller;


import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import classesBasicas.Usuario;
import controller.exceptions.account.AccountDisabledException;
import controller.exceptions.email.DatabaseAliveEmailException;
import controller.exceptions.email.EmptyEmailException;
import controller.exceptions.email.InvalidEmailException;
import controller.exceptions.email.LimitCaracterEmailException;
import controller.exceptions.name.LimitCaracterNameException;
import controller.exceptions.name.NameEmptyException;
import controller.exceptions.password.LimitCaracterPasswordlException;
import controller.exceptions.password.PasswordEmptyException;
import controller.util.ValidateMail;
import dao.DAOFactory;
import dao.classes.UsuarioDAO;

public class ControllerUsuario {

	private UsuarioDAO usuarioDAO;

	public ControllerUsuario() {
		this.usuarioDAO = DAOFactory.getUsuarioDAO();
	}

	public void cadastrarUsuario(Usuario usuario) throws Exception {
		if (usuario.getNome_user().trim().isEmpty()) {
			throw new NameEmptyException();
		} else if (usuario.getNome_user().length() > Usuario.getLimitCaracterName()) {
			throw new LimitCaracterNameException(Usuario.getLimitCaracterName());
		}
		if (usuario.getEmail_user().trim().isEmpty()) {
			throw new EmptyEmailException();
		} else if (usuario.getEmail_user().length() > Usuario.getLimitCaracterEmail()) {
			throw new LimitCaracterEmailException(Usuario.getLimitCaracterEmail());
		}
		if (usuario.getSenha().trim().isEmpty()) {
			throw new PasswordEmptyException();
		} else if (usuario.getSenha().length() < Usuario.getSystemLimitCaracterPassword()) {
			throw new LimitCaracterPasswordlException(Usuario.getSystemLimitCaracterPassword());
		}
		if(usuarioDAO.retornaEmail(usuario) == false){
			throw new DatabaseAliveEmailException();
		}
		usuarioDAO.cadastrarUsuario(usuario);
	}
	
	public Usuario loginUsuario(Usuario usuario) throws Exception{
		
		if(usuario == null){
			throw new Exception("Usuario nulo.");
		}
		if(usuario.getEmail_user().trim().isEmpty()){
			throw new EmptyEmailException();
		}
		if(usuario.getEmail_user().length() > Usuario.getLimitCaracterEmail()){
			throw new LimitCaracterEmailException(Usuario.getLimitCaracterEmail());
		}
		if(!ValidateMail.isValidEmailAddress(usuario.getEmail_user())){
			throw new InvalidEmailException();
		}
		if(usuario.getSenha().trim().isEmpty()){
			throw new PasswordEmptyException();
		}
		if(usuario.getSenha().length() < Usuario.getSystemLimitCaracterPassword()){
			throw new LimitCaracterPasswordlException(Usuario.getSystemLimitCaracterPassword());
		}
		if(usuarioDAO.loginUsuario(usuario).isAtivo_user()){
			throw new AccountDisabledException();
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
			throw new NameEmptyException();
		}
		if(usuario.getNome_user().length() > Usuario.getLimitCaracterName()){
			throw new  LimitCaracterNameException(Usuario.getLimitCaracterName());
		}
		return usuarioDAO.consultarUsuarioPorFiltro(usuario);
	}
	
	public void banirUsuario(Usuario usuario) throws Exception {
		
		if(consultarStatusUsuarioBanido(usuario) == null){
			throw new Exception("O usuario por que o usuario informado nao corresponde ao ja existente na base de dados.");
		}
		if(usuario.getEmail_user().trim().isEmpty()){
			throw new EmptyEmailException();
		}
		if(consultarStatusUsuarioBanido(usuario).getEmail_user().length() > Usuario.getLimitCaracterEmail()){
			throw new LimitCaracterEmailException(Usuario.getLimitCaracterEmail());
		}
		if(!consultarStatusUsuarioBanido(usuario).getEmail_user().equals(usuario.getEmail_user())){
			throw new Exception("O email informado nao corresponde ao ja existente na base de dados.");	
		}
		if(usuario.getNome_user().trim().isEmpty()){
			throw new NameEmptyException();
		}
		if(consultarStatusUsuarioBanido(usuario).getNome_user().length() > Usuario.getLimitCaracterName()){
			throw new LimitCaracterNameException(Usuario.getLimitCaracterName());
		}
		if(!consultarStatusUsuarioBanido(usuario).getNome_user().equals(usuario.getNome_user())){
			throw new Exception("O nome informado nao corresponde ao ja existente na base de dados.");
		}
		if(usuario.getSenha().trim().isEmpty()){
			throw new PasswordEmptyException();
		}
		if(consultarStatusUsuarioBanido(usuario).getEmail_user().length() > Usuario.getLimitCaracterEmail()){
			throw new LimitCaracterEmailException(Usuario.getLimitCaracterEmail());
		}
		if(!consultarStatusUsuarioBanido(usuario).getSenha().equals(usuario.getSenha())){
			throw new Exception("A senha informada nao corresponde com a existente na base de dados.");
		}
		
			usuarioDAO.banirUsuario(usuario);
	}
	
	public boolean verificarUsuarioPorID(Usuario usuario){
		
		try {
			if(this.usuarioDAO.consultarUsuarioPorId(usuario) != null){
				return true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Usuario consultarStatusUsuarioBanido(Usuario usuario) throws Exception{
//		if(usuario == null){
//			throw new Exception("O usuario informado nao corresponde ao ja existente na base de dados.");
//		}
		return (Usuario) this.usuarioDAO.consultarUsuarioPorId(usuario);
	}
}
