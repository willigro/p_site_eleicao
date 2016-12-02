package controller.exceptions.email;

public class DatabaseAliveEmailException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DatabaseAliveEmailException() {
	    super("O email informado ja consta cadastrado, faca login.");
	  }
}
