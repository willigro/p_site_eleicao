package controller;

import java.util.List;

import classesBasicas.Estado;
import dao.DAOFactory;
import dao.interfaces.IEstadoDAO;

public class ControllerEstado {
	private IEstadoDAO iEstadoDAO;

	public ControllerEstado() {
		this.iEstadoDAO = DAOFactory.getEstadoDAO();
	}

	public List<Estado> consultarTodosEstado() throws Exception {
		return this.iEstadoDAO.consultarTodosEstados();
	}
}
