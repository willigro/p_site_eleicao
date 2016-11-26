package dao.classes;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import classesBasicas.Usuario;
import dao.DAOGenerico;
import dao.interfaces.IUsuarioDAO;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mysql.jdbc.StringUtils;


public class UsuarioDAO extends DAOGenerico<Usuario> implements IUsuarioDAO {

	private String criptografarSenha(String senha) throws Exception {
		StringBuilder senhaCriptografada = new StringBuilder();
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] vetorBytes = md.digest(senha.getBytes("UTF8"));
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
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		super.insert(usuario);
	}

	@Override
	public Usuario loginUsuario(Usuario usuario) throws Exception {

		Query query = super.getManager().createQuery("SELECT a FROM Usuario a WHERE email_user =:email AND senha=:senha");
		query.setParameter("email", usuario.getEmail_user());
		query.setParameter("senha", criptografarSenha(usuario.getSenha()));
		System.out.println("" + query.toString());
		return (Usuario) query.getSingleResult();
	}

	public List<Usuario> consultarUsuarios() throws Exception {
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



	public List<Usuario> consultarUsuarioPorFiltro(Usuario usuario) throws Exception {
	
		List<Usuario> usersList = new ArrayList<>();

		try {
			
			Query query = getManager().createQuery("SELECT u FROM Usuario u WHERE nome_user =:Nome",Usuario.class);
			query.setParameter("Nome",usuario.getNome_user());

			usersList = (List<Usuario>) query.getResultList();
			
			if (usersList.isEmpty()) {
				throw new Exception("Nao ha registros armazenados");
			} else {
				return usersList;
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void banirUsuario(Usuario usuario) throws Exception {
		super.update(usuario);
	}

	public Usuario consultarUsuarioBanido(Usuario usuario) throws Exception {
	

		Query query = getManager().createQuery("SELECT u FROM Usuario u WHERE id_user =:Id",Usuario.class);
		query.setParameter("Id",usuario.getId_user());
		
		Usuario usuario0;

		usuario0 = (Usuario) query.getSingleResult();
		
		if(usuario0 !=null){
				return usuario0;
		}
		return null;
	}


}
