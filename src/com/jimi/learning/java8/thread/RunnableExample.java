package com.jimi.learning.java8.thread;

public class RunnableExample implements Runnable {

	private final String name;
	
	public RunnableExample(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " is running!");
	}

}
