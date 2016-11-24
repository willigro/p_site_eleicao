package controller;

import java.util.List;

import classesBasicas.Partido;
import dao.DAOFactory;
import dao.interfaces.IPartidoDAO;

public class ControllerPartido {
	private IPartidoDAO iPartidoDAO;

	public ControllerPartido() {
		this.iPartidoDAO = DAOFactory.getPartidoDAO();
	}

	public List<Partido> consultarTodosPartidos() throws Exception{
		return this.iPartidoDAO.consultarTodosPartidos();
	}
}
