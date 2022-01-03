package com.jimi.learning.java8.thread;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<String> {

	private final String name;
	
	public CallableExample(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		return name + " is called!";
	}

}
