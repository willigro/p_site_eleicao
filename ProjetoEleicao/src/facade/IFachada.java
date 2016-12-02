package facade;

import classesBasicas.Administrador;
import java.util.List;
import classesBasicas.Administrador;
import java.util.List;
import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
import classesBasicas.Cidade;
import classesBasicas.Comentario;
import classesBasicas.Denuncia;
import classesBasicas.ErroSite;
import classesBasicas.Estado;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public interface IFachada {

	/*
	 * Responsavel por realizar o login do administrador 
	 */
	public Administrador loginAdministrador(Administrador administrador) throws Exception;
	
	
	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception;
	
	public void cadastrarUsuario(Usuario usuario) throws Exception;

	public void inserirComentarioCandidato(Comentario comentario) throws Exception;
	
	public Comentario atualizarComentario(Comentario comentario) throws Exception;
	
	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception;
	
	public void cadastrarCandidato(Candidato candidato) throws Exception;
	
	public void removerCandidato(Candidato candidato) throws Exception;
	
	public void alterarCandidato(Candidato candidato, Candidato oldCand) throws Exception;
	
	public List<Comentario> visualizarComentsDenuncia() throws Exception;

	public Usuario loginUsuario(Usuario usuario) throws Exception;

	public List<Candidato> consultarTodosCandidatos() throws Exception;
	
	public List<Projeto> consultarTodosProjetos() throws Exception;
	
	public List<Projeto> consultarProjetosFiltradosIdCand(Projeto projeto) throws Exception;
	
	public List<Estado> consultarTodosEstado() throws Exception;
	
	public List<Cidade> consultarTodasCidade() throws Exception;
	
	public List<Cidade> consultarCidadeFiltrada(Cidade cidade) throws Exception;
	
	public void inserirComentarioProjeto(Comentario comentario) throws Exception;
	
	public void inserirAvaliacaoProjeto(Avaliacao avaliacao) throws Exception;

	public List<Usuario> consultarUsuarios() throws Exception;
	
	public List<Partido> consultarTodosPartidos() throws Exception;
	
	public void banirUsuario(Usuario usuario) throws Exception;
	
    public boolean consultarStatusUsuarioBanido(Usuario usuario) throws Exception;
    
    public void armazenarVariavel(Object value) throws Exception;
    
    public Object retornarVariavel() throws Exception;

	public void denunciarComentario(Comentario comentario) throws Exception;
	
	public List<Denuncia> consultarDenunciaDoComentario() throws Exception;
	
	public List<Comentario> consultarComentarioFiltradosIdProjt(Projeto projeto) throws Exception;

	/*
	 * Responsavel por denunciar um comentario de um usuario especifico 
	 */
	public void denunciarComentario(Denuncia denuncia) throws Exception;
	
	/*
	 * Responsavel por consultar erros do sistemas reportado por usuarios 
	 */
	public List<ErroSite> consultarErros() throws Exception;
	
	public void removerComent(Comentario comentario) throws Exception;
	
	

}
