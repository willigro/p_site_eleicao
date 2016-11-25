package dao.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import classesBasicas.Candidato;
import classesBasicas.Usuario;
import dao.DAOGenerico;
import dao.interfaces.ICandidatoDAO;
import javassist.bytecode.stackmap.BasicBlock.Catch;

public class CandidatoDAO extends DAOGenerico<Candidato> implements ICandidatoDAO {

	@Override
	public List<Candidato> consultarTodosCandidatos() throws Exception {
		List<Candidato> lista_candidatos = new ArrayList<>();
		try {
			lista_candidatos = getManager().createQuery("SELECT cand FROM Candidato cand").getResultList();
			if (lista_candidatos.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (

		Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lista_candidatos;
	}

	private void addRestrictionIfNotNull(Criteria criteria, String propertyName, int id) {
		/**
		 * Object value > int id
		 */
		if (id > 0) {
			criteria.add(Restrictions.eq(propertyName, id));
		}
	}

	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception {
		if (candidato.getNome_cand() != null)
			if (candidato.getNome_cand().trim().equals("")) {
				candidato.setNome_cand(null);
			}
		Session session = (Session) getManager().getDelegate();
		Example cidadeExample = Example.create(candidato).excludeZeroes();
		Criteria criteria = session.createCriteria(Candidato.class).add(cidadeExample);
		addRestrictionIfNotNull(criteria, "cidade_cand.id_cid", candidato.getCidade_cand().getId_cid());
		addRestrictionIfNotNull(criteria, "estado_cand.id_est", candidato.getEstado_cand().getId_est());
		addRestrictionIfNotNull(criteria, "partido_cand.id_part", candidato.getPartido_cand().getId_part());
		/*
		 * could not get a field value by reflection getter of Ex: estado_cand
		 * precisa ser estado_cand.id_cand, pois ele nao encontra o atributo que
		 * esta sendo relacionado
		 * http://stackoverflow.com/questions/8719877/hibernate-association-with
		 * -createcriteria-and-createalias
		 * https://www.google.com.br/search?q=createcriteria+associations&oq=
		 * createcriteria+asso&aqs=chrome.2.69i57j0l5.20967j0j4&sourceid=chrome&
		 * ie=UTF-8
		 * http://respostas.guj.com.br/4419-consulta-com-hibernate-com-erro-
		 * could-not-get-a-field-value-by-reflection
		 * http://stackoverflow.com/questions/11970089/hibernate-add-restriction
		 * -equals-only-if-the-parameter-is-not-null
		 */
		List<Candidato> lista = criteria.list();
		if (lista.isEmpty())
			throw new Exception("Não foram encontrados registros para esta pesquisa");
		else
			return lista;
	}

	@Override
	public void removerCandidato(Candidato candidato) throws Exception {
		EntityTransaction tx = null;
		try {
			tx = getManager().getTransaction();
			tx.begin();
			Query query = getManager().createQuery("delete Candidato where id_cand = :id");
			query.setParameter("id", candidato.getId_cand());
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Candidato alterarCandidato(Candidato candidato) throws Exception {
		return super.update(candidato);
	}

	@Override
	public void cadastrarCandidato(Candidato candidato) throws Exception {
		super.insert(candidato);
	}

	public boolean retornaNumero(Candidato candidato) throws Exception {
		Query query = super.getManager().createQuery(
				"SELECT u FROM Candidato u WHERE Numero_cand = :Numero AND id_cid = :Cidade", Candidato.class);
		query.setParameter("Numero", candidato.getNumero_cand());
		query.setParameter("Cidade", candidato.getCidade_cand().getId_cid());
		return query.getResultList().isEmpty();
	}
}
