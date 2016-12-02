package controller.exceptions.email;

public class EmptyEmailException extends Exception{


	private static final long serialVersionUID = 1L;
	
	public EmptyEmailException() {
	    super("E-mail vazio! Favor, Informe um email.");
	  }
}
