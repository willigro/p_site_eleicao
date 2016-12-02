package controller.exceptions.account;

public class AccountDisabledException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AccountDisabledException() {
	    super("Nao sera possivel realizar login por que sua conta encontra-se desabilitada.");
	  }
}
