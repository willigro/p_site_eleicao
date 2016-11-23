package suiteTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import controllerTest.ControllerAvaliacaoTest;
import controllerTest.ControllerProjetoTest;
import controllerTest.ControllerUsuarioTest;
import dao.classes.UsuarioDAO;
import dao.classesTest.AvaliacaoTest;
import dao.classesTest.CandidatoDAOTest;
import dao.classesTest.ComentarioTest;
import dao.classesTest.ProjetoTest;
import dao.classesTest.UsuarioDAOTest;
import daoTest.DAOGenericoTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   ControllerAvaliacaoTest.class,
   ControllerProjetoTest.class,
   ControllerUsuarioTest.class,
   AvaliacaoTest.class,
   ComentarioTest.class,
   ProjetoTest.class,
   UsuarioDAOTest.class,
   DAOGenericoTest.class,
   CandidatoDAOTest.class
})

public class EleicaoTestSuite {

}
