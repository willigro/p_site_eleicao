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

	// valida��o do cadastro
	public void validarCandidato(Candidato candidato) throws Exception {
		
		if(candidato.getNome_cand().trim().equals("")) {
			throw new Exception("O campo Nome est� vazio");
		} else if (candidato.getNome_cand().length() > 50) {
			throw new Exception("O nome do candidato n�o pode conter mais de 50 caracteres");
		}
		
		if(candidato.getNumero_cand() > 99999){
			throw new Exception("O campo Numero n�o deve ter mais que 5 d�gitos");
		}else if (candidato.getNumero_cand() < 10000){
			throw new Exception("O campo Numero n�o deve ter menos que 5 d�gitos");
		}
		
		if(candidato.getEstado_cand().equals("")){
			
		}
	}
	

}
