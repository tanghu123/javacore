package com.jimi.learning.java8.concurrent;

import java.util.concurrent.atomic.*;

public class AtomicSample{

	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger(5);
		ai.incrementAndGet();
		System.out.println(ai.getAndIncrement());
		System.out.println(ai);
	}

}
