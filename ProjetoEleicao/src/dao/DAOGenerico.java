package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class DAOGenerico<Classe> {
	private EntityManager manager;
	private Class<Classe> classePersistente;

	public DAOGenerico() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		classePersistente = (Class<Classe>) parameterizedType.getActualTypeArguments()[0];
	}

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
		try {
			tx = getManager().getTransaction();
			tx.begin();
			getManager().persist(classe);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw new Exception();
		} catch (Exception e) {
			tx.rollback();
			throw new Exception();
		}
	}

	public final Classe update(Classe classe) throws Exception {
		EntityTransaction tx = null;
		try{
			tx = getManager().getTransaction();
			tx.begin();
			classe = getManager().merge(classe);
			tx.commit();	
		}catch(Exception e){
			tx.rollback();
			throw new Exception();
		}
		return classe;
	}

	public final void delete(Classe classe) throws Exception {
		EntityTransaction tx = getManager().getTransaction();
		tx.begin();
		classe = getManager().merge(classe);
		getManager().remove(classe);
		tx.commit();
	}

	public final Classe select(Serializable chave) throws Exception {
		Classe instance = null;
		instance = (Classe) getManager().getReference(getClassePersistente(), chave);
		return instance;
	}

	protected final Class<Classe> getClassePersistente() {
		return classePersistente;
	}

}
