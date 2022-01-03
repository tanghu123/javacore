package com.jimi.learning.java8.concurrent;

import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1254132302223227529L;
	
	private final int threshold;
	private final int[] myArray;
	private int start;
	private int end;
	
	
	public FindMaxTask(int[] array, int start, int end, int threshold) {
		this.end = end;
		this.start= start;
		this.myArray = array;
		this.threshold = threshold;
	}

	@Override
	protected Integer compute() {
		int max = Integer.MIN_VALUE;
		if(end - start < threshold) {
			for(int value: myArray) {
				if(value > max) {
					max = value;
				}
			}
		}else {
			System.out.println("Begin to split the task!" + System.currentTimeMillis());
			int mid = (end - start)/2 + start;
			FindMaxTask t1 = new FindMaxTask(myArray, start, mid,threshold );
			t1.fork();
			FindMaxTask t2 = new FindMaxTask(myArray, mid+1, end,threshold );
			max = Math.max(t2.compute(), t1.join());
		}
		return max;
	}

}
