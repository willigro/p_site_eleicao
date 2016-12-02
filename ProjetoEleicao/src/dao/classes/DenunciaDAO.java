package dao.classes;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Denuncia;
import dao.DAOGenerico;
import dao.interfaces.IDenunciaDAO;

public class DenunciaDAO extends DAOGenerico<Denuncia> implements IDenunciaDAO {

	@Override
	public void denunciarComentario(Denuncia denuncia) throws Exception {

		try {
			super.insert(denuncia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removerDenunciaComentario(Denuncia denuncia) throws Exception {

		try {

			super.delete(denuncia);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Denuncia> consultarDenunciaDoComentario() throws Exception {
		Session session = (Session) getManager().getDelegate();
		SQLQuery query = session.createSQLQuery(
				"SELECT den.id_comentario_denunciado, den.id_coment, den.id_user FROM tb_denuncia as den"
						+ " INNER JOIN tb_usuario ON den.id_user = tb_usuario.id_user"
						+ " INNER JOIN tb_comentario ON den.id_coment = tb_comentario.id_coment AND den.id_coment = (SELECT COUNT(id_coment) > 1 FROM tb_denuncia ORDER BY id_coment)"
						+ ";");
		/*
		 * SELECT id_comentario_denunciado, id_coment FROM tb_denuncia WHERE
		 * id_coment = (SELECT COUNT(id_coment) > 1 FROM tb_denuncia ORDER BY
		 * id_coment)
		 * 
		 */
		query.addEntity(Denuncia.class);
		List<Denuncia> result = query.list();
		if (result == null) {
			throw new Exception("Nao ha registros armazenados");
		}
		return result;
	}

	@Override
	public boolean consultarSeDenunciouMaisDeDuasVezes(Denuncia denuncia) throws Exception {

		 		Query query = getManager().createQuery("SELECT denuncia FROM Denuncia denuncia WHERE id_coment = :IdComentario AND id_user = :IdUsuario",Denuncia.class);
		 		query.setParameter("IdComentario",denuncia.getComentario().getId_coment());
		 		query.setParameter("IdUsuario", denuncia.getUsuario().getId_user());
		 		
		 		Denuncia result = (Denuncia) query.getSingleResult();
		 		if(result != null){
		 			return false;
		 		}
	 	return true;
	}
}
