package com.jimi.learning.java8.anointernal;

public class HelloWorld implements GreetingService {

	@Override
	public void sayMessage(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		GreetingService greet = new HelloWorld();
		greet.sayMessage("66666666666");
		GreetingService greetInter = new HelloWorld() {
			@Override
			public void sayMessage(String message) {
				System.out.println("Internal Class " + message);
			}
		};
		greetInter.sayMessage("8888888");
		
	}

}
