package dao.interfaces;

import java.util.List;
import classesBasicas.Cidade;

public interface ICidadeDAO {
	public List<Cidade> consultarTodasCidades() throws Exception;
}
