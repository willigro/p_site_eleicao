package controller;

import dao.DAOFactory;
import dao.classes.ExempleDAO;
import dao.interfaces.IExempleDAO;

public class ControllerExemple {
	private IExempleDAO iExempleDAO;

	public ControllerExemple() {
		iExempleDAO = DAOFactory.getExempleDAO();
	}

	public void insert(ExempleDAO exempleDAO) {
		exempleDAO.insert(exempleDAO);
	}
}
