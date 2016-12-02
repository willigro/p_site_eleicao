package controller.exceptions.email;

public class LimitCaracterEmailException extends Exception{
	public LimitCaracterEmailException(int value) {
	    super("O email deve conter no maximo "+value+" caracteres.");
	  }
}
