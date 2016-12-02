package controller.exceptions.email;

public class InvalidEmailException extends Exception{
	public InvalidEmailException() {
	    super("E-mail invalido! Favor, Informar o email como o seguinte exemplo usuario@exemplo.com");
	  }
}
