package controller;

import dao.DAOFactory;
import dao.interfaces.IProjetoDAO;

import java.util.List;

import org.omg.PortableServer.ThreadPolicyOperations;

import classesBasicas.Projeto;

public class ControllerProjeto {
	private IProjetoDAO iProjetoDAO;

	public ControllerProjeto() {
		iProjetoDAO = DAOFactory.getProjetoDAO();
	}
	
	public List<Projeto> consultarTodosProjetos() throws Exception{
		return iProjetoDAO.consultarTodosProjetos();
	}
	
	public List<Projeto> consultarProjetosFiltrados(Projeto projeto) throws Exception{
		try{
			if(projeto.getCanditado_proj().getNome_cand().trim().length() > 50){
				throw new Exception("O nome do candidato não pode conter mais de 50 caracteres");
			}
			if(projeto.getCanditado_proj().getId_cand() <= 0){
				throw new Exception("ID do candidato inválido");
			}
			if(projeto.getId_proj() <= 0){
				throw new Exception("ID do projeto inválido");
			}			
			if(projeto.getTitulo_proj().trim().length() > 50){
				throw new Exception("Titulo não pode conter mais de 50 caracteres");
			}			
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		return iProjetoDAO.consultarProjetosFiltrados(projeto);
	}	
}
