package controller;

import java.util.ArrayList;
import java.util.List;

import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Usuario;
import controller.exceptions.IdAbimguoAvaliacaoException;
import dao.interfaces.IComentarioDAO;
import dao.DAOFactory;

public class ControllerComentario {

	private IComentarioDAO iComentarioDAO;

	public ControllerComentario() {
		this.iComentarioDAO = DAOFactory.getComentarioDAO();
	}

	private void validarComentario(Comentario comentario) throws Exception {
		if (comentario.getTexto_coment().trim().isEmpty()) {
			throw new Exception("Informe um texto no comentário");
		} else if (comentario.getTexto_coment().length() > 500) {
			throw new Exception("Limite de 500 caracteres excedido");
		}
//		if (comentario.getUsuario_coment().getId_user() == 0) {
//			throw new IdAbimguoAvaliacaoException();
//		}
	}

	public void inserirComentarioCandidato(Comentario comentario) throws Exception {
		if (comentario.getCandidato_coment().getId_cand() == 0) {
			throw new Exception("Candidato não encontrado - comentário");
		} else
			this.validarComentario(comentario);
		this.iComentarioDAO.insert(comentario);
	}

	public Comentario atualizarComentario(Comentario comentario) throws Exception {
		this.validarComentario(comentario);
		comentario = this.iComentarioDAO.update(comentario);
		return comentario;
	}

	public void removerComentario(Comentario comentario) throws Exception {
		this.removerComentario(comentario);
	}

	public void inserirComentarioProjeto(Comentario comentario) throws Exception {
		if (comentario.getProjeto_coment() == null) {
			throw new Exception("Projeto não encontrado: Null - comentário");
		} else if (comentario.getProjeto_coment().getId_proj() == 0) {
			throw new Exception("Projeto não encontrado: ID - comentário");
		} else
			this.validarComentario(comentario);
		this.iComentarioDAO.insert(comentario);
	}

	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		List<Comentario> listComentario = new ArrayList();
		return listComentario = this.iComentarioDAO.visualizarComentsDenuncia();
	}

}
