package dao.classes;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import antlr.collections.List;
import dao.DAOGenerico;
import dao.interfaces.IAdministradorDAO;
import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Partido;
import classesBasicas.Usuario;

public class AdministradorDAO extends DAOGenerico<Administrador> implements IAdministradorDAO{

	
private EntityManager em;
	
	public AdministradorDAO(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePSC");
		em = emf.createEntityManager();
	}
	
	@Override
	public Administrador loginAdministrador(String email, String senha) throws Exception {
			
			Query query = em.createQuery("SELECT a FROM administrador a WHERE email =:email AND senha=:senha");
			query.setParameter(email, email);
			query.setParameter(senha, senha);
			
			
			return (Administrador)query.getSingleResult();
	}

	@Override
	public boolean logoutAdministrador(Administrador administrador) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificarIdExistenteAdministrador(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean punirUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
	public List listCandidato(ArrayList<Candidato> candidatos) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	
}
