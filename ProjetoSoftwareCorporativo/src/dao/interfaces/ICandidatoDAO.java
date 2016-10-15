package dao.interfaces;

import java.util.List;

import classesBasicas.Candidato;;
public interface ICandidatoDAO {

	public void insert(Candidato candidato) throws Exception;
	public List<Candidato> consultarCandidatos();
}
