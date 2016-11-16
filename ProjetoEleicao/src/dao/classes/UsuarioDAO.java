package dao.classes;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import classesBasicas.Administrador;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
import dao.DAOGenerico;
import dao.interfaces.IUsuarioDAO;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioDAO {

	private String criptografarSenha(Usuario usuario) throws Exception {
		StringBuilder senhaCriptografada = new StringBuilder();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] vetorBytes = md.digest(usuario.getSenha().getBytes("UTF8"));
		for (byte b : vetorBytes) {
			senhaCriptografada.append(String.format("%02X", 0xFF & b));
		}
		return senhaCriptografada.toString();
	}

	public boolean retornaEmail(Usuario usuario) {
		Query query = super.getManager().createQuery("SELECT u FROM Usuario u WHERE email_user = :Email",
				Usuario.class);
		query.setParameter("Email", usuario.getEmail_user());
		return query.getResultList().isEmpty();
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		usuario.setSenha(criptografarSenha(usuario));
		super.insert(usuario);
	}

	@Override
	public Usuario loginUsuario(Usuario usuario) throws Exception {

		Query query = super.getManager().createQuery("SELECT a FROM usuario a WHERE email =:email AND senha=:senha");
		query.setParameter("email", usuario.getEmail_user());
		query.setParameter("senha", usuario.getSenha());

		return (Usuario) query.getSingleResult();
	}
	
	
	public List<Usuario> consultarUsuarios() throws Exception{
		List<Usuario> usersList = new ArrayList<>();
		try {
			usersList = getManager().createQuery("SELECT usuario FROM Usuario usuario").getResultList();
			if (usersList.isEmpty()) {
				throw new Exception("Nao ha registros armazenados");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return usersList;
		
	}
	
	
	
	

}
