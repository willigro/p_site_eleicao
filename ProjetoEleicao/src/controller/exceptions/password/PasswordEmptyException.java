package controller.exceptions.password;

public class PasswordEmptyException extends Exception{
	public PasswordEmptyException() {
	    super("Senha vazia! Favor, Informe sua senha.");
	  }
}
