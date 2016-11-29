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

		if (candidato.getNome_cand().trim().isEmpty()) {
			throw new Exception("O campo Nome está vazio");
		} else if (candidato.getNome_cand().length() > 50) {
			throw new Exception("O nome do candidato não pode conter mais de 50 caracteres");
		}

		if (candidato.getNumero_cand() > 99999) {
			throw new Exception("O campo Numero não deve ter mais que 5 dígitos");
		} else if (candidato.getNumero_cand() < 10) {
			throw new Exception("O campo Numero não deve ter menos que 2 dígitos");
		}

		if (candidato.getTipo_Cargo_cand().trim().isEmpty()) {
			throw new Exception("O campo Cargo Elegível está vazio");
		} else if (candidato.getTipo_Cargo_cand().length() > 50) {
			throw new Exception("O Campo Cargo Elegível não pode conter mais de 50 caracteres");
		}

	}

	public void cadastrarCandidato(Candidato candidato) throws Exception {
		this.validarCandidato(candidato);

		if (iCandidatoDAO.retornaNumero(candidato) == false) {
			throw new Exception("O numero informado na mesma cidade já consta cadastrado.");
		} else {
			iCandidatoDAO.cadastrarCandidato(candidato);
		}
	}

	public void removerCandidato(Candidato candidato) throws Exception {
		this.iCandidatoDAO.removerCandidato(candidato);
	}

	public void alterarCandidato(Candidato candidato) throws Exception {

		// Setando abaixo enquanto não consigo passar o objeto entre telas
		int numero = 11111;
		int cidade = 1;

		this.validarCandidato(candidato);

		System.out.println(candidato.getId_cand() + "ID do candidato novo (setado)");

		if (iCandidatoDAO.retornaID(candidato) == true) {
			throw new Exception("O candidato informado não existe cadastrado.");
		} else {
			if ((candidato.getNumero_cand() == numero) && (candidato.getCidade_cand().getId_cid()) == cidade) {
				this.iCandidatoDAO.alterarCandidato(candidato);
			} else {
				if (iCandidatoDAO.retornaNumero(candidato) == false) {
					throw new Exception("O numero informado na mesma cidade já consta cadastrado.");
				} else {
					this.iCandidatoDAO.alterarCandidato(candidato);
				}
			}
		}

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
		if (candidato.getNome_cand() != null)
			if (candidato.getNome_cand().trim().length() > 50) {
				throw new Exception("O nome do candidato não pode conter mais de 50 caracteres");
			}
		if (candidato.getNumero_cand() > 0)
			if (candidato.getNumero_cand() > 99999) {
				throw new Exception("O campo Numero não deve ter mais que 5 dígitos");
			} else if (candidato.getNumero_cand() < 10000) {
				throw new Exception("O campo Numero não deve ter menos que 5 dígitos");
			}
		if (candidato.getTipo_Cargo_cand() != null)
			if (candidato.getTipo_Cargo_cand().length() > 50) {
				throw new Exception("O Campo Cargo Elegível não pode conter mais de 50 caracteres");
			}

		if (candidato.getEstado_cand().getId_est() < 0) {
			throw new Exception("ID do estado inválido");
		}

		if (candidato.getCidade_cand().getId_cid() < 0) {
			throw new Exception("ID da cidade inválido");
		}

		if (candidato.getPartido_cand().getId_part() < 0) {
			throw new Exception("ID do partido inválido");
		}

		return listCandidato = this.iCandidatoDAO.consultarCandidatosFiltrados(candidato);

	}

}
