package dao.classesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
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
	Facade facade = new Facade();
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

		candidato.setNome_cand("GlauberTest");
		candidato.setNumero_cand(12345);
		candidato.setTipo_Cargo_cand("DeputadorTester");

		// partido = new Partido();
		// partido.setNome_part("Analistas Desenvolvedores de Surubas");
		// partido.setSigla_part("ADS");
		// candidato.setPartido_cand(partido);

		// lista = new ArrayList<Candidato>();
		// lista.add(candidato);
		// partido.setLista_Candidato_part(lista);
		//
		// this.estado = new Estado();
		// estado.setLista_Candidato_est(lista);
		// estado.setNome_est("Pernambuco");
		// estado.setSigla_est("PE");
		//
		// lista_Cidadde = new ArrayList<>();
		// lista_Cidadde.add(cidade);
		// estado.setLista_Cidade_est(lista_Cidadde);
		// candidato.setEstado_cand(estado);
		//
		// this.cidade = new Cidade();
		// candidato.setCidade_cand(cidade);
		// cidade.setNome_cid("Recife");
		// cidade.setEstado_cid(estado);

	}

	@After
	public void limparObjeto() throws Exception {
		candidato = null;
	}

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

	// O método retorna verdadeiro se o número passado não existir no banco.
	@Test
	@Ignore
	public void retornaNumeroTest() throws Exception {
		try {
			assertEquals(true, this.candiDAO.retornaNumero(candidato));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Ignore
	public void consultarCandidatoTodos() {
		try {
			lista = new ArrayList<>();
			lista = candiDAO.consultarTodosCandidatos();
			Assert.assertEquals("CandidatoTester", lista.get(2).getNome_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Ignore
	public void consultarCandidatoTodosController() {
		try {
			lista = new ArrayList<>();
			lista = cc.consultarTodosCandidatos();
			assertEquals("CandidatoTester", lista.get(2).getNome_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void selectAllCandidateFacade() {
		try {
			lista = new ArrayList<>();
			lista = facade.consultarTodosCandidatos();
			assertEquals("GlauberTest", lista.get(0).getNome_cand());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Ignore
	public void consultarCandidatoTodosQuantidade() {
		try {
			lista = new ArrayList<>();
			lista = candiDAO.consultarTodosCandidatos();
			assertEquals(1, lista.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void consultarCandidatoFiltradosTeste() {
		try {
			// candidato.setNome_cand("CandidatoTester");
			lista = new ArrayList<>();
			lista = candiDAO.consultarCandidatosFiltrados(candidato);
			assertEquals("CandidatoTester", lista.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void consultarTodosProjetos() {
		try {
			lista_projeto = projetoDAO.consultarTodosProjetos();
			assertEquals("ProjetoTeste", lista_projeto.get(0).getTitulo_proj());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Ignore
	public void consultarTodosProjetosController() {
		try {
			lista_projeto = controllerProjeto.consultarTodosProjetos();
			assertEquals("ProjetoTeste", lista_projeto.get(0).getTitulo_proj());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Ignore
	public void consultarTodosProjetosFachada() {
		try {
			lista_projeto = facade.consultarTodosProjetos();
			assertEquals("ProjetoTeste", lista_projeto.get(0).getTitulo_proj());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			fail();
		}
	}

}
