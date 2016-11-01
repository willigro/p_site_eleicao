package dao.classesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import classesBasicas.Candidato;
import classesBasicas.Cidade;
import classesBasicas.Estado;
import classesBasicas.Partido;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;

public class CandidatoDAOTest {

	CandidatoDAO candiDAO = DAOFactory.getCandidatoDAO();;
	Candidato candidato;
	List<Candidato> lista;
	Estado estado;
	Cidade cidade;
	List<Cidade> lista_Cidadde;
	Partido partido;
	@Before
	public void setUp() throws Exception {
		this.candidato = new Candidato();
		candidato.setNome_cand("CandidatoTester");
		candidato.setNumero_cand(13);
		candidato.setTipo_Cargo_cand("DeputadorTester");
		partido = new Partido();
		partido.setNome_part("Analistas Desenvolvedores de Surubas");
		partido.setSigla_part("ADS");
		candidato.setPartido_cand(partido);
		lista = new ArrayList<Candidato>();
		lista.add(candidato);
		partido.setLista_Candidato_part(lista);
		this.estado = new Estado();
		estado.setLista_Candidato_est(lista);
		estado.setNome_est("Pernambuco");
		estado.setSigla_est("PE");
		lista_Cidadde = new ArrayList<>();
		lista_Cidadde.add(cidade);
		estado.setLista_Cidade_est(lista_Cidadde);
		candidato.setEstado_cand(estado);
		this.cidade = new Cidade();
		candidato.setCidade_cand(cidade);
		cidade.setNome_cid("Recife");
		cidade.setEstado_cid(estado);
	}
	
	@Test
	public void cadastrarCandidatoTest() throws Exception {
		try {
			candiDAO.cadastrarCandidato(candidato);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	// O método retorna verdadeiro se o número passado não existir no banco.
	@Test
	public void retornaNumeroTest() throws Exception {
		try {
			assertEquals(true, this.candiDAO.retornaNumero(candidato));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void consultarCandidatoTodosTeste(){
		try{
		lista = new ArrayList<>();
		lista = candiDAO.consultarTodosCandidatos();
		Assert.assertEquals("CandidatoTester", lista.get(0).getNome_cand());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void consultarCandidatoTodosQuantidadeTeste(){
		try{			
			lista = new ArrayList<>();
			lista = candiDAO.consultarTodosCandidatos();
			assertEquals(1,lista.size());
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test
	@Ignore
	public void consultarCandidatoFiltradosTeste() {
		try {
			//candidato.setNome_cand("CandidatoTester");
			lista = new ArrayList<>();
			lista = candiDAO.consultarCandidatosFiltrados(candidato);
			assertEquals("CandidatoTester", lista.get(0));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
