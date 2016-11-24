package dao.interfaces;

import java.util.List;

import classesBasicas.Partido;

public interface IPartidoDAO {
	public List<Partido> consultarTodosPartidos() throws Exception;
}
