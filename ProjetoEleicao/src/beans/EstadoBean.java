package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import classesBasicas.Estado;
import facade.Facade;

@ManagedBean
public class EstadoBean {
	private Estado estado;
	private Facade fachada;
	private List<Estado> lista_estado;

	public EstadoBean() {
		estado = new Estado();
		fachada = new Facade();
		lista_estado = new ArrayList<Estado>();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getLista_estado() {
		try {
			return this.lista_estado = fachada.consultarTodosEstado();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setLista_estado(List<Estado> lista_estado) {
		this.lista_estado = lista_estado;
	}
}
