package controller;

public class ControllerVariableInt {

	private static int value;

	public int getValue() {
		System.out.println("get:" + value);
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		System.out.println("set:" + value);
	}
	
}
