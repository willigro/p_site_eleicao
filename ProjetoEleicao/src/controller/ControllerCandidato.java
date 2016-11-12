package controller;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Candidato;
import dao.DAOFactory;
import dao.classes.ExempleDAO;
import dao.interfaces.ICandidatoDAO;

public class ControllerCandidato {

	private ICandidatoDAO iCandidatoDAO;

	public ControllerCandidato() {
		this.iCandidatoDAO = DAOFactory.getCandidatoDAO();
	}

	public boolean validarController() throws Exception {
		if (iCandidatoDAO != null)
			return true;
		else
			throw new Exception("iCandidatoDAO null");
	}

	private void validarCandidato(Candidato candidato) throws Exception {

		// Falta: DataNascimeto, FotoCandidato, Validar os ID nulos e etc.

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

	}

	public void cadastrarCandidato(Candidato candidato) throws Exception {
		this.validarCandidato(candidato);

		if (iCandidatoDAO.retornaNumero(candidato) == false) {
			throw new Exception("O numero informado já consta cadastrado.");
		} else {
			iCandidatoDAO.cadastrarCandidato(candidato);
		}
	}

	public void removerCandidato(Candidato candidato) throws Exception {
		this.iCandidatoDAO.removerCandidato(candidato);
	}

	public Candidato alterarCandidato(Candidato candidato) throws Exception {
		this.validarCandidato(candidato);
		this.iCandidatoDAO.alterarCandidato(candidato);
		return candidato;
	}

	public List<Candidato> consultarTodosCandidatos() throws Exception {
		if (validarController())
			return this.iCandidatoDAO.consultarTodosCandidatos();
		else
			return null;
	}

	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception {
		List<Candidato> listCandidato;

		if (candidato.getId_cand() < 0) {
			throw new Exception("ID do candidato inválido");
		}

		if (candidato.getNome_cand().trim().length() > 50) {
			throw new Exception("O nome do candidato não pode conter mais de 50 caracteres");
		}

		if (candidato.getNumero_cand() > 99999) {
			throw new Exception("O campo Numero não deve ter mais que 5 dígitos");
		} else if (candidato.getNumero_cand() < 10000) {
			throw new Exception("O campo Numero não deve ter menos que 5 dígitos");
		}

		if (candidato.getTipo_Cargo_cand().length() > 50) {
			throw new Exception("O Campo Cargo Elegível não pode conter mais de 50 caracteres");
		}

		if (candidato.getEstado_cand().getNome_est().length() > 100) {
			throw new Exception("O campo Estado não pode conter mais de 100 caracteres");
		}

		if (candidato.getCidade_cand().getNome_cid().length() > 100) {
			throw new Exception("O campo Cidade não pode conter mais de 100 caracteres");
		}

		if (candidato.getPartido_cand().getNome_part().length() > 40) {
			throw new Exception("O campo Partido não pode conter mais de 40 caraceteres");
		}

		return listCandidato = this.iCandidatoDAO.consultarCandidatosFiltrados(candidato);

	}

}
