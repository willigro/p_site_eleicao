package dao.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import classesBasicas.Candidato;
import dao.DAOGenerico;
import dao.interfaces.ICandidatoDAO;
import javassist.bytecode.stackmap.BasicBlock.Catch;

public class CandidatoDAO extends DAOGenerico<Candidato> implements ICandidatoDAO {

	@Override
	public List<Candidato> consultarTodosCandidatos() throws Exception {
		List<Candidato> lista_candidatos = new ArrayList<>();
		try {

			lista_candidatos = getManager().createQuery("SELECT" + "cand FROM " + "Candidato cand").getResultList();
			if (lista_candidatos.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return lista_candidatos;
	}

	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception {
		String montagemQuery = "SELECT cand FROM Candidato cand WHERE id_cand = id_cand";
		Query query = null;
		try {
			if (candidato.getNome_cand() != null || !candidato.getNome_cand().trim().equals("")) {
				montagemQuery += " AND cand.nome_cand = :nome_cand";
			}
			if (candidato.getId_cand() != 0) {
				montagemQuery += " AND cand.id_cand = :id_cand";
			}
			if (candidato.getCidade_cand() != null || !candidato.getCidade_cand().getNome_cid().trim().equals("")) {
				montagemQuery += " AND cand.cidade_cand = :cidade_cand";
			}
			if (candidato.getEstado_cand() != null || !candidato.getEstado_cand().getNome_est().trim().equals("")) {
				montagemQuery += " AND cand.estado_cand = :estado_cand";
			}
			if (candidato.getPartido_cand() != null || !candidato.getPartido_cand().getNome_part().trim().equals("")) {
				montagemQuery += " AND cand.partido_cand = :partido_cand";
			}
			if (candidato.getNumero_cand() != 0) {
				montagemQuery += " AND cand.numero_cand = :numero_cand";
			}
			if (candidato.getTipo_Cargo_cand() != null || !candidato.getTipo_Cargo_cand().trim().equals("")) {
				montagemQuery += " AND cand.tipo_Cargo_cand = :tipo_Cargo_cand";
			}
			query = getManager().createQuery(montagemQuery);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return query.getResultList();
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

}
