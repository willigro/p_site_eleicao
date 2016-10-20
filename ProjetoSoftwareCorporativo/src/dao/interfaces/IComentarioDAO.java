package dao.interfaces;

import java.util.List;
import classesBasicas.Comentario;
import classesBasicas.Usuario;

public interface IComentarioDAO {

	List<Comentario> visualizarComentsDenuncia(Usuario usuario) throws Exception;

}
