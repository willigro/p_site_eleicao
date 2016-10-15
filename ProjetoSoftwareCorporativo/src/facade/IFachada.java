package facade;

import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Usuario;

public interface IFachada {
	public void insert(Candidato candidato) throws Exception;

	public void cadastrarUsuario(Usuario usuario) throws Exception;

	public void inserirComentarioCandidato(Comentario comentario) throws Exception;
	
	public Comentario atualizarComentario(Comentario comentario) throws Exception;
	
	public void inserirAvaliacaoCandidato(Avaliacao avaliacao) throws Exception;
}
