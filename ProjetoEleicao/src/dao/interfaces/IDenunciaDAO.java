package dao.interfaces;

import classesBasicas.Comentario;
import classesBasicas.Denuncia;

public interface IDenunciaDAO {

	public void denunciarComentario(Denuncia denuncia) throws Exception;
	public void removerDenunciaComentario(Denuncia denuncia) throws Exception;
	public Denuncia consultarDenunciaDoComentario(Denuncia denuncia) throws Exception;
	
}
