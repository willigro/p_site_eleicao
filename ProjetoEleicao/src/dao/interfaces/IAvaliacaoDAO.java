package dao.interfaces;

import classesBasicas.Avaliacao;

public interface IAvaliacaoDAO {
	public void insert(Avaliacao avaliacao) throws Exception;
	public void insertAvaliacaoProjeto(Avaliacao avaliacao) throws Exception;
}
