package controllerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import classesBasicas.Usuario;
import controller.ControllerUsuario;

public class ControllerUsuarioTest {
	
	ControllerUsuario control;
	Usuario user;

	@Before
	public void setUp() throws Exception {
		this.control = new ControllerUsuario();
		user = new Usuario();
		user.setEmail_user("sarah@email.com");
		user.setNome_user("Sarah");
		user.setSenha("12345678");
		user.setAtivo_user(true);
	}

	@Test(expected = AssertionError.class)
	public void cadastrarUsuarioCadastrado() {
		try {
			control.cadastrarUsuario(user);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test(expected = AssertionError.class)
	public void cadastrarSemNome(){
		try {
			this.user.setNome_user("");
			control.cadastrarUsuario(user);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test(expected = AssertionError.class)
	public void cadastrarSenhaForaParametro(){
		try {
			this.user.setSenha("1234567");
			control.cadastrarUsuario(user);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test(expected = AssertionError.class)
	public void cadastrarLimiteMaximoExcedido(){
		try {
			this.user.setEmail_user("1234567890123456789012345678901");
			control.cadastrarUsuario(user);
		} catch (Exception e) {
			fail();
		}
	}

}
