package controller.exceptions.password;

public class PasswordEmptyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordEmptyException() {
	    super("Senha vazia! Favor, Informe sua senha.");
	  }
}
