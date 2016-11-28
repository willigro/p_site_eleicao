package dao.classes;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Comentario;
import classesBasicas.ErroSite;
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

}
