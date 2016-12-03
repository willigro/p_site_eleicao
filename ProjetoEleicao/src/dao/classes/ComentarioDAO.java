package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public class ComentarioDAO extends DAOGenerico<Comentario> implements IComentarioDAO {

	@Override
	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		List<Comentario> lista_comentarios = new ArrayList<>();
		try {
			lista_comentarios = getManager().createQuery("SELECT comentario FROM Comentario comentario")
					.getResultList();
			if (lista_comentarios.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista_comentarios;
	}

	@Override
	public void denunciarComentario(Comentario comentario) throws Exception {
		Query query = getManager().createQuery("UPDATE Comentario as c set qtd_denuncia = :Qtd WHERE id_coment = :Id");
		// query.setParameter("Qtd", comentario.getQtd_denuncia());
		query.setParameter("Id", comentario.getId_coment());

		query.executeUpdate();
	}

	@Override
	public Comentario verificarComentario(Comentario comentario) throws Exception {
		Query query = getManager().createQuery("SELECT c FROM Comentario c WHERE id_coment =:Id", Comentario.class);
		query.setParameter("Id", comentario.getId_coment());
		Comentario c = (Comentario) query.getSingleResult();
		if (c == null) {
			throw new Exception("Nao ha registros armazenados");
		}

		return c;
	}

	private void addRestrictionIdProj(Criteria criteria, String propertyName, int id) {
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
		addRestrictionIdProj(criteria, "projeto_coment.id_proj", projeto.getId_proj());

		List<Comentario> lista = criteria.list();
		if (lista.isEmpty())
			throw new Exception("Nao foram encontrados registros para esta pesquisa");
		else
			return lista;
	}

	@Override
	public void removerComent(Comentario comentario) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = getManager().getTransaction();
			tx.begin();
			Query query = getManager().createQuery("delete Comentario where id_coment = :id");
			query.setParameter("id", comentario.getId_coment());
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	private void addRestrictionIdCand(Criteria criteria, String propertyName, int id) {
		if (id > 0) {
			criteria.add(Restrictions.eq(propertyName, id));
		}
	}
	
	@Override
	public List<Comentario> consultarComentarioFiltradosIdCand(Candidato candidato) throws Exception {
		Session session = (Session) getManager().getDelegate();
		Comentario comt = new Comentario();
		comt.getProjeto_coment().setId_proj(candidato.getId_cand());
		Example cidadeExample = Example.create(comt).excludeZeroes();
		Criteria criteria = session.createCriteria(Comentario.class).add(cidadeExample).add(Restrictions.isNull("projeto_coment.id_proj"));
		addRestrictionIdCand(criteria, "candidato_coment.id_cand", candidato.getId_cand());

		List<Comentario> lista = criteria.list();
		if (lista.isEmpty())
			throw new Exception("Nao foram encontrados registros para esta pesquisa");
		else
			return lista;
	}
}
