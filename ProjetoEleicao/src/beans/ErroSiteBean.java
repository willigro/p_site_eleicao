package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import classesBasicas.ErroSite;
import facade.Facade;

@ManagedBean
public class ErroSiteBean {

	private Facade facade;
	private ErroSite erroSite;
	private List<ErroSite> errosSite;
	private ErroSite selectedErroSite;

	
	
	public ErroSiteBean(){
		this.erroSite = new ErroSite();
		this.errosSite = new ArrayList<>();
		this.facade = new Facade();
	}
	
	
	public void getErros(){
		this.errosSite = new ArrayList<>();
	    try {
			this.errosSite = this.facade.consultarErros();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
}
