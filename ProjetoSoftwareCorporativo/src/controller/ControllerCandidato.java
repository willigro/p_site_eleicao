package controller;

import classesBasicas.Candidato;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;
import dao.classes.ExempleDAO;
import dao.interfaces.ICandidatoDAO;

public class ControllerCandidato implements ICandidatoDAO {
	private ICandidatoDAO iCandidatoDAO;

	public void ControllerCanditato() {
		iCandidatoDAO = DAOFactory.getCandidatoDAO();
	}

	public void insert(CandidatoDAO candidatoDAO) {
		candidatoDAO.insert(candidatoDAO);
	}

	// validação do cadastro
	public void validarCandidato(Candidato candidato) throws Exception {
		
		if(candidato.getNome_cand().trim().equals("")) {
			throw new Exception("O campo Nome está vazio");
		} else if (candidato.getNome_cand().length() > 50) {
			throw new Exception("O nome do candidato não pode conter mais de 50 caracteres");
		}
		
		if(candidato.getNumero_cand() > 99999){
			throw new Exception("O campo Numero não deve ter mais que 5 dígitos");
		}else if (candidato.getNumero_cand() < 10000){
			throw new Exception("O campo Numero não deve ter menos que 5 dígitos");
		}
		
		if(candidato.getEstado_cand().equals("")){
			
		}
	}
	

}
