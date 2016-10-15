package facade;

import controller.*;
import classesBasicas.Candidato;
import classesBasicas.Usuario;

public class Facade implements IFachada {

	private ControllerExemple controlExp;
	private ControllerCandidato controlCand;
	private ControllerUsuario controllerUsuario;

	public Facade() {
		controlExp = new ControllerExemple();
		controlCand = new ControllerCandidato();
		this.controllerUsuario = new ControllerUsuario();
	}

	@Override
	public void insert(Candidato candidato) throws Exception {
		controlCand.insert(candidato);
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) throws Exception {
		try {
			this.controllerUsuario.cadastrarUsuario(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
