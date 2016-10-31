package dao.testes;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classesBasicas.Candidato;
import dao.DAOFactory;
import dao.classes.CandidatoDAO;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class Test_CandidatoDAO {

	Candidato cand = new Candidato();
	CandidatoDAO c = DAOFactory.getCandidatoDAO();
	List<Candidato> lista;
	
	@Before
	public void inicializar() {
	}

	@Test
	public void consultarCandidatoTodosTeste(){
		try{
		cand.setNome_cand("Fulano");
		lista = new ArrayList<>();
		lista = c.consultarTodosCandidatos();
		Assert.assertEquals("Fulano", lista.get(0).getNome_cand());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void consultarCandidatoTodosQuantidadeTeste(){
		try{			
			lista = new ArrayList<>();
			lista = c.consultarTodosCandidatos();
			Assert.assertEquals(2,lista.size());
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void consultarCandidatoFiltradosTeste() {
		try {
			cand.setNome_cand("Fulano");
			lista = new ArrayList<>();
			lista = c.consultarCandidatosFiltrados(cand);
			Assert.assertEquals("Fulano", lista.get(0));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
