package facade;

import classesBasicas.Candidato;
import classesBasicas.Usuario;

public interface IFachada {
	public void insert(Candidato candidato) throws Exception;

	public void cadastrarUsuario(Usuario usuario) throws Exception;
}
