package dao.classes;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Partido;
import dao.DAOGenerico;
import dao.interfaces.IPartidoDAO;

public class PartidoDAO extends DAOGenerico<Partido> implements IPartidoDAO{

	@Override
	public List<Partido> consultarTodosPartidos() throws Exception {
		List<Partido> lista_partido = new ArrayList<>();
		try {
			lista_partido = getManager().createQuery("SELECT part FROM Partido part").getResultList();
			if (lista_partido.isEmpty()) {
				throw new Exception("Não há registros armazenados");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lista_partido;
	}

}
