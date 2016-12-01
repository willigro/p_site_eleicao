package dao.classesTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import classesBasicas.Avaliacao;
import classesBasicas.Candidato;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
import controller.ControllerAvaliacao;
import dao.DAOFactory;
import dao.interfaces.IAvaliacaoDAO;
import facade.Facade;

public class AvaliacaoTest {
	
	Avaliacao avaliacao;
	Usuario usuario;
	Projeto projeto;
	Candidato candidato;
	IAvaliacaoDAO iAvaliacaoDAO;

	@Before
	public void setUp(){
		this.avaliacao = new Avaliacao();
		this.usuario = new Usuario();
		this.projeto = new Projeto();
		this.candidato = new Candidato();
		this.iAvaliacaoDAO = DAOFactory.getAvaliacaoDAO();
		this.projeto.setId_proj(1);
		this.usuario.setId_user(2);
		this.candidato.setId_cand(11);
		this.avaliacao.setProjeto_aval(projeto);
		this.avaliacao.setNotaAvaliacao(4);
		this.avaliacao.setUsuario_aval(usuario);
		this.avaliacao.setCandidato_aval(candidato);
	}
	
	@Test
	public void avaliarProjeto(){
		try {
			//this.iAvaliacaoDAO.insert(avaliacao);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
