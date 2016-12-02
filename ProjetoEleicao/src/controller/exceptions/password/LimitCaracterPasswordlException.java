package controller.exceptions.password;

public class LimitCaracterPasswordlException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LimitCaracterPasswordlException(int value) {
	    super("A senha deve conter no maximo "+value+" caracteres.");
	  }
}
