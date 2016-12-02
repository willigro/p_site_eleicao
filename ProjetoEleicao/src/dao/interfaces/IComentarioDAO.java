package dao.interfaces;

import java.util.List;
import classesBasicas.Comentario;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public interface IComentarioDAO {
	public List<Comentario> visualizarComentsDenuncia() throws Exception;
//	public void comentarProjeto(Comentario comentario) throws Exception;
	public void insert(Comentario comentario) throws Exception;
	public Comentario update(Comentario comentario) throws Exception;
	public void denunciarComentario(Comentario comentario) throws Exception;	
	public Comentario verificarComentario(Comentario comentario) throws Exception;
	public List<Comentario> consultarComentarioFiltradosIdProjt(Projeto projeto) throws Exception;
	public void removerComent (Comentario comentario) throws Exception;
}