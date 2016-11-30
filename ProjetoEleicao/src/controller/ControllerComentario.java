package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Projeto;
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
			throw new Exception("Informe um texto no comentï¿½rio");
		} else if (comentario.getTexto_coment().length() > 500) {
			throw new Exception("Limite de 500 caracteres excedido");
		}
		// if (comentario.getUsuario_coment().getId_user() == 0) {
		// throw new IdAbimguoAvaliacaoException();
		// }
	}

	public void inserirComentarioCandidato(Comentario comentario) throws Exception {
		if (comentario.getCandidato_coment() == null)
			throw new Exception("Candidato nï¿½o encontrado: Null - comentï¿½rio");
		else if (comentario.getCandidato_coment().getId_cand() == 0) {
			throw new Exception("Candidato nï¿½o encontrado: ID - comentï¿½rio");
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
	
	public void removerComentDenunciado(Comentario comentario) throws Exception {
		this.iComentarioDAO.removerComentDenunciado(comentario);
	}
	
	public void inserirComentarioProjeto(Comentario comentario) throws Exception {
		if (comentario.getProjeto_coment() == null) {
			throw new Exception("Projeto nï¿½o encontrado: Null - comentï¿½rio");
		} else if (comentario.getProjeto_coment().getId_proj() <= 0) {
			throw new Exception("Projeto nï¿½o encontrado: ID - comentï¿½rio");
		} else
			this.validarComentario(comentario);
		this.iComentarioDAO.insert(comentario);
	}

	public void denunciarComentario(Comentario comentario) throws Exception {

		if (comentario == null) {
			throw new Exception("Comentario nulo");
		}
		if (comentario.getCandidato_coment() == null) {
			throw new Exception("Usuario do comentario nulo");
		}
		// if(comentario.getCandidato_coment().getId_cand())
		if (!consultarComentarioPorId(comentario)) {
			throw new Exception("Comentario inextente na base de dados");
		}

		// if(comentario.getQtd_denuncia() ==
		// verificarQuantidadeDenunciasComentario(comentario)){
		// throw new Exception("A quantidade de denuncia informada nao pode ser
		// igual a da base de dados");
		// }
		this.iComentarioDAO.denunciarComentario(comentario);
	}

	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		List<Comentario> listComentario = new ArrayList();
		return listComentario = this.iComentarioDAO.visualizarComentsDenuncia();
	}

	// RETORNA A QUANTIDADE DE DENUNCIAS DO COMENTARIO ESPECIFICO
	// public int verificarQuantidadeDenunciasComentario(Comentario comentario)
	// throws Exception{
	// if(comentario == null){
	// throw new Exception("Comentario nulo");
	// }
	// if(comentario.getId_coment() <= 0){
	// throw new Exception("O id do comentario nao pode ser igual ou menor que
	// zero");
	// }
	//
	// return iComentarioDAO.verificarComentario(comentario).getQtd_denuncia();
	// }

	// RETORNA SE O ID DO COMENTARIO EXISTE NA BASE DE DADOS (TRUE)=EXISTE /
	// (FALSE)=N EXISTE
	public boolean consultarComentarioPorId(Comentario comentario) throws Exception {

		if (iComentarioDAO.verificarComentario(comentario) != null) {
			return true;
		}
		return false;
	}

	// Retorna uma lista de comentários filtrados pelo id de um projeto
	public List<Comentario> consultarComentarioFiltradosIdProjt(Projeto projeto) throws Exception {
		return this.iComentarioDAO.consultarComentarioFiltradosIdProjt(projeto);
	}
	
	public List<Comentario> consultarComentarioFiltradosIdCand(Candidato candidato) throws Exception{
		return this.iComentarioDAO.consultarComentarioFiltradosIdCand(candidato);
	}

}
