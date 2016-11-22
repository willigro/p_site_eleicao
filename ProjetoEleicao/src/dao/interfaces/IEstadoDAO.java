package dao.interfaces;

import java.util.List;

import classesBasicas.Estado;

public interface IEstadoDAO {
	public List<Estado> consultarTodosEstados() throws Exception;
}
