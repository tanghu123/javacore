package com.jimi.learning.java8.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadTest
{
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i = 0; i < 10; i++) {
			es.execute(new RunnableExample("Runable "+i));
		}
		Future<String> fu = es.submit(new CallableExample("Callable"));
		es.shutdown();
		try {
			es.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(fu.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
}
