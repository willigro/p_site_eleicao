package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.sql.ordering.antlr.Factory;
import dao.classes.*;

public abstract class DAOFactory {
	private static EntityManager manager;
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("hp_eleicao_br");
		if (manager == null || !manager.isOpen()) {
			manager = factory.createEntityManager();
		}
	}

	// Fabrica de DAO

	public static ExempleDAO getExempleDAO() {
		ExempleDAO exempleDAO = new ExempleDAO();
		exempleDAO.setManager(manager);
		return exempleDAO;
	}

	public static CandidatoDAO getCandidatoDAO() {
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.setManager(manager);
		return candidatoDAO;
	}

	public static UsuarioDAO getUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setManager(manager);
		return usuarioDAO;
	}
	
	public static ComentarioDAO getComentarioDAO(){
		ComentarioDAO comentarioDAO = new ComentarioDAO();
		comentarioDAO.setManager(manager);
		return comentarioDAO;
	}
	
	public static AvaliacaoDAO getAvaliacaoDAO(){
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		avaliacaoDAO.setManager(manager);
		return avaliacaoDAO;
	}
	
	public static ProjetoDAO getProjetoDAO(){
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.setManager(manager);
		return projetoDAO;
	}
}
