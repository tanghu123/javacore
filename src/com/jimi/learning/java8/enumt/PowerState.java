package com.jimi.learning.java8.enumt;

public enum PowerState {
	ON("The Compuer is running!"),
	OFF("The Compuer is down!"),
	SUSPENDED("The Compuer is hanging!");
	
	private String description;
	private PowerState(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public static void main(String[] args) {
//		PowerState p = new PowerState();
		System.out.println(PowerState.ON.getDescription());
		System.out.println(PowerState.SUSPENDED.getDescription());
	}
}