package dao.classesTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import classesBasicas.Candidato;
import classesBasicas.Cidade;
import classesBasicas.Estado;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import controller.ControllerCandidato;
import controller.ControllerProjeto;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;
import dao.classes.ProjetoDAO;
import facade.Facade;
import classesBasicas.Usuario;
import dao.classes.UsuarioDAO;

public class CandidatoDAOTest {

	ControllerCandidato cc = new ControllerCandidato();
	CandidatoDAO candiDAO = DAOFactory.getCandidatoDAO();
	// Facade facade = new Facade();
	Candidato candidato;
	Facade fachada;
	private List<Cidade> cidades;
	List<Candidato> lista;
	Estado estado;
	Cidade cidade;
	private List<Candidato> candidatos;
	List<Cidade> lista_Cidadde;
	Partido partido;
	Projeto projeto = new Projeto();
	ProjetoDAO projetoDAO = DAOFactory.getProjetoDAO();
	List<Projeto> lista_projeto = new ArrayList<>();
	ControllerProjeto controllerProjeto = new ControllerProjeto();

	@Before
	public void setUp() throws Exception {
		this.candidato = new Candidato();
		estado = new Estado();
		cidade = new Cidade();
		partido = new Partido();
		cidades = new ArrayList<>();
		candidatos = new ArrayList<>();

		this.cidade.setId_cid(1);
		this.estado.setId_est(1);
		this.partido.setId_part(13);

		candidato.setPartido_cand(partido);
		candidato.setEstado_cand(estado);
		candidato.setCidade_cand(cidade);

		candidato.setNome_cand("TesteNome");
		candidato.setNumero_cand(22222);
		candidato.setTipo_Cargo_cand("TesteDeputado");

	}

	// ========================================================================
	// Casos de Testes - Fluxos Principais
	// ========================================================================

	@Test
	@Ignore
	public void cadastrarCandidatoTest() throws Exception {
		try {
			this.cc.cadastrarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	// Pra testar o alterar, é necessário pegar o ID já criado no banco
	// Se colocar sem um ID válido, ele cadastrará o novo candidato.
	@Test
	@Ignore
	public void alterarCandidatoTest() throws Exception {
		try {
			candidato.setId_cand(27);
			candidato.setNome_cand("TesteNomeAlterado2");
			candidato.setNumero_cand(99991);
			candidato.setTipo_Cargo_cand("TesteDeputadoAlterado");

			this.candiDAO.alterarCandidato(candidato);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	// Necessita setar um ID válido pra remoção.
	@Test
	@Ignore
	public void removerCandidatoTest() throws Exception {
		try {
			candidato.setId_cand(72);
			this.cc.removerCandidato(candidato);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void consultarCandidatoTodos() {
		try {
			lista = new ArrayList<>();
			lista = candiDAO.consultarTodosCandidatos();
			Assert.assertEquals("Erick2", lista.get(2).getNome_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void consultarCandidatoTodosController() {
		try {
			lista = new ArrayList<>();
			lista = cc.consultarTodosCandidatos();
			assertEquals("Erick2", lista.get(2).getNome_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void selectAllCandidateFacade() {
		try {
			lista = new ArrayList<>();
			lista = cc.consultarTodosCandidatos();
			assertEquals("GlauberTest", lista.get(0).getNome_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void consultarCandidatoTodosQuantidade() {
		try {
			lista = new ArrayList<>();
			lista = candiDAO.consultarTodosCandidatos();
			assertEquals(9, lista.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void consultarCandidatoFiltradosTeste() {
		try {
			candidato = new Candidato();
			// candidato.setNome_cand("GlauberTest");
			//candidato.setNumero_cand(31);
			// candidato.getCidade_cand().setNome_cid("cidade");
			// candidato.getPartido_cand().setId_part(1);
			// candidato.getCidade_cand().setId_cid(1);
			 candidato.getEstado_cand().setId_est(1);
			// candidato.setTipo_Cargo_cand("teste");
			lista = new ArrayList<>();
			lista = candiDAO.consultarCandidatosFiltrados(candidato);
			// assertEquals("Cand", lista.get(0).getNome_cand());
			// assertEquals(5, lista.get(0).getCidade_cand().getId_cid());
			assertEquals(3, lista.get(0).getId_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	// O método retorna verdadeiro se o número passado não existir no banco.
	@Test
	public void verificaNumeroCadastro() throws Exception {
		try {
			assertEquals(true, this.candiDAO.retornaNumero(candidato));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	// ========================================================================
	// Casos de Testes - Fluxos Alterantivos ou de Exceção (validação)
	// ========================================================================

	// CADASTRAR CANDIDATO (FA E FE)

	// O método tem que da erro de exceção caso algum dos campos abaixo esteja
	// nulo.
	@Test(expected = AssertionError.class)
	public void verificaCamposObgCadastro() throws Exception {
		try {
			candidato.setNome_cand(null);
			candidato.setNumero_cand(0);
			candidato.setTipo_Cargo_cand(null);

			this.cc.cadastrarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			//e.printStackTrace();
			fail();
		}
	}

	// O método tem que da erro de exceção caso algum dos campos abaixo esteja
	// com espaços em branco.
	@Test(expected = AssertionError.class)
	public void verificaEspacosCadastro() throws Exception {
		try {
			candidato.setNome_cand("    ");
			candidato.setTipo_Cargo_cand("   ");

			this.cc.cadastrarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			//e.printStackTrace();
			fail();
		}
	}

	// O método tem que da erro de exceção caso algum dos campos abaixo esteja
	// vazio.
	@Test(expected = AssertionError.class)
	public void verificaVazioCadastro() throws Exception {
		try {
			candidato.setNome_cand("");
			candidato.setTipo_Cargo_cand("");

			this.cc.cadastrarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			//e.printStackTrace();
			fail();
		}
	}

	// ALTERAR CANDIDATO (FA E FE)

	// O método tem que da erro de exceção caso algum dos campos abaixo esteja
	// nulo.
	@Test(expected = AssertionError.class)
	public void verificaCamposObgUpdate() throws Exception {
		try {
			candidato.setId_cand(27);
			candidato.setNome_cand("");
			candidato.setNumero_cand(0);
			candidato.setTipo_Cargo_cand(null);

			this.cc.alterarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			//e.printStackTrace();
			fail();
		}
	}

	// O método tem que da erro de exceção caso algum dos campos abaixo esteja
	// com espaços em branco.
	@Test(expected = AssertionError.class)
	public void verificaEspacosUpdate() throws Exception {
		try {
			candidato.setId_cand(27);
			candidato.setNome_cand("    ");
			candidato.setTipo_Cargo_cand("   ");

			this.cc.alterarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			//e.printStackTrace();
			fail();
		}
	}

	// O método tem que da erro de exceção caso algum dos campos abaixo esteja
	// vazio.
	@Test(expected = AssertionError.class)
	public void verificaVazioUpdate() throws Exception {
		try {

			candidato.setId_cand(27);
			candidato.setNome_cand("");
			candidato.setTipo_Cargo_cand("");

			this.cc.alterarCandidato(candidato);
			String name = this.candidato.getNome_cand();
			System.out.printf(name);
		} catch (Exception e) {
			//e.printStackTrace();
			fail();
		}
	}
}
