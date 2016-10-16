package facade;

import controller.*;
import classesBasicas.*;

public class Facade implements IFachada {

	private ControllerCandidato controlCand;
	private ControllerUsuario controllerUsuario;
	private ControllerComentario controllerComentario;
	private ControllerAvaliacao controllerAvaliacao;

	public Facade() {
		controlCand = new ControllerCandidato();
		this.controllerUsuario = new ControllerUsuario();
		this.controllerComentario = new ControllerComentario();
		this.controllerAvaliacao = new ControllerAvaliacao();
	}

	@Override
	public void cadastrarCandidato(Candidato candidato) throws Exception {
		controlCand.cadastrarCandidato(candidato);
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		try {
			this.controllerUsuario.cadastrarUsuario(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void inserirComentarioCandidato(Comentario comentario) throws Exception {
		this.controllerComentario.inserirComentarioCandidato(comentario);
	}

	@Override
	public Comentario atualizarComentario(Comentario comentario) throws Exception {
		return this.controllerComentario.atualizarComentario(comentario);
	}

	@Override
	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception {
		this.controllerAvaliacao.inserirAvaliacaoCandidato(avaliacao);
	}
}
