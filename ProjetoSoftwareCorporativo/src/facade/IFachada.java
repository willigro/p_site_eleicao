package facade;

<<<<<<< HEAD
import classesBasicas.Administrador;
=======
import java.util.List;

>>>>>>> 296a9d86c2a03b95807370684ce1f2a2ae245854
import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Usuario;

public interface IFachada {

	public void cadastrarUsuario(Usuario usuario) throws Exception;

	public void inserirComentarioCandidato(Comentario comentario) throws Exception;
	
	public Comentario atualizarComentario(Comentario comentario) throws Exception;
	
	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception;


	void cadastrarCandidato(Candidato candidato) throws Exception;
	
	public Administrador loginAdministrador(Administrador administrador) throws Exception;
	
	public boolean punirUsuario(Administrador administrador) throws Exception;

	public void cadastrarCandidato(Candidato candidato) throws Exception;
	
	public void removerCandidato(Candidato candidato) throws Exception;
	
	public Candidato alterarCandidato(Candidato candidato) throws Exception;
	
	public List<Comentario> visualizarComentsDenuncia(Usuario usuario) throws Exception;


}
