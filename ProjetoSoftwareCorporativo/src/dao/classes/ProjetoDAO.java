package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IProjetoDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import classesBasicas.Projeto;

public class ProjetoDAO extends DAOGenerico<Projeto> implements IProjetoDAO {

	@Override
	public List<Projeto> consultarProjetosFiltrados(Projeto projeto) throws Exception {		
		String montagemQuery = "SELECT proj FROM Projeto proj WHERE id_cand = id_cand";
		Query query = null;
		try{
			if(projeto.getTitulo_proj() != null || !projeto.getTitulo_proj().trim().equals("")){
				montagemQuery += " AND proj.titulo_proj = :titulo_proj";
			}
			if(projeto.getId_proj() > 0){
				montagemQuery += " AND proj.id_proj = :id_proj";
			}
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return query.getResultList();
	}

	@Override
	public List<Projeto> consultarTodosProjetos() throws Exception {
		List<Projeto> lista_projeto = new ArrayList<>();
		try {
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
