package dao.classesTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import classesBasicas.Candidato;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;

public class CandidatoDAOTest {

	CandidatoDAO candiDAO;
	Candidato candidato;

	@Before
	public void setUp() throws Exception {
		this.candidato = new Candidato();
		candidato.setNome_cand("CandidatoTester");
		candidato.setNumero_cand(123);
		candidato.setTipo_Cargo_cand("DeputadorTester");
		this.candiDAO = DAOFactory.getCandidatoDAO();
	}
	
	@Test
	@Ignore
	public void cadastrarCandidatoTest() throws Exception {
		try {
			candiDAO.cadastrarCandidato(candidato);
		} catch (Exception e) {
			fail();
		}
	}
	
	// O método retorna verdadeiro se o número passado não existir no banco.
	@Test
	public void retornaNumeroTest() throws Exception {
		try {
			assertEquals(true, this.candiDAO.retornaNumero(candidato));
		} catch (Exception e) {
			fail();
		}
	}

}
