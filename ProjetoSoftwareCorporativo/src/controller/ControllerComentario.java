package controller;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Usuario;
import controller.exceptions.IdAbimguoAvaliacaoException;
import dao.classes.ComentarioDAO;
import dao.DAOFactory;

public class ControllerComentario {

	private ComentarioDAO comentarioDAO;

	public ControllerComentario() {
		this.comentarioDAO = DAOFactory.getComentarioDAO();
	}

	private void validarComentario(Comentario comentario) throws Exception {
		if (comentario.getTexto_coment().trim().isEmpty()) {
			throw new Exception("Informe um texto no comentário");
		}
		if (comentario.getTexto_coment().length() > 500) {
			throw new Exception("Limite de 500 caracteres excedido");
		}
		if(comentario.getProjeto_coment().getId_proj() >= 0 || comentario.getCandidato_coment().getId_cand() >= 0){
			throw new Exception("Candidato ou proposta não encontrados");
		}
		if(comentario.getUsuario_coment().getId_user() == 0){
			throw new IdAbimguoAvaliacaoException();
		}
	}

	public void inserirComentarioCandidato(Comentario comentario) throws Exception {
		this.validarComentario(comentario);
		this.comentarioDAO.insert(comentario);
	}

	public Comentario atualizarComentario(Comentario comentario) throws Exception {
		this.validarComentario(comentario);
		comentario = this.comentarioDAO.update(comentario);
		return comentario;
	}

	public void removerComentario(Comentario comentario) throws Exception {
		this.removerComentario(comentario);
	}
	
	public void inserirComentarioProjeto(Comentario comentario) throws Exception{
		this.validarComentario(comentario);
		this.comentarioDAO.insert(comentario);
	}

	public List<Comentario> visualizarComentsDenuncia(Usuario usuario) throws Exception{
		List<Comentario> listComentario = new ArrayList();
		return listComentario = this.comentarioDAO.visualizarComentsDenuncia(usuario);
	}
	
}
