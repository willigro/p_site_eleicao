package controller;

import classesBasicas.Comentario;
import dao.classes.ComentarioDAO;
import dao.DAOFactory;

public class ControllerComentario {

	private ComentarioDAO comentarioDAO;
	
	public ControllerComentario(){
		this.comentarioDAO = DAOFactory.getComentarioDAO();
	}
	
	private void validarComentario(Comentario comentario) throws Exception{
		if (comentario.getTexto_coment().trim().isEmpty()) {
			throw new Exception("Informe um texto no comentário");
		}
		if (comentario.getTexto_coment().length() > 500) {
			throw new Exception("Limite de 500 caracteres excedido");
		}
	}

	public void inserirComentarioCandidato(Comentario comentario) throws Exception {
		this.validarComentario(comentario);
		this.comentarioDAO.insert(comentario);
	}
	
	public Comentario atualizarComentario(Comentario comentario) throws Exception{
		this.validarComentario(comentario);
		comentario = this.comentarioDAO.update(comentario);
		return comentario;
	}

}
