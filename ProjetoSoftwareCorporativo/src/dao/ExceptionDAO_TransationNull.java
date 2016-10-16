package dao;

public class ExceptionDAO_TransationNull extends Exception {
	
	public ExceptionDAO_TransationNull() {
		super();
	}
	
	@Override
	public String toString(){
		return "Transaction null"; 
	}
	
	@Override
	public String getMessage(){
		return "Transaction null";
	}
}
