package dao.classes;

import java.security.MessageDigest;

import classesBasicas.Administrador;
import classesBasicas.Usuario;
import dao.DAOGenerico;
import dao.interfaces.IUsuarioDAO;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioDAO {

	private String criptografarSenha(Usuario usuario) throws Exception {
		StringBuilder senhaCriptografada = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] vetorBytes = md.digest(usuario.getSenha().getBytes("UTF8"));
			for (byte b : vetorBytes) {
				senhaCriptografada.append(String.format("%02X", 0xFF & b));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return senhaCriptografada.toString();
	}

	public boolean retornaEmail(Usuario usuario) {
		Query query = super.getManager().createQuery("SELECT u FROM Usuario u WHERE email_user = :Email", Usuario.class);
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
	
			return (Usuario)query.getSingleResult();
	}

}
