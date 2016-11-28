package controller;

import java.util.List;

import classesBasicas.ErroSite;
import dao.DAOFactory;
import dao.interfaces.IErroSiteDAO;

public class ControllerErroSite {

	private IErroSiteDAO iErroSiteDAO;
	
	
	public ControllerErroSite(){
		this.iErroSiteDAO = DAOFactory.getErroSiteDAO();
	}
	
	public List<ErroSite> consultarErros() throws Exception{
		
		return iErroSiteDAO.consultarErros();
	}
	
	
	public List<ErroSite> validateErroSiteSelect(List<ErroSite> erroSites) throws Exception{
		
		for(int i = 0; i<erroSites.size();i++){
			if(erroSites.get(i).getDescricao().isEmpty()){
				throw new Exception("Comentario com descricao vazia");
			}	
		}
		return erroSites;
		
	}
}
