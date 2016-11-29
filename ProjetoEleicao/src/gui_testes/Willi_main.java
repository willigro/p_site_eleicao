package gui_testes;

import classesBasicas.Comentario;
import classesBasicas.Denuncia;
import classesBasicas.Usuario;
//import classesBasicas.Comentario;
//import classesBasicas.Denuncia;
//import classesBasicas.Usuario;
import facade.Facade;

public class Willi_main {
	public static void main(String[] args) {
		Facade fachada = new Facade();

		Denuncia denuncia = new Denuncia();
		Usuario usuario = new Usuario();
		usuario.setId_user(1);
		Comentario comentario = new Comentario();
		comentario.setId_coment(1);
		
		denuncia.setUsuario(usuario);
		denuncia.setComentario(comentario);
		
		
		try {
			fachada.consultarDenunciaDoComentario(denuncia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
