package dao.interfaces;

import java.util.List;

import classesBasicas.Comentario;
import classesBasicas.Denuncia;

public interface IDenunciaDAO {

	public void denunciarComentario(Denuncia denuncia) throws Exception;
	public void removerDenunciaComentario(Denuncia denuncia) throws Exception;
	public List<Denuncia> consultarDenunciaDoComentario() throws Exception;
	
}
