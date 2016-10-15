package facade;

import controller.*;
import classesBasicas.Candidato;

public class Facade implements IFachada{

	private ControllerExemple controlExp;
	private ControllerCandidato controlCand;
	
	public Facade() {
		 controlExp = new ControllerExemple();
		 controlCand = new ControllerCandidato();	 
	}

	@Override
	public void insert(Candidato candidato) throws Exception {
		controlCand.insert(candidato);
	}
}
