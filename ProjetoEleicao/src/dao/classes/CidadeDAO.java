package dao.classes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import classesBasicas.Cidade;
import dao.DAOGenerico;
import dao.interfaces.ICidadeDAO;

public class CidadeDAO extends DAOGenerico<Cidade> implements ICidadeDAO {

	public List<Cidade> consultarTodasCidades() throws Exception {

		List<Cidade> lista_cidade = new ArrayList<>();
		try {
			lista_cidade = getManager().createQuery("SELECT cid FROM Cidade cid").getResultList();
			if (lista_cidade.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lista_cidade;
	}

	private void addRestrictionIfId(Criteria criteria, String propertyName, int id) {
		if (id > 0) {
			criteria.add(Restrictions.eq(propertyName, id));
		}
	}

	@Override
	public List<Cidade> consultarCidadeFiltrada(Cidade cidade) throws Exception {
		Session session = (Session) getManager().getDelegate();
		Example cidadeExample = Example.create(cidade).excludeZeroes();
		Criteria criteria = session.createCriteria(Cidade.class).add(cidadeExample);
		addRestrictionIfId(criteria, "estado_cid.id_est", cidade.getEstado_cid().getId_est());
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Cidade> lista = criteria.list();
		if (lista.isEmpty())
			throw new Exception("Não foram encontrados registros para esta pesquisa");
		else
			return lista;
	}
}
