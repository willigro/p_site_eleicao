package controller;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import antlr.collections.List;
import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Partido;
import classesBasicas.Usuario;
import dao.classes.AdministradorDAO;
import dao.interfaces.IAdministradorDAO;

public class ControllerAdministrador implements IAdministradorDAO{

	@Override
	public Administrador loginAdministrador(String email, String senha) throws Exception{
		if(!email.trim().isEmpty()){
			if(email.length() <= 100){
				if(isValidEmailAddress(email)){
					if(!senha.trim().isEmpty()){
						if(senha.length() <= 100){
							//return resposta do outro metodo
							AdministradorDAO admDAO = new AdministradorDAO();
							return admDAO.loginAdministrador(email, senha);
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

	@Override
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

	@Override
	public boolean deleteUsuario(int id) throws Exception{
		if(id > 0){

		}
		return false;
	}

	@Override
	public boolean punirUsuario(Usuario usuario) throws Exception{
		return false;
	}

	@Override
	public Usuario selectUsuario(int id) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listTodosUsuarios(ArrayList<Usuario> usuarios) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listComentariosUsuario(ArrayList<Comentario> comentarios) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTodosComentarios(ArrayList<Comentario> comentarios) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComentario(Comentario comentario) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Candidato candidato) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Candidato candidato) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Candidato update(Candidato candidato) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listCandidato(ArrayList<Candidato> candidatos) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertPartido(Partido partido) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePartido(Partido partido) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List listPartidos(ArrayList<Partido> partidos) throws Exception{
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public boolean verificarIdExistenteAdministrador(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateComentario(Comentario comentario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
