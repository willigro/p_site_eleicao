
package daoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.*;

public class DAOGenericoTest {
	UsuarioDAO userDao;
	Usuario user;

	@Before
	public void setUp() throws Exception {
		this.userDao = DAOFactory.getUsuarioDAO();
		this.user = new Usuario();
		this.user.setNome_user("UsuarioTester");
		this.user.setSenha("senhatester");
		this.user.setEmail_user("usuario2@emailtest.com");
		this.user.setAtivo_user(true);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	@Ignore
	public void isertTest() throws Exception {
		try {
			userDao.insert(user);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Ignore
	public void updateTest() throws Exception {
		try {
			Usuario user2 = new Usuario();
			user2.setId_user(7);
			user2.setNome_user("newUser");
			user2.setEmail_user("user@email.com");
			user2.setSenha("minhasenha");
			assertEquals(user2.getNome_user(), userDao.update(user2).getNome_user());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void selectTest() throws Exception {
		try {
			assertEquals("erick", userDao.select(2).getNome_user());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Ignore
	public void deleteTest() {
		try {
			this.userDao.delete(user);
		} catch (Exception e) {
			fail();
		}
	}

}
