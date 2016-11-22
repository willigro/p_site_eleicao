package controllerTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import classesBasicas.Projeto;
import controller.ControllerProjeto;

public class ControllerProjetoTest {

	List<Projeto> lista_projeto;
	ControllerProjeto controllerProjeto;
	
	@Before
	public void setUp(){
		this.controllerProjeto = new ControllerProjeto();
	}
	
	@Test
	public void consultarTodosProjetosController() {
		try {
			this.lista_projeto = this.controllerProjeto.consultarTodosProjetos();
			assertEquals("Fuder o Brasil", this.lista_projeto.get(0).getTitulo_proj());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
