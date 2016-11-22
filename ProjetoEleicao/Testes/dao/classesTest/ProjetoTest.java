package dao.classesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import dao.DAOFactory;
import dao.interfaces.IProjetoDAO;
import facade.Facade;
import classesBasicas.Projeto;
import controller.ControllerProjeto;

public class ProjetoTest {

	List<Projeto> lista_projeto;
	IProjetoDAO iProjetoDAO;
	ProjetoTest projeto;
	ControllerProjeto controllerProjeto;
	Facade facade;

	@Before
	public void setUp() {
		//this.lista_projeto = new ArrayList<Projeto>();
		this.facade = new Facade();
		this.controllerProjeto = new ControllerProjeto();
		this.projeto = new ProjetoTest();
		this.iProjetoDAO = DAOFactory.getProjetoDAO();
	}

	@Test
	//@Ignore
	public void consultarTodosProjetos() {
		try {
			this.lista_projeto = this.iProjetoDAO.consultarTodosProjetos();
			assertEquals("Fuder o Brasil", this.lista_projeto.get(0).getTitulo_proj());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	//@Ignore
	public void consultarTodosProjetosFachada() {
		try {
			this.lista_projeto = this.facade.consultarTodosProjetos();
			assertEquals("Fuder o Brasil", this.lista_projeto.get(0).getTitulo_proj());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			fail();
		}
	}
}
