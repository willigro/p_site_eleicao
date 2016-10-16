package dao.interfaces;

import java.util.List;

import classesBasicas.Candidato;;
public interface ICandidatoDAO {

	public List<Candidato> consultarCandidatos();
	public void cadastrarCandidato(Candidato candidato) throws Exception;
	void removerCandidato(Candidato candidato) throws Exception;
	void alterarCandidato(Candidato candidato) throws Exception;
}
