package facade;

import classesBasicas.Administrador;
import java.util.List;
import classesBasicas.Administrador;
import java.util.List;
import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Estado;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public interface IFachada {

	public List<Candidato> consultarCandidatosFiltrados(Candidato candidato) throws Exception;
	
	public void cadastrarUsuario(Usuario usuario) throws Exception;

	public void inserirComentarioCandidato(Comentario comentario) throws Exception;
	
	public Comentario atualizarComentario(Comentario comentario) throws Exception;
	
	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception;
	
	public Administrador loginAdministrador(Administrador administrador) throws Exception;
	
	public boolean punirUsuario(Administrador administrador) throws Exception;

	public void cadastrarCandidato(Candidato candidato) throws Exception;
	
	public void removerCandidato(Candidato candidato) throws Exception;
	
	public Candidato alterarCandidato(Candidato candidato) throws Exception;
	
	public List<Comentario> visualizarComentsDenuncia() throws Exception;

	public Usuario loginUsuario(Usuario usuario) throws Exception;

	public List<Candidato> consultarTodosCandidatos() throws Exception;
	
	public List<Projeto> consultarTodosProjetos() throws Exception;
	
<<<<<<< HEAD
	public List<Estado> consultarTodosEstado() throws Exception;
	
	public void inserirComentarioProjeto(Comentario comentario) throws Exception;
	
	public void inserirAvaliacaoProjeto(Avaliacao avaliacao) throws Exception;
=======
	public List<Usuario> consultarUsuarios() throws Exception;
>>>>>>> 73eddf695ee15dcd6bdb11199ee046bbe8562cd6
}
