package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import classesBasicas.ErroSite;
import facade.Facade;

@ManagedBean(name="errositeBean")
public class ErroSiteBean {

	private Facade facade;
	private ErroSite erroSite;
	private List<ErroSite> errosSite;
	private ErroSite selectedErroSite;
	private String search="";

	

	public ErroSiteBean(){
		this.erroSite = new ErroSite();
		this.errosSite = new ArrayList<>();
		this.facade = new Facade();
	}
	
	
	public List<ErroSite> getErros(){
	    try {
	    	if(search.isEmpty()){
	    		this.errosSite = this.facade.consultarErros();	
	    	}else{
	    		ErroSite erroSite = new ErroSite();
	    		erroSite.setDescricao(search);
	    		this.errosSite = this.facade.consultarErrosPorFiltro(erroSite);
	    	}
			return this.errosSite;
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return null;
	}
	
	
	

	public ErroSite getSelectedErroSite() {
		return selectedErroSite;
	}

	public void setSelectedErroSite(ErroSite selectedErroSite) {
		this.selectedErroSite = selectedErroSite;
	}
	
	public ErroSite getErroSite() {
		return erroSite;
	}
	public void setErroSite(ErroSite erroSite) {
		this.erroSite = erroSite;
	}
	public List<ErroSite> getErrosSite() {
		return errosSite;
	}
	public void setErrosSite(List<ErroSite> errosSite) {
		this.errosSite = errosSite;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
}
