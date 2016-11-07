package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class DAOGenerico<Classe> {
	private EntityManager manager;
	private Class<Classe> classePersistente;

	// Getter e Setter

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	// Metodos de CRUD
	/*
	 * throws ExceptionDAO_TransationNull setManager(null); if(getManager() ==
	 * null) throw new ExceptionDAO_TransationNull();
	 */

	public void insert(Classe classe) throws Exception {
		EntityTransaction tx = null;
		if (getManager() != null) {
			tx = getManager().getTransaction();
		} else {
			throw new Exception("manager null");
		}
		try {
			tx.begin();
			getManager().persist(classe);
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			tx.rollback();
			throw new Exception(e.getMessage());			
		} catch (Exception e) {
			tx.rollback();
			throw new Exception(e.getMessage());
		}
	}

	public final Classe update(Classe classe) throws Exception {
		try {
			EntityTransaction tx = getManager().getTransaction();
			tx.begin();
			classe = getManager().merge(classe);
			tx.commit();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return classe;
	}

	public final void delete(Classe classe) throws Exception {
		try {
			EntityTransaction tx = getManager().getTransaction();
			tx.begin();
			classe = getManager().merge(classe);
			getManager().remove(classe);
			tx.commit();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	public final Classe select(Serializable chave) throws Exception {
		Classe instance = null;
		try {
			instance = (Classe) getManager().getReference(getClassePersistente(), chave);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return instance;
	}

	protected final Class<Classe> getClassePersistente() {
		return classePersistente;
	}

}
