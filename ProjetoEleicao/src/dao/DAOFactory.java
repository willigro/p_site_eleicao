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
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public static ComentarioDAO getComentarioDAO() {
		ComentarioDAO comentarioDAO = new ComentarioDAO();
		comentarioDAO.setManager(manager);
		return comentarioDAO;
	}

	public static AvaliacaoDAO getAvaliacaoDAO() {
		AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
		avaliacaoDAO.setManager(manager);
		return avaliacaoDAO;
	}

	public static AdministradorDAO getAdministradorDAO() {
		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.setManager(manager);
		return administradorDAO;
	}

	public static ProjetoDAO getProjetoDAO() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.setManager(manager);
		return projetoDAO;

	}

	public static CidadeDAO getCidadeDAO() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.setManager(manager);
		return cidadeDAO;
	}

	public static EstadoDAO getEstadoDAO() {
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.setManager(manager);
		return estadoDAO;
	}

	public static PartidoDAO getPartidoDAO() {
		PartidoDAO partidoDAO = new PartidoDAO();
		partidoDAO.setManager(manager);
		return partidoDAO;
	}
	
	public static ErroSiteDAO getErroSiteDAO(){
		ErroSiteDAO erroSiteDAO = new ErroSiteDAO();
		erroSiteDAO.setManager(manager);
		return erroSiteDAO;
	}
	
	public static DenunciaDAO getDenunciaDAO(){
		DenunciaDAO denunciaDAO = new DenunciaDAO();
		denunciaDAO.setManager(manager);
		return denunciaDAO;
	}
}
