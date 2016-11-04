package dao.interfaces;

import java.util.List;
import classesBasicas.Comentario;
import classesBasicas.Usuario;

public interface IComentarioDAO {
	public List<Comentario> visualizarComentsDenuncia() throws Exception;
	public void insert(Comentario comentario) throws Exception;
}