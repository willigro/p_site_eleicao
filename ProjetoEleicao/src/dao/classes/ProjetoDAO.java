package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IProjetoDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import classesBasicas.Projeto;

public class ProjetoDAO extends DAOGenerico<Projeto> implements IProjetoDAO {

	private void addRestrictionIdCand(Criteria criteria, String propertyName, int id) {		
		if (id > 0) {
			criteria.add(Restrictions.eq(propertyName, id));
		}
	}
	
	@Override
	public List<Projeto> consultarProjetosFiltradosIdCand(Projeto projeto) throws Exception {		
		Session session = (Session) getManager().getDelegate();
		Example cidadeExample = Example.create(projeto).excludeProperty("descricao_proj").excludeProperty("titulo_proj");
		Criteria criteria = session.createCriteria(Projeto.class).add(cidadeExample);
		addRestrictionIdCand(criteria, "canditado_proj.id_cand", projeto.getCanditado_proj().getId_cand());		
	
		List<Projeto> lista = criteria.list();
		if (lista.isEmpty())
			throw new Exception("Nao foram encontrados registros para esta pesquisa");
		else
			return lista;
	}

	@Override
	public List<Projeto> consultarTodosProjetos() throws Exception {
		List<Projeto> lista_projeto = new ArrayList<>();
		try {
			getManager().clear();
			lista_projeto = getManager().createQuery("SELECT proj FROM Projeto proj").getResultList();
			if (lista_projeto.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista_projeto;
	}
}
