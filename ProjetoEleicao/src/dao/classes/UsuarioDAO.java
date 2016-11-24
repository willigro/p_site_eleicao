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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

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
	
	private void addRestrictionIfNotNull(Criteria criteria, String propertyName, int id) {
		/**
		 * Object value > int id
		 */
		if (id > 0) {
			criteria.add(Restrictions.eq(propertyName, id));
		}
	}
	
	public List<Usuario> consultarUsuarioPorFiltro(Usuario usuario) throws Exception{
		
		Session session = (Session) getManager().getDelegate();
		Example cidadeExample = Example.create(usuario).excludeZeroes();
		Criteria criteria = session.createCriteria(Usuario.class).add(cidadeExample);
		addRestrictionIfNotNull(criteria, "usuario.id_user", usuario.getId_user());
		
		
		List<Usuario> usersList = new ArrayList<>();
		
		
		
//		try {
//			Query query = getManager().createQuery("SELECT usuario FROM Usuario usuario WHERE nome_user:Nome",Usuario.class);
//			query.setParameter("Nome", usuario.getNome_user());
//			
			usersList = criteria.list();//query.getResultList();
			if (usersList.isEmpty()) {
				throw new Exception("Nao ha registros armazenados");
			}else{
				return usersList;
			}
			
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
	}
	
	public void banirUsuario(Usuario usuario) throws Exception {
		System.out.println("entrou no dao");
		super.update(usuario);
	}
	
	public boolean consultarStatusUsuarioBanido(Usuario usuario) throws Exception{
		return true;
	}
	

}
