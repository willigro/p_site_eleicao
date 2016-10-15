package controller;

import dao.classes.AvaliacaoDAO;
import classesBasicas.Avaliacao;
import dao.DAOFactory;

public class ControllerAvaliacao {

	private AvaliacaoDAO avaliacaoDAO;

	public ControllerAvaliacao() {
		this.avaliacaoDAO = DAOFactory.getAvaliacaoDAO();
	}

	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception {
		if (Integer.toString(avaliacao.getNotaAvaliacao()).trim().isEmpty()) {
			throw new Exception("Informe uma nota");
		}
		if (avaliacao.getNotaAvaliacao() > 5 || avaliacao.getNotaAvaliacao() < 0) {
			throw new Exception("Informe uma nota entre 0 e 5");
		}
		this.avaliacaoDAO.insert(avaliacao);
	}

}
