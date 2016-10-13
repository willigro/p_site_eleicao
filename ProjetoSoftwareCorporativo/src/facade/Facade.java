package facade;

import controller.*;
import dao.classes.*;

public class Facade implements IFachada{

	private ControllerExemple controlExp;
	private ControllerCandidato controlCand;
	
	public Facade() {
		 controlExp = new ControllerExemple();
		 controlCand = new ControllerCandidato();	 
	}
	
	@Override
	public void insert(ExempleDAO exempleDAO) {
		controlExp.insert(exempleDAO);
	}

	@Override
	public void insert(CandidatoDAO candidatoDAO) {
		controlCand.insert(candidatoDAO);
	}
}
