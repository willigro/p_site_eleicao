package dao.interfaces;

import java.util.ArrayList;

import java.util.List;
import classesBasicas.Administrador;
import classesBasicas.Candidato;
import classesBasicas.Comentario;
import classesBasicas.Partido;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

public interface IAdministradorDAO {
	
	//public boolean insertAdministrador(Administrador administrador);
		//public boolean deleteAdministrador(Administrador administrador);
		//public Administrador updateAdministrador(Administrador administrador);
		
		
		
		public Administrador loginAdministrador(String email,String senha) throws Exception; //ok
		public boolean logoutAdministrador(Administrador administrador) throws Exception; //ok
		public boolean verificarIdExistenteAdministrador(int id) throws Exception; //ok
		
		
		//Permissões do adm
		
		public boolean deleteUsuario(int id) throws Exception;
		public boolean punirUsuario(Usuario usuario) throws Exception; //ok
		public Usuario selectUsuario(int id) throws Exception;
		public List listTodosUsuarios(ArrayList<Usuario> usuarios) throws Exception;
				
		public List listComentariosUsuario(ArrayList<Comentario> comentarios) throws Exception;
		public boolean deleteTodosComentarios(ArrayList<Comentario> comentarios) throws Exception;
		public boolean deleteComentario(Comentario comentario) throws Exception;
		public boolean updateComentario(Comentario comentario) throws Exception; //ok
		
		//Candidato
		public boolean insert(Candidato candidato) throws Exception;
		public boolean delete(Candidato candidato) throws Exception;
		public Candidato update(Candidato candidato) throws Exception;
		public List<Candidato> listCandidato() throws Exception;
		
		public boolean insertPartido(Partido partido) throws Exception;
		public boolean deletePartido(Partido partido) throws Exception;
		public List listPartidos(ArrayList<Partido> partidos) throws Exception;
		
		// Bases Projeto
		public boolean insertProjeto(Projeto projeto);
		public boolean updateProjeto(Projeto projeto);
		public boolean deleteProjeto(Projeto projeto);
		public List listProjetos();

}