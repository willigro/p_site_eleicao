package dao.interfaces;

import dao.classes.CandidatoDAO;

import java.util.List;

import classesBasicas.Candidato;;
public interface ICandidatoDAO {

	public void insert(CandidatoDAO candidatoDAO);
	public List<Candidato> consultarCandidatos();
}
