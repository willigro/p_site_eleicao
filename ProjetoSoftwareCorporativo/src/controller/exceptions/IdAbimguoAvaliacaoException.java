package controller.exceptions;

public class IdAbimguoAvaliacaoException extends Exception{
	
	@Override
	public String getMessage(){
		return "Programador idota, voc� est� passando dois valores de ID";
	}
}
