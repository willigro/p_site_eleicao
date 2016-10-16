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
			throw new Exception("O campo Nome est� vazio");
		} else if (candidato.getNome_cand().length() > 50) {
			throw new Exception("O nome do candidato n�o pode conter mais de 50 caracteres");
		}

		if (candidato.getNumero_cand() > 99999) {
			throw new Exception("O campo Numero n�o deve ter mais que 5 d�gitos");
		} else if (candidato.getNumero_cand() < 10000) {
			throw new Exception("O campo Numero n�o deve ter menos que 5 d�gitos");
		}

		if (candidato.getTipo_Cargo_cand().trim().equals("")) {
			throw new Exception("O campo Cargo Eleg�vel est� vazio");
		} else if (candidato.getTipo_Cargo_cand().length() > 50) {
			throw new Exception("O Campo Cargo Eleg�vel n�o pode conter mais de 50 caracteres");
		}

		if (candidato.getEstado_cand().getNome_est().trim().equals("")) {
			throw new Exception("O campo Estado est� vazio");
		} else if (candidato.getEstado_cand().getNome_est().length() > 100) {
			throw new Exception("O campo Estado n�o pode conter mais de 100 caracteres");
		}

		if (candidato.getCidade_cand().getNome_cid().trim().equals("")) {
			throw new Exception("O campo Cidade est� vazio");
		} else if (candidato.getCidade_cand().getNome_cid().length() > 100) {
			throw new Exception("O campo Cidade n�o pode conter mais de 100 caracteres");
		}

		if (candidato.getPartido_cand().getNome_part().trim().equals("")) {
			throw new Exception("O campo Partido est� vazio");
		} else if (candidato.getPartido_cand().getNome_part().length() > 40) {
			throw new Exception("O campo Partido n�o pode conter mais de 40 caraceteres");
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
