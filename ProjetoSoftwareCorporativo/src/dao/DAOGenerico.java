package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public abstract class DAOGenerico <Classe>{
	private EntityManager manager;

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
	
}
