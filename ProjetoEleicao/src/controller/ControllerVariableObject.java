package controller;

public class ControllerVariableObject {

	private static Object value;

	public Object getValue() {
		System.out.println("get:" + value);
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
		System.out.println("set:" + value);
	}
	
}
