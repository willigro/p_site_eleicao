package controller;

import java.util.List;

import classesBasicas.Candidato;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;
import dao.classes.ExempleDAO;
import dao.interfaces.ICandidatoDAO;

public class ControllerCandidato implements ICandidatoDAO {

	private CandidatoDAO candidatoDAO;

	public void ControllerCanditato() {
		this.candidatoDAO = DAOFactory.getCandidatoDAO();
	}

	@Override
	public void validarCandidato(Candidato candidato) throws Exception {

		// Falta: DataNascimeto, FotoCandidato.

		if (candidato.getNome_cand().trim().equals("")) {
			throw new Exception("O campo Nome está vazio");
		} else if (candidato.getNome_cand().length() > 50) {
			throw new Exception("O nome do candidato não pode conter mais de 50 caracteres");
		}

		if (candidato.getNumero_cand() > 99999) {
			throw new Exception("O campo Numero não deve ter mais que 5 dígitos");
		} else if (candidato.getNumero_cand() < 10000) {
			throw new Exception("O campo Numero não deve ter menos que 5 dígitos");
		}

		if (candidato.getTipo_Cargo_cand().trim().equals("")) {
			throw new Exception("O campo Cargo Elegível está vazio");
		} else if (candidato.getTipo_Cargo_cand().length() > 50) {
			throw new Exception("O Campo Cargo Elegível não pode conter mais de 50 caracteres");
		}

		if (candidato.getEstado_cand().getNome_est().trim().equals("")) {
			throw new Exception("O campo Estado está vazio");
		} else if (candidato.getEstado_cand().getNome_est().length() > 100) {
			throw new Exception("O campo Estado não pode conter mais de 100 caracteres");
		}

		if (candidato.getCidade_cand().getNome_cid().trim().equals("")) {
			throw new Exception("O campo Cidade está vazio");
		} else if (candidato.getCidade_cand().getNome_cid().length() > 100) {
			throw new Exception("O campo Cidade não pode conter mais de 100 caracteres");
		}

		if (candidato.getPartido_cand().getNome_part().trim().equals("")) {
			throw new Exception("O campo Partido está vazio");
		} else if (candidato.getPartido_cand().getNome_part().length() > 40) {
			throw new Exception("O campo Partido não pode conter mais de 40 caraceteres");
		}

		this.validarCandidato(candidato);

	}

	@Override
	public void cadastrarCandidato(Candidato candidato) throws Exception {
		this.validarCandidato(candidato);
		this.cadastrarCandidato(candidato);
	}

	@Override
	public void removerCandidato(Candidato candidato) throws Exception {
		this.removerCandidato(candidato);
	}

	@Override
	public Candidato alterarCandidato(Candidato candidato) throws Exception {
		this.validarCandidato(candidato);
		this.alterarCandidato(candidato);
		return candidato;
	}

	@Override
	public List<Candidato> consultarCandidatos() {

		return null;
	}

}
