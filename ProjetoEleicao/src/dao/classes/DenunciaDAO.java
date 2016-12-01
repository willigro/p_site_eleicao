package dao.classes;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Denuncia;
import dao.DAOGenerico;
import dao.interfaces.IDenunciaDAO;

public class DenunciaDAO extends DAOGenerico<Denuncia> implements IDenunciaDAO{

	@Override
	public void denunciarComentario(Denuncia denuncia) throws Exception{
		
		try {
			super.insert(denuncia);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void removerDenunciaComentario(Denuncia denuncia) throws Exception{
		
		try {
			
			super.delete(denuncia);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Denuncia consultarDenunciaDoComentario(Denuncia denuncia) throws Exception {
		

		Query query = getManager().createQuery("SELECT denuncia FROM Denuncia denuncia WHERE id_coment = :IdComentario AND id_user = :IdUsuario",Denuncia.class);
		query.setParameter("IdComentario",denuncia.getComentario().getId_coment());
		query.setParameter("IdUsuario", denuncia.getUsuario().getId_user());
		
		Denuncia result = (Denuncia) query.getSingleResult();
		if(result == null){
			throw new Exception("Nao ha registros armazenados");
		}
	
		return result;
	}
	
	

}
