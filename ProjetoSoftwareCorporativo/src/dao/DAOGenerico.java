package dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public abstract class DAOGenerico <Classe>{
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
	/*throws ExceptionDAO_TransationNull
	setManager(null);
	if(getManager() == null)
		throw new ExceptionDAO_TransationNull();*/
	public void insert(Classe classe){

		EntityTransaction tx = getManager().getTransaction();
		try{
			tx.begin();
			getManager().persist(classe);
			tx.commit();
			System.out.println(classe.getClass().getSimpleName() + " salvo com sucesso");							
		}catch(PersistenceException e){
			System.out.println("rollback");
			e.printStackTrace();
			tx.rollback();	
		}


	}

	public Classe update(Classe classe) throws Exception{
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

	public final void delete(Classe classe) throws Exception{
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
			throw new Exception(e.getMessage());
		}
		return instance;
	}

	 protected final Class<Classe> getClassePersistente() {
		 return classePersistente;
		 }

}
