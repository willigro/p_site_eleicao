package dao.classesTest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
import facade.Facade;

public class ComentarioTest {

	Comentario comentario;
	Candidato candidato;
	Projeto projeto;
	Usuario usuario;
	Facade fachada;
	Administrador adm;
	
	@Before
	public void setUp(){
		this.candidato = new Candidato();
		this.comentario = new Comentario();
		this.projeto = new Projeto();
		this.adm = new Administrador();
		this.usuario = new Usuario();
		this.fachada = new Facade();
		this.usuario.setId_user(1);
		this.candidato.setId_cand(1);
		this.projeto.setId_proj(1);
		this.adm.setId_admin(1);
		this.comentario.setProjeto_coment(projeto);
		this.comentario.setCandidato_coment(candidato);
		this.comentario.setUsuario_coment(usuario);
		this.comentario.setAdministrador_coment(adm);
		this.comentario.setTexto_coment("Algoritmo pra separar Projeto e Candidato");
	}
	
	@Test
	public void comentarProjeto(){
		try{
			fachada.inserirComentarioProjeto(comentario);
		}catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
