package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.List;
import classesBasicas.Comentario;
import classesBasicas.Usuario;

public class ComentarioDAO extends DAOGenerico<Comentario> implements IComentarioDAO {

	@Override
	public List<Comentario> visualizarComentsDenuncia(Usuario usuario) throws Exception {
		
		List<Comentario> lista_comentarios = new ArrayList<>();
		
		try {
			lista_comentarios = getManager().createQuery("SELECT comentario FROM Usuario comentario").getResultList();
			if (lista_comentarios.isEmpty()) {
				throw new Exception("Esse usu�rio n�o comentou nada");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista_comentarios;
	}

}
