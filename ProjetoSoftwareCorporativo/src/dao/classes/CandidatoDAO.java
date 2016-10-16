package dao.classes;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Candidato;
import dao.DAOGenerico;
import dao.interfaces.ICandidatoDAO;

public class CandidatoDAO extends DAOGenerico<Candidato> implements ICandidatoDAO {

	@Override
	public List<Candidato> consultarCandidatos() throws Exception{
		List<Candidato> lista_candidatos = new ArrayList<>();
		lista_candidatos = getManager().createQuery("SELECT"
				+ "cand FROM Candidato cand").getResultList();
		if(lista_candidatos.isEmpty()){
			throw new Exception("Não há registros armazenados");
		}
		return lista_candidatos;
	}

	@Override
	public void removerCandidato(Candidato candidato) throws Exception {
		super.delete(candidato);		
	}

	@Override
	public Candidato alterarCandidato(Candidato candidato) throws Exception {
		return super.update(candidato);		
	}

	@Override
	public void cadastrarCandidato(Candidato candidato) throws Exception {
		super.insert(candidato);	
	}

	@Override
	public void validarCandidato(Candidato candidato) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
