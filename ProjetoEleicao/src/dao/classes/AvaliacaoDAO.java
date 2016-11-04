package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IAvaliacaoDAO;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import classesBasicas.Avaliacao;

public class AvaliacaoDAO extends DAOGenerico<Avaliacao> implements IAvaliacaoDAO{

	@Override
	public void insertAvaliacaoProjeto(Avaliacao avaliacao) throws Exception {
	
		EntityTransaction tx = getManager().getTransaction();		
		try {
			tx.begin();
			getManager().persist(avaliacao);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw new Exception(e.getMessage());			
		} catch (Exception e) {
			tx.rollback();
			throw new Exception(e.getMessage());
		} 
	}
	
}
