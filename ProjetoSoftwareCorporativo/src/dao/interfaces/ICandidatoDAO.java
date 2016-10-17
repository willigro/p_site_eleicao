package dao.interfaces;

import java.util.List;

import classesBasicas.Candidato;;
public interface ICandidatoDAO {

	public void insert(Candidato candidato) throws Exception;
	public List<Candidato> consultarTodosCandidatos() throws Exception;
	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception;
	public void cadastrarCandidato(Candidato candidato) throws Exception;
	public void removerCandidato(Candidato candidato) throws Exception;
	public Candidato alterarCandidato(Candidato candidato) throws Exception;
	public void validarCandidato(Candidato candidato) throws Exception;
}
