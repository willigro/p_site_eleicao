package facade;

import dao.classes.CandidatoDAO;
import dao.classes.ExempleDAO;

public interface IFachada {
	public void insert(ExempleDAO exempleDAO);

	public void insert(CandidatoDAO candidatoDAO);
}
