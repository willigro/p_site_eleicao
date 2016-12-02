package controller.exceptions.email;

public class LimitCaracterEmailException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public LimitCaracterEmailException(int value) {
	    super("O email deve conter no maximo "+value+" caracteres.");
	  }
}
