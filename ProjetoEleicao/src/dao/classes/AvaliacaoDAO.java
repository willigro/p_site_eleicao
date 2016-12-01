package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IAvaliacaoDAO;
import javax.persistence.Query;

import classesBasicas.Avaliacao;

public class AvaliacaoDAO extends DAOGenerico<Avaliacao> implements IAvaliacaoDAO{

	@Override
	public void inserirAvaliacao(Avaliacao avaliacao) throws Exception {
		if(verificarAvaliacao(avaliacao) == null){
			super.insert(avaliacao);
		}else {
			super.update(avaliacao);
		}
	}
	
	private Avaliacao verificarAvaliacao(Avaliacao avaliacao){
		Query query = super.getManager().createQuery("SELECT a FROM Avaliacao a WHERE id_user = :user AND id_cand = :cand");
		query.setParameter("user", avaliacao.getUsuario_aval().getId_user());
		query.setParameter("cand", avaliacao.getCandidato_aval().getId_cand());
		return (Avaliacao) query.getSingleResult();
	}
	
	
}
