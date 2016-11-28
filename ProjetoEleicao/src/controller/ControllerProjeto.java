package controller;

import dao.DAOFactory;
import dao.interfaces.IProjetoDAO;

import java.util.List;

import org.omg.PortableServer.ThreadPolicyOperations;

import classesBasicas.Projeto;

public class ControllerProjeto {
	private IProjetoDAO iProjetoDAO;

	public ControllerProjeto() {
		iProjetoDAO = DAOFactory.getProjetoDAO();
	}

	public boolean validarController() throws Exception {
		if (iProjetoDAO != null)
			return true;
		else
			throw new Exception("iProjetoDAO null");
	}

	public List<Projeto> consultarTodosProjetos() throws Exception {
		return iProjetoDAO.consultarTodosProjetos();
	}

	public List<Projeto> consultarProjetosFiltradosIdCand(Projeto projeto) throws Exception {
		if (projeto.getCanditado_proj() != null) {
			if (projeto.getCanditado_proj().getId_cand() <= 0)
				throw new Exception("Informe o ID do candidato para completar a pesquisa");
		} else {
			throw new Exception("Informe um candidato para completar a pesquisa");
		}
		return iProjetoDAO.consultarProjetosFiltradosIdCand(projeto);
	}
}
