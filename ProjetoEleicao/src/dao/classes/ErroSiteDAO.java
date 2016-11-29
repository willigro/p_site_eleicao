package dao.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import classesBasicas.Comentario;
import classesBasicas.ErroSite;
import classesBasicas.Usuario;
import dao.DAOGenerico;
import dao.interfaces.IErroSiteDAO;

public class ErroSiteDAO extends DAOGenerico<Comentario> implements IErroSiteDAO{

	@Override
	public List<ErroSite> consultarErros() throws Exception {
		List<ErroSite> result = new ArrayList<>();
		try {
			System.out.println("entrou aqui");
			result = super.getManager().createQuery("SELECT errosite FROM ErroSite errosite").getResultList();
			if (result.isEmpty()) {
				throw new Exception("Nao ha registros armazenados");
			}
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
		return result;
	}
	
	
	
	
	@Override
	public List<ErroSite> consultarErrosPorFiltro(ErroSite erroSite) throws Exception {
		List<ErroSite> result = new ArrayList<>();
		try {
			Query query = super.getManager().createQuery("SELECT errosite FROM ErroSite errosite WHERE descricao like:Descricao",ErroSite.class);
			query.setParameter("Descricao","%"+erroSite.getDescricao()+"%");

			result = query.getResultList();
			
			if (result.isEmpty()) {
				throw new Exception("Nao ha registros armazenados");
			} else {
				return result;
			}
			
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
	}

}
