package controller;

import dao.classes.AvaliacaoDAO;
import classesBasicas.Avaliacao;
import dao.DAOFactory;

public class ControllerAvaliacao {

	private AvaliacaoDAO avaliacaoDAO;

	public ControllerAvaliacao() {
		this.avaliacaoDAO = DAOFactory.getAvaliacaoDAO();
	}
	
	private void validarAvaliacao(Avaliacao avaliacao) throws Exception {
		if (avaliacao.getId_aval() <= 0) {
			throw new Exception("ID da avaliação inválida");
		} else if (avaliacao.getUsuario_aval().getId_user() <= 0) {
			throw new Exception("ID do usuário inválido");
		} else if (Integer.toString(avaliacao.getNotaAvaliacao()).trim().isEmpty()) {
			throw new Exception("Informe uma nota");
		} else if (avaliacao.getNotaAvaliacao() > 5 || avaliacao.getNotaAvaliacao() < 0) {
			throw new Exception("Informe uma nota entre 0 e 5");
		}
	}

	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception {
		if (avaliacao.getCandidato_aval().getId_cand() <= 0) {
			throw new Exception("ID do candidato inválido");
		} else
			this.validarAvaliacao(avaliacao);

		this.avaliacaoDAO.insert(avaliacao);
	}

	public void inserirAvaliacaoProjeto(Avaliacao avaliacao) throws Exception {
		if (avaliacao.getProjeto_aval().getId_proj() <= 0) {
			throw new Exception("ID do projeto inválido");
		} else
			this.validarAvaliacao(avaliacao);

		this.avaliacaoDAO.insert(avaliacao);
	}

}
