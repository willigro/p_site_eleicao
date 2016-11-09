package controller.exceptions;

public class IdAbimguoAvaliacaoException extends Exception{
	
	@Override
	public String getMessage(){
		return "Programador idota, você está passando dois valores de ID";
	}
}
