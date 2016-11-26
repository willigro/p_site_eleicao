package dao.classes;

import dao.DAOGenerico;
import dao.interfaces.IComentarioDAO;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import classesBasicas.Comentario;
import classesBasicas.Usuario;

public class ComentarioDAO extends DAOGenerico<Comentario> implements IComentarioDAO {

	@Override
	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		List<Comentario> lista_comentarios = new ArrayList<>();
		try {
			lista_comentarios = getManager()
					.createQuery("SELECT comentario FROM Comentario comentario WHERE qtd_denuncia > 9")
					.getResultList();
			if (lista_comentarios.isEmpty()) {
				throw new Exception("N�o h� registros armazenados");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return lista_comentarios;
	}


	@Override
	public void denunciarComentario(Comentario comentario) throws Exception{
		Query query = getManager().createQuery("UPDATE Comentario as c set qtd_denuncia = :Qtd WHERE id_coment = :Id");
		query.setParameter("Qtd", comentario.getQtd_denuncia());
		query.setParameter("Id", comentario.getId_coment());
		
		query.executeUpdate();
	}
	
	@Override
	public Comentario verificarComentario(Comentario comentario) throws Exception{
		Query query = getManager().createQuery("SELECT u FROM Usuario u WHERE id_user =:Id",Comentario.class);
		query.setParameter("Id",comentario.getId_coment());
		
		Comentario c = (Comentario) query.getSingleResult();
		if(c == null){
			throw new Exception("Nao ha registros armazenados");
		}
		
		return c;
	}

	// public void comentarProjeto(Comentario comentario) throws Exception{
	// super.insert(comentario);
	// }

}
