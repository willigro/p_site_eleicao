package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.sql.ordering.antlr.Factory;
import dao.classes.CandidatoDAO;
import dao.classes.ExempleDAO;
import dao.classes.UsuarioDAO;

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
}
