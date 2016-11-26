package controller;

import java.util.List;
import classesBasicas.Cidade;
import dao.DAOFactory;
import dao.interfaces.ICidadeDAO;

public class ControllerCidade {

	private ICidadeDAO iCidadeDAO;

	public ControllerCidade() {
		this.iCidadeDAO = DAOFactory.getCidadeDAO();
	}

	public List<Cidade> consultarTodosEstado() throws Exception {
		return this.iCidadeDAO.consultarTodasCidades();
	}
	
	public List<Cidade> consultarCidadeFiltrada(Cidade cidade) throws Exception{
		return this.iCidadeDAO.consultarCidadeFiltrada(cidade);
	}

}
