package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.sql.ordering.antlr.Factory;

import dao.classes.ExempleDAO;

public class DAOFactory {
	private static EntityManager manager;
	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("hp_eleicao_br");
		if(manager == null || !manager.isOpen()){
			manager = factory.createEntityManager();
		}
	}
	
	// Fabrica de DAO
	
	public static ExempleDAO getExempleDAO(){
		ExempleDAO exempleDAO = new ExempleDAO();
		exempleDAO.setManager(manager);
		return exempleDAO;
	}
}
