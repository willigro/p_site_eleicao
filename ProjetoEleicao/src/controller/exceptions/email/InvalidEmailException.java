package controller.exceptions.email;

public class InvalidEmailException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidEmailException() {
	    super("E-mail invalido! Favor, Informar o email como o seguinte exemplo usuario@exemplo.com");
	  }
}
