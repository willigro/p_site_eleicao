package controller;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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

public class ControllerAdministrador{
	
	private AdministradorDAO administradorDAO;

	public ControllerAdministrador(){
		this.administradorDAO = DAOFactory.getAdministradorDAO();
	}
	
	

	public Administrador loginAdministrador(Administrador administrador) throws Exception{
		validateLoginAdministrador(administrador);
		return this.administradorDAO.loginAdministrador(administrador);

	}

	public boolean logoutAdministrador(Administrador administrador) throws Exception{
		
			if(verificarIdExistenteAdministrador(administrador.getId_admin())){
				if(administrador.getId_admin() >0){
					if(!administrador.getEmail().isEmpty()){
						if(isValidEmailAddress(administrador.getEmail())){
							

						}else{
							throw new Exception("e-mail inválido");	
						}
					}else{
						throw new Exception("e-mail vazio");	
					}
				}else{
					throw new Exception("id menor ou igual a zero");
				}
			}else{
				throw new Exception("administrador inexistente na base de dados");
			}

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
				throw new Exception("e-mail inválido");
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
	
	//Método para validar e-mail
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

	public boolean verificarIdExistenteAdministrador(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertProjeto(Projeto projeto) {
		// TODO Auto-generated method stub
		return false;
	}


}
