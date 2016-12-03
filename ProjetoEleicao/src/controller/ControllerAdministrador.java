package controller;

import classesBasicas.Administrador;
import controller.exceptions.email.EmptyEmailException;
import controller.exceptions.email.InvalidEmailException;
import controller.exceptions.email.LimitCaracterEmailException;
import controller.exceptions.password.LimitCaracterPasswordlException;
import controller.exceptions.password.PasswordEmptyException;
import controller.util.ValidateMail;
import dao.DAOFactory;
import dao.classes.AdministradorDAO;

public class ControllerAdministrador{
	
	private AdministradorDAO administradorDAO;
	
	public ControllerAdministrador(){
		this.administradorDAO = DAOFactory.getAdministradorDAO();
	
	}
	

	public Administrador loginAdministrador(Administrador administrador) throws Exception{
		if(administrador == null){
			throw new Exception("Erro! Administrador Nulo");
		}
		if(administrador.getEmail().trim().isEmpty()){
			throw new EmptyEmailException();
		}
		if(administrador.getEmail().length() > Administrador.getLimitCaracterEmail()){
			throw new LimitCaracterEmailException(Administrador.getLimitCaracterEmail());
		}
		if(!ValidateMail.isValidEmailAddress(administrador.getEmail())){
			throw new InvalidEmailException();
		}
		if(administrador.getSenha_admin().trim().isEmpty()){
			throw new PasswordEmptyException();
		}
		if(administrador.getSenha_admin().length() < Administrador.getLimitCaracterPassword() || administrador.getSenha_admin().length() > Administrador.getLimitCaracterPassword()){
			throw new LimitCaracterPasswordlException(Administrador.getLimitCaracterPassword());
		}
		return this.administradorDAO.loginAdministrador(administrador);

	}
}
