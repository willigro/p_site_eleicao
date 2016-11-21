package dao.classesTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.UsuarioDAO;

public class UsuarioDAOTest {

	UsuarioDAO userDao;
	Usuario usuario;

	@Before
	public void setUp() throws Exception {
		this.usuario = new Usuario();
		usuario.setNome_user("Sarah");
		usuario.setSenha("12345678");
		usuario.setEmail_user("sarah@email.com");
		usuario.setAtivo_user(true);
		this.userDao = DAOFactory.getUsuarioDAO();
	}

	@Test
	@Ignore
	public void cadastrarUsuarioTest() throws Exception {
		try {
			userDao.cadastrarUsuario(usuario);
		} catch (Exception e) {
			fail();
		}
	}

	// O método retorna verdadeiro se o email passado não existir no banco.
	@Test
	@Ignore
	public void retornaEmailTest() throws Exception {
		try {
			assertEquals(false, this.userDao.retornaEmail(usuario));
		} catch (Exception e) {
			fail();
		}
	}

	/*
	 * O método verifica se a senha, depois de criptografada, contém 32
	 * caracteres. É necessário informar o ID de algum usuario já cadastrado no
	 * banco.
	 */
	@Test
	@Ignore
	public void criptografarSenhaTest() throws Exception {
		try {
			int retorno = this.userDao.select(1).getSenha().length();
			assertEquals(32, retorno);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
