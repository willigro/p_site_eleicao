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
	private ControllerDenuncia controllerDenuncia;

	private ControllerVariableObject controllerVariable;
	private ControllerErroSite controllerErroSite;

	public Facade() {
		this.controllerDenuncia = new ControllerDenuncia();
		this.controlCand = new ControllerCandidato();
		this.controllerUsuario = new ControllerUsuario();
		this.controllerComentario = new ControllerComentario();
		this.controllerAvaliacao = new ControllerAvaliacao();
		this.controllerAdministrador = new ControllerAdministrador();
		this.controllerProjeto = new ControllerProjeto();
		this.controllerErroSite = new ControllerErroSite();
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
	public Administrador loginAdministrador(Administrador adminsitrador) throws Exception {
		return this.controllerAdministrador.loginAdministrador(adminsitrador);
	}

	@Override
	public void logoutAdministrador() throws Exception {

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

	@Override
	public Usuario loginUsuario(Usuario usuario) throws Exception {
		return this.controllerUsuario.loginUsuario(usuario);
	}

	@Override
	public void removerCandidato(Candidato candidato) throws Exception {
		this.controlCand.removerCandidato(candidato);
	}

	@Override
	public void alterarCandidato(Candidato candidato, Candidato oldCand) throws Exception {
		this.controlCand.alterarCandidato(candidato, oldCand);
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

	@Override
	public List<Partido> consultarTodosPartidos() throws Exception {
		this.controllerPartido = new ControllerPartido();
		if (this.controllerPartido != null)
			return this.controllerPartido.consultarTodosPartidos();
		return null;
	}

	@Override
	public List<Usuario> consultarUsuarios() throws Exception {
		if (validaControl(this.controllerUsuario))
			return this.controllerUsuario.consultarUsuarios();
		else
			return null;
	}

	public List<Usuario> consultarUsuarioPorFiltro(Usuario usuario) throws Exception {
		if (validaControl(this.controllerUsuario)) {
			return this.controllerUsuario.consultarUsuarioPorFiltro(usuario);
		}
		return null;
	}

	@Override
	public void banirUsuario(Usuario usuario) throws Exception {
		if (validaControl(this.controllerUsuario)) {
			this.controllerUsuario.banirUsuario(usuario);
		}

	}

	@Override
	public void denunciarComentario(Comentario comentario) throws Exception {
		if (validaControl(this.controllerComentario)) {
			this.controllerComentario.denunciarComentario(comentario);
		}
	}

	@Override
	public List<Cidade> consultarCidadeFiltrada(Cidade cidade) throws Exception {
		this.controllerCidade = new ControllerCidade();
		return this.controllerCidade.consultarCidadeFiltrada(cidade);
	}

	@Override
	public void armazenarVariavel(Object value) throws Exception {
		this.controllerVariable = new ControllerVariableObject();
		this.controllerVariable.setValue(value);
	}

	@Override
	public Object retornarVariavel() throws Exception {
		this.controllerVariable = new ControllerVariableObject();
		return this.controllerVariable.getValue();
	}

	@Override
	public boolean consultarStatusUsuarioBanido(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Projeto> consultarProjetosFiltradosIdCand(Projeto projeto) throws Exception {
		return this.controllerProjeto.consultarProjetosFiltradosIdCand(projeto);
	}

	// @Override
	// public Usuario consultarStatusUsuarioBanido(Usuario usuario) throws
	// Exception{
	// if(validaControl(this.controllerUsuario)){
	// return this.controllerUsuario.consultarStatusUsuarioBanido(usuario);
	// }
	// return null;
	// }

	public List<ErroSite> consultarErrosPorFiltro(ErroSite erroSite) throws Exception {
		if (validaControl(this.controllerErroSite)) {
			return this.controllerErroSite.consultarErrosPorFiltro(erroSite);
		}
		return null;
	}

	public List<ErroSite> consultarErros() throws Exception {
		if (validaControl(this.controllerErroSite)) {
			return this.controllerErroSite.consultarErros();
		}
		return null;
	}

	@Override
	public List<Comentario> consultarComentarioFiltradosIdProjt(Projeto projeto) throws Exception {
		if (validaControl(this.controllerComentario)) {
			return this.controllerComentario.consultarComentarioFiltradosIdProjt(projeto);
		}
		return null;
	}

	public void denunciarComentario(Denuncia denuncia) throws Exception {
		if (validaControl(this.controllerDenuncia)) {
			controllerDenuncia.denunciarComentario(denuncia);
		}
	}

	public Denuncia consultarDenunciaDoComentario(Denuncia denuncia) throws Exception {
		if (validaControl(controllerDenuncia)) {
			return controllerDenuncia.consultarDenuncia(denuncia);
		}
		return null;
	}

}
