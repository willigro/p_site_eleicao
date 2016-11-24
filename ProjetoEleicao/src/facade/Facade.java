package facade;

import controller.*;
import controller.exceptions.IdAbimguoAvaliacaoException;

import java.util.List;

import classesBasicas.*;

public class Facade implements IFachada {

	/**
	 * Implementei o new controllerEstado na chamada do consultarTodosEstados
	 */
	private ControllerCandidato controlCand;
	private ControllerUsuario controllerUsuario;
	private ControllerComentario controllerComentario;
	private ControllerAvaliacao controllerAvaliacao;
	private ControllerAdministrador controllerAdministrador;
	private ControllerProjeto controllerProjeto;
	private ControllerEstado controllerEstado;
	private ControllerCidade controllerCidade;
	private ControllerPartido controllerPartido;

	public Facade() {
		this.controlCand = new ControllerCandidato();
		this.controllerUsuario = new ControllerUsuario();
		this.controllerComentario = new ControllerComentario();
		this.controllerAvaliacao = new ControllerAvaliacao();
		this.controllerAdministrador = new ControllerAdministrador();
		this.controllerProjeto = new ControllerProjeto();
		// ControlCidade instanciada na chamada
		// ControllerPartido instanciado na chamada
	}

	public boolean validaControl(Object controlador) throws Exception {
		if (controlador != null)
			return true;
		else
			throw new Exception("Controller null");
	}

	@Override
	public void cadastrarCandidato(Candidato candidato) throws Exception {
		this.controlCand.cadastrarCandidato(candidato);
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		this.controllerUsuario.cadastrarUsuario(usuario);
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

	// OK
	@Override
	public Administrador loginAdministrador(Administrador adminsitrador) throws Exception {
		return this.controllerAdministrador.loginAdministrador(adminsitrador);
	}

	@Override
	public Usuario loginUsuario(Usuario usuario) throws Exception {
		return this.controllerUsuario.loginUsuario(usuario);
	}

	// OK
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
	public List<Comentario> visualizarComentsDenuncia() throws Exception {
		return this.controllerComentario.visualizarComentsDenuncia();
	}

	@Override
	public List<Candidato> consultarTodosCandidatos() throws Exception {
		return this.controlCand.consultarTodosCandidatos();
	}

	@Override
	public List<Projeto> consultarTodosProjetos() throws Exception {
		if (validaControl(this.controllerProjeto))
			return this.controllerProjeto.consultarTodosProjetos();
		else
			return null;
	}

	@Override
	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception {
		if (validaControl(this.controlCand))
			return this.controlCand.consultarCandidatosFiltrados(candidato);
		else
			return null;
	}

	@Override
	public List<Estado> consultarTodosEstado() throws Exception {
		this.controllerEstado = new ControllerEstado();
		return this.controllerEstado.consultarTodosEstado();
	}

	@Override
	public List<Cidade> consultarTodasCidade() throws Exception {
		this.controllerCidade = new ControllerCidade();
		return this.controllerCidade.consultarTodosEstado();
	}

	@Override
	public void inserirComentarioProjeto(Comentario comentario) throws Exception {
		this.controllerComentario = new ControllerComentario();
		this.controllerComentario.inserirComentarioProjeto(comentario);
	}

	@Override
	public void inserirAvaliacaoProjeto(Avaliacao avaliacao) throws Exception {
		this.controllerAvaliacao.inserirAvaliacaoProjeto(avaliacao);
	}

	public List<Usuario> consultarUsuarios() throws Exception {
		if (validaControl(this.controllerUsuario))
			return this.controllerUsuario.consultarUsuarios();
		else
			return null;
	}

	@Override
	public List<Partido> consultarTodosPartidos() throws Exception {
		this.controllerPartido = new ControllerPartido();
		if (this.controllerPartido != null)
			return this.controllerPartido.consultarTodosPartidos();
		return null;
	}

}
