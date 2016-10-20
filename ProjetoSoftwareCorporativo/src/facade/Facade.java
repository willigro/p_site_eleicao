package facade;

import controller.*;
import controller.exceptions.IdAbimguoAvaliacaoException;

import java.util.List;

import classesBasicas.*;

public class Facade implements IFachada {

	private ControllerCandidato controlCand;
	private ControllerUsuario controllerUsuario;
	private ControllerComentario controllerComentario;
	private ControllerAvaliacao controllerAvaliacao;
	private ControllerAdministrador controllerAdministrador;

	public Facade() {
		controlCand = new ControllerCandidato();
		this.controllerUsuario = new ControllerUsuario();
		this.controllerComentario = new ControllerComentario();
		this.controllerAvaliacao = new ControllerAvaliacao();
		this.controllerAdministrador = new ControllerAdministrador();
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


	//OK
	@Override
	public Administrador loginAdministrador(Administrador adminsitrador) throws Exception {
		return this.controllerAdministrador.loginAdministrador(adminsitrador);
	}

	//OK
	@Override
	public boolean punirUsuario(Administrador administrador) throws Exception {
		return this.controllerAdministrador.punirUsuario(administrador);
	}
	@Override
	public void removerCandidato(Candidato candidato) throws Exception {
		this.controlCand.removerCandidato(candidato);
	}

	@Override
	public Candidato alterarCandidato(Candidato candidato) throws Exception {
		return this.controlCand.alterarCandidato(candidato);
	}

	@Override
	public List<Comentario> visualizarComentsDenuncia(Usuario usuario) throws Exception {
		return this.controllerComentario.visualizarComentsDenuncia(usuario);
	}
}
