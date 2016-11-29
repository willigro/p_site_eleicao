package dao.interfaces;

import java.util.List;

import classesBasicas.ErroSite;

public interface IErroSiteDAO {
	
	public List<ErroSite> consultarErros() throws Exception;
	public List<ErroSite> consultarErrosPorFiltro(ErroSite erroSite) throws Exception;
	

}
