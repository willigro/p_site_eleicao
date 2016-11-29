package controller;


import classesBasicas.Comentario;
import classesBasicas.Denuncia;
import dao.DAOFactory;
import dao.interfaces.IDenunciaDAO;

public class ControllerDenuncia {
	
	private IDenunciaDAO iDenunciaDAO;
	private ControllerUsuario controllerUsuario;
	private ControllerComentario controllerComentario;
	
	public ControllerDenuncia(){
		this.iDenunciaDAO = DAOFactory.getDenunciaDAO();
		this.controllerUsuario = new ControllerUsuario();
		this.controllerComentario = new ControllerComentario();
	}
	
	public void denunciarComentario(Denuncia denuncia) throws Exception{
//		if(denuncia == null){
//			
//		}
//		if(denuncia.getUsuario() == null){
//			throw new Exception("");
//		}
//		if(controllerUsuario.consultarUsuarioPorFiltro(denuncia.getUsuario()) != null){
//			throw new Exception("");
//		}
//		
//		if(denuncia.getUsuario().getId_user() > 0){
//			throw new Exception("");
//		}
//		if(denuncia.getComentario() == null){
//			throw new Exception("");
//		}
//		if(controllerComentario.consultarComentarioPorId(denuncia.getComentario())){
//			throw new Exception("");
//		}
//		
//		if(denuncia.getComentario().getId_coment() > 0){
//			throw new Exception("");
//		}
//		if(denuncia.getComentario().getTexto_coment().isEmpty()){
//			throw new Exception("");
//		}
		
		if(iDenunciaDAO.consultarDenunciaDoComentario(denuncia) != null){
			throw new Exception("Voce nao pode denunciar mais de uma vez o mesmo comentario");
		}
		
		
		iDenunciaDAO.denunciarComentario(denuncia);
	}
	
	public void removerDenunciaComentario(Denuncia denuncia) throws Exception{
		
		if(denuncia == null){
			throw new Exception("");
		}
		if(denuncia.getUsuario() == null){
			throw new Exception("");
		}
		if(denuncia.getUsuario().getId_user() > 0){
			throw new Exception("");
		}
		if(denuncia.getComentario() == null){
			throw new Exception("");
		}
		if(denuncia.getComentario().getId_coment() > 0){
			throw new Exception("");
		}
		
		iDenunciaDAO.removerDenunciaComentario(denuncia);
	}
	
	public Denuncia consultarDenuncia(Denuncia denuncia){
		
		try {
			return iDenunciaDAO.consultarDenunciaDoComentario(denuncia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
