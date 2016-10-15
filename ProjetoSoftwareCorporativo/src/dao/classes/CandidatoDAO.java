package dao.classes;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Candidato;
import dao.DAOGenerico;
import dao.interfaces.ICandidatoDAO;

public class CandidatoDAO extends DAOGenerico<Candidato> implements ICandidatoDAO {
	
	@Override
	public List<Candidato> consultarCandidatos() {
		List<Candidato> lista_candidatos = new ArrayList<>();
		return lista_candidatos;
	}
}
