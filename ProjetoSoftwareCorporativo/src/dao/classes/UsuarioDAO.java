package dao.classes;

import java.security.MessageDigest;

import classesBasicas.Usuario;
import dao.DAOGenerico;
import dao.interfaces.IUsuarioDAO;

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
	
	@Override
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		usuario.setSenha(criptografarSenha(usuario));
		super.insert(usuario);
	}

}
