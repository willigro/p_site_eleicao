package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import classesBasicas.Comentario;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public class ComentarioDAO extends DAOGenerico<Comentario> implements IComentarioDAO {

	@Override
	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		List<Comentario> lista_comentarios = new ArrayList<>();
		try {
			lista_comentarios = getManager()
					.createQuery("SELECT comentario FROM Comentario comentario WHERE qtd_denuncia > 9").getResultList();
			if (lista_comentarios.isEmpty()) {
				throw new Exception("N�o h� registros armazenados");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista_comentarios;
	}

	@Override
	public void denunciarComentario(Comentario comentario) throws Exception {
		Query query = getManager().createQuery("UPDATE Comentario as c set qtd_denuncia = :Qtd WHERE id_coment = :Id");
		query.setParameter("Qtd", comentario.getQtd_denuncia());
		query.setParameter("Id", comentario.getId_coment());

		query.executeUpdate();
	}

	@Override
	public Comentario verificarComentario(Comentario comentario) throws Exception {
		Query query = getManager().createQuery("SELECT u FROM Usuario u WHERE id_user =:Id", Comentario.class);
		query.setParameter("Id", comentario.getId_coment());

		Comentario c = (Comentario) query.getSingleResult();
		if (c == null) {
			throw new Exception("Nao ha registros armazenados");
		}

		return c;
	}

	private void addRestrictionIdCand(Criteria criteria, String propertyName, int id) {
		if (id > 0) {
			criteria.add(Restrictions.eq(propertyName, id));
		}
	}

	@Override
	public List<Comentario> consultarComentarioFiltradosIdProjt(Projeto projeto) throws Exception {
		Session session = (Session) getManager().getDelegate();
		Comentario comt = new Comentario();
		comt.getProjeto_coment().setId_proj(projeto.getId_proj());
		Example cidadeExample = Example.create(comt).excludeZeroes();
		Criteria criteria = session.createCriteria(Comentario.class).add(cidadeExample);
		addRestrictionIdCand(criteria, "projeto_coment.id_proj", projeto.getId_proj());

		List<Comentario> lista = criteria.list();
		if (lista.isEmpty())
			throw new Exception("Nao foram encontrados registros para esta pesquisa");
		else
			return lista;
	}

	// public void comentarProjeto(Comentario comentario) throws Exception{
	// super.insert(comentario);
	// }

}
