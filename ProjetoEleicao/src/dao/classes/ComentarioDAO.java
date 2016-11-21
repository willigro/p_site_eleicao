package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.List;
import classesBasicas.Comentario;
import classesBasicas.Usuario;

public class ComentarioDAO extends DAOGenerico<Comentario> implements IComentarioDAO {

	@Override
	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		
		List<Comentario> lista_comentarios = new ArrayList<>();
		
		try {
			lista_comentarios = getManager().createQuery("SELECT comentario FROM Comentario comentario"
					+ "WHERE qtd_denuncia > 9").getResultList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista_comentarios;
	}

//	public void comentarProjeto(Comentario comentario) throws Exception{
//		super.insert(comentario);
//	}
}
