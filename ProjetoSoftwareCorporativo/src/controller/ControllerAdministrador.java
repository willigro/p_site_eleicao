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

public class ControllerAdministrador{
/**
 * Quem Estiver modificando este classe LEMBRE-SE da arquitetura
 * Olhem o controllerExemple como guia
 * */
	public /*Administrador*/ void loginAdministrador(String email, String senha) throws Exception{
		if(!email.trim().isEmpty()){
			if(email.length() <= 100){
				if(isValidEmailAddress(email)){
					if(!senha.trim().isEmpty()){
						if(senha.length() <= 100){
							//return resposta do outro metodo
							//AdministradorDAO admDAO = new AdministradorDAO();
							//admDAO.loginAdministrador(email, senha);
						}else{
							throw new Exception("");
						}
					}else{
						throw new Exception("senha vazia");
					}	
				}else{
					throw new Exception("e-mail inválido");
				}
			}else{
				throw new Exception("e-mail acima do limite de caracteres");
			}
		}else{
			throw new Exception("e-mail vazio");
		}
	}

	public boolean logoutAdministrador(Administrador administrador) throws Exception{
		if(administrador != null){
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

		}else{
			throw new Exception("objeto administrador null");
		}
		return false;
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
