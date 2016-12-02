package controller.exceptions.name;

public class NameEmptyException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NameEmptyException() {
	    super("Nome vazio! Favor, Informe seu nome.");
	  }
}
