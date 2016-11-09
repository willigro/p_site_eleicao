
package daoTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import classesBasicas.Candidato;
import classesBasicas.Usuario;
import dao.DAOFactory;
import dao.classes.*;

public class DAOGenericoTest {
	CandidatoDAO candiDAO;
	Candidato candidato;
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

	@Test
	@Ignore
	public void isertTest() throws Exception {
		try {
			userDao.insert(user);
		} catch (Exception e) {
			fail();
		}
	}

	/*
	 * Para esse teste é necessário consultar o banco e verificar o ID de Algum
	 * usuario já cadastrado. O update utilizar o ID para atualizar as
	 * informações.
	 */

	@Test
	@Ignore
	public void updateTest() throws Exception {
		try {
			Usuario user2 = new Usuario();
			user2.setId_user(3); // Informar um ID real do banco
			user2.setNome_user("newUser"); // informar o valor que deve ser atualizado.
			user2.setEmail_user("user@email.com");
			user2.setSenha("minhasenha");
			assertEquals(user2.getNome_user(), userDao.update(user2).getNome_user());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Ignore
	public void selectTest() throws Exception {
		try {
			assertEquals(6, userDao.select(2).getNome_user());
		} catch (Exception e) {
			fail();
		}
	}

}
