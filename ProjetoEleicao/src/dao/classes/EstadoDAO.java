package dao.classes;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Estado;
import dao.DAOGenerico;
import dao.interfaces.IEstadoDAO;

public class EstadoDAO extends DAOGenerico<Estado> implements IEstadoDAO{

	@Override
	public List<Estado> consultarTodosEstados() throws Exception {
		List<Estado> lista_estado = new ArrayList<>();
		try {
			lista_estado = getManager().createQuery("SELECT est FROM Estado est").getResultList();
			if (lista_estado.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lista_estado;
	}

}
