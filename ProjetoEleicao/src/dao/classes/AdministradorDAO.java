package dao.classes;

import java.security.MessageDigest;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import dao.DAOGenerico;
import dao.interfaces.IAdministradorDAO;
import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public class AdministradorDAO extends DAOGenerico<Administrador> implements IAdministradorDAO{

	private String criptografarSenha(String senha) throws Exception {
		StringBuilder senhaCriptografada = new StringBuilder();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] vetorBytes = md.digest(senha.getBytes("UTF8"));
		for (byte b : vetorBytes) {
			senhaCriptografada.append(String.format("%02X", 0xFF & b));
		}
		return senhaCriptografada.toString();
	}

	
	@Override
	public Administrador loginAdministrador(Administrador administrador) throws Exception {
			
																		
			Query query = super.getManager().createQuery("SELECT a FROM Administrador a WHERE email =:Email AND senha_admin=:Senha_admin", Administrador.class);
			query.setParameter("Email", administrador.getEmail());
			query.setParameter("Senha_admin", criptografarSenha(administrador.getSenha_admin()));
		
			return (Administrador) query.getSingleResult();
	}

	@Override
	public boolean logoutAdministrador(Administrador administrador) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificarIdExistenteAdministrador(int id) throws Exception {
		Query query = super.getManager().createQuery("SELECT a FROM tb_administrador a WHERE id_admin =:id");
		query.setParameter("id", id);
		
		if((int)query.getSingleResult() == 1){
			return true; 	
		}
		return false;
	}
	
	
	
	public void cadastrarAdministrador(Administrador administrador) throws Exception {
		administrador.setSenha_admin(criptografarSenha(administrador.getSenha_admin()));
		super.insert(administrador);
	}
	

	@Override
	public boolean deleteUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean punirUsuario(Administrador administrador) throws Exception {
		
	
		return true; 

	}
	
	public boolean verificarPunicaoUsuario(Usuario usuario){
		Query query = super.getManager().createQuery("SELECT a FROM usuario a WHERE id_user =:id");
		query.setParameter("id", usuario.getId_user());

		Usuario userQuery = (Usuario)query;
		if(userQuery.isAtivo_user()){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public Comentario verificarComentarioPorID(Comentario comentario){
		Query query = super.getManager().createQuery("SELECT c FROM comentario c WHERE id_coment =:id");
		query.setParameter("id", comentario.getId_coment());
		
		return (Comentario)query;
	}
	

	@Override
	public Usuario selectUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listTodosUsuarios(ArrayList<Usuario> usuarios) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listComentariosUsuario(ArrayList<Comentario> comentarios) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTodosComentarios(ArrayList<Comentario> comentarios) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComentario(Comentario comentario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Candidato candidato) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Candidato candidato) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Candidato update(Candidato candidato) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Candidato> listCandidato() throws Exception {
		List<Candidato> list_Candidatos = new ArrayList<Candidato>();
		return list_Candidatos;
	}

	@Override
	public boolean insertPartido(Partido partido) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePartido(Partido partido) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List listPartidos(ArrayList<Partido> partidos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateComentario(Comentario comentario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	//Projetos
	@Override
	public boolean insertProjeto(Projeto projeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProjeto(Projeto projeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProjeto(Projeto projeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List listProjetos() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
