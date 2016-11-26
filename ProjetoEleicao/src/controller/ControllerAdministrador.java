package controller;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityTransaction;

import antlr.collections.List;
import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.AdministradorDAO;
import dao.classes.CandidatoDAO;
import dao.classes.UsuarioDAO;

public class ControllerAdministrador{
	
	private AdministradorDAO administradorDAO;


	public ControllerAdministrador(){
		this.administradorDAO = DAOFactory.getAdministradorDAO();

	}
	
	

	public Administrador loginAdministrador(Administrador administrador) throws Exception{
		if(administrador == null){
			throw new Exception("Usuario nulo.");
		}
		if(administrador.getEmail().trim().isEmpty()){
			throw new Exception("Informe o email.");
		}
		if(administrador.getEmail().length() > 30){
			throw new Exception("O email deve conter no maximo 30 caracteres.");
		}
		if(!isValidEmailAddress(administrador.getEmail())){
			throw new Exception("E-mail invalido.");
		}
		if(administrador.getSenha_admin().trim().isEmpty()){
			throw new Exception("Informe uma senha.");
		}
		if(administrador.getSenha_admin().length() < 8){
			throw new Exception("A senha deve conter no manimo oito caracteres.");
		}
		return this.administradorDAO.loginAdministrador(administrador);

	}

	public boolean logoutAdministrador(Administrador administrador) throws Exception{
		
		
			

		return false;
	}
	
	public void validateLoginAdministrador(Administrador administrador) throws Exception{
		if(administrador != null){
			if(!administrador.getEmail().trim().isEmpty()){
				throw new Exception("e-mail vazio");
			}
			if(administrador.getEmail().length() <= 100){
				throw new Exception("e-mail acima do limite de caracteres");
			}
			if(isValidEmailAddress(administrador.getEmail())){
				throw new Exception("e-mail inv�lido");
			}
			if(!administrador.getSenha_admin().trim().isEmpty()){
				throw new Exception("senha vazia");
			}
			if(administrador.getSenha_admin().length() <= 100){
				throw new Exception("");
			}
		}else{
			throw new Exception("objeto administrador null");
		}
		
	}
	
	//M�todo para validar e-mail
	public static boolean isValidEmailAddress(String email) throws Exception{
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
