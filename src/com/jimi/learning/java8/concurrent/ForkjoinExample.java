package com.jimi.learning.java8.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class ForkjoinExample {

	public static void main(String[] args) {
		int[] data = new int[1024*1024*256];
//		for(int i = 0; i < data.length; i++) {
//			data[i] = ThreadLocalRandom.current().nextInt();
//		}
//		int max = Integer.MIN_VALUE;
//		long begin = System.currentTimeMillis();
//		for(int value: data) {
//			if(value > max) {
//				max = value;
//			}
//		}
//		System.out.println("The max value is " + max + ". Time cost: " + (System.currentTimeMillis() - begin));
//		
//		long forkBegin = System.currentTimeMillis();
//		
//		FindMaxTask task = new FindMaxTask(data,  1, data.length-1, data.length/2);
//		
//		System.out.println("The max value is " + task.compute() + ". Time cost: " + (System.currentTimeMillis() - forkBegin));
		
		ForkJoinPool pool = new ForkJoinPool();
		RandomArrayAction action = new RandomArrayAction(data, 0, data.length-1,data.length/2);
		System.out.println(pool.invoke(action));
	}

}
