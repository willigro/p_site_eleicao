package facade;

import classesBasicas.Administrador;
import java.util.List;
import classesBasicas.Administrador;
import java.util.List;
import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public interface IFachada {

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
}
