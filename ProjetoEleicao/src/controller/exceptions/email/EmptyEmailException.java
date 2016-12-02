package controller.exceptions.email;

public class EmptyEmailException extends Exception{
	public EmptyEmailException() {
	    super("E-mail vazio! Favor, Informe um email.");
	  }
}
