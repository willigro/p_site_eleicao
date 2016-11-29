package dao.interfaces;

import java.util.List;

import classesBasicas.Projeto;;

public interface IProjetoDAO {
	public List<Projeto> consultarProjetosFiltradosIdCand(Projeto projeto) throws Exception;
	public List<Projeto> consultarTodosProjetos() throws Exception;
	//insert
	//update
	//remove
}
