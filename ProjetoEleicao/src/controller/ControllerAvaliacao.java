package controller;

import dao.interfaces.IAvaliacaoDAO;

import java.io.Serializable;

import classesBasicas.Avaliacao;
import dao.DAOFactory;
import controller.exceptions.IdAbimguoAvaliacaoException;

public class ControllerAvaliacao implements Serializable{

	private IAvaliacaoDAO iavaliacaoDAO;

	public ControllerAvaliacao() {
		this.iavaliacaoDAO = DAOFactory.getAvaliacaoDAO();
	}

	private void validarAvaliacao(Avaliacao avaliacao) throws Exception {		
		if (avaliacao.getUsuario_aval().getId_user() <= 0) {
			throw new Exception("ID do usuário inválido");
		} else if (Integer.toString(avaliacao.getNotaAvaliacao()).trim().isEmpty()) {
			throw new Exception("Informe uma nota");
		} else if (avaliacao.getNotaAvaliacao() > 5 || avaliacao.getNotaAvaliacao() < 0) {
			throw new Exception("Informe uma nota entre 0 e 5");
		} else if (avaliacao.getCandidato_aval().getId_cand() >= 0 && avaliacao.getProjeto_aval().getId_proj() >= 0) {
			throw new IdAbimguoAvaliacaoException();
		}
	}

	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception {
		if (avaliacao.getCandidato_aval().getId_cand() <= 0) {
			throw new Exception("ID do candidato inválido");
		} else
			this.validarAvaliacao(avaliacao);

		this.iavaliacaoDAO.insert(avaliacao);
	}

	public void inserirAvaliacaoProjeto(Avaliacao avaliacao) throws Exception {
		if (avaliacao.getProjeto_aval().getId_proj() <= 0) {
			throw new Exception("ID do projeto inválido");
		} else
			this.validarAvaliacao(avaliacao);

		this.iavaliacaoDAO.insert(avaliacao);
	}

}
