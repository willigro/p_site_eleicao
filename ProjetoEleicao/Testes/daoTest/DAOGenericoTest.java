
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
	/*
	 * Não foi utilizado um atributo do tipo DAOGenerico porque ele precisa de
	 * um tipo EntityManager que é obtido somente na instancia das subclasses.
	 */
	CandidatoDAO candiDAO;
	Candidato candidato;
	UsuarioDAO userDao;
	Usuario user;

	// public void setUp() throws Exception{
	// this.candiDAO = DAOFactory.getCandidatoDAO();
	// this.candidato = new Candidato();
	// candidato.setNome_cand("CandidatoTester");
	// candidato.setNumero_cand(123);
	// candidato.setTipo_Cargo_cand("DeputadorTester");
	// }

	@Before
	public void setUp() throws Exception {
		this.userDao = DAOFactory.getUsuarioDAO();
		// this.user = new Usuario();
		// this.user.setNome_user("UsuarioTester");
		// this.user.setSenha("senhatester");
		// this.user.setEmail_user("usuario2@emailtest.com");
		// this.user.setAtivo_user(true);
	}

	@Test
	@Ignore
	public void isertTest() throws Exception {
		try {
			candiDAO.insert(candidato);
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
	// public void updateTest() throws Exception {
	// try {
	// Candidato candidato2 = new Candidato();
	// candidato2.setId_cand(1); //Informar um ID real do banco
	// candidato2.setNome_cand("newnameUser"); //informar o valor que deve ser
	// atualizado.
	// assertEquals(candidato2, candiDAO.update(candidato2));
	// } catch (Exception e) {
	// fail();
	// }
	// }

	public void updateTest() throws Exception {
		try {
			Usuario user2 = new Usuario();
			user2.setId_user(1); // Informar um ID real do banco
			user2.setNome_user("newnameUser"); // informar o valor que deve ser
												// atualizado.
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
			assertEquals(6, userDao.select(5).getId_user());
		} catch (Exception e) {
			fail();
		}
	}

}
