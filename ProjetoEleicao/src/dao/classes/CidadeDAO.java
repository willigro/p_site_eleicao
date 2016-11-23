package dao.classes;

import java.util.ArrayList;
import java.util.List;
import classesBasicas.Cidade;
import dao.DAOGenerico;
import dao.interfaces.ICidadeDAO;

public class CidadeDAO extends DAOGenerico<Cidade> implements ICidadeDAO{
	
	public List<Cidade> consultarTodasCidades() throws Exception{
		
		List<Cidade> lista_cidade = new ArrayList<>();
		try {
			lista_cidade = getManager().createQuery("SELECT cid FROM Cidade cid").getResultList();
			if (lista_cidade.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lista_cidade;
	}

}
