package controller.exceptions.name;

public class LimitCaracterNameException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LimitCaracterNameException(int value) {
	    super("O nome deve conter no maximo "+value+" caracteres.");
	  }
}
