package com.jimi.learning.java8.concurrent;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9053819385315063790L;
	
	private int[] array;
	private int start;
	private int end;
	private int threshold;
	
	

	public RandomArrayAction(int[] array, int start, int end, int threshold) {
		super();
		this.array = array;
		this.start = start;
		this.end = end;
		this.threshold = threshold;
	}



	@Override
	protected void compute() {
		if(end - start < threshold) {
			for(int i=0; i < array.length; i++) {
				array[i] = ThreadLocalRandom.current().nextInt();
			}
		}else {
			System.out.println("Begin to split the task!" + System.currentTimeMillis());
			int mid = (end - start)/2 + start;
			RandomArrayAction a1 = new RandomArrayAction(array, start, mid,threshold );
			RandomArrayAction a2 = new RandomArrayAction(array, mid+1, end,threshold );
			invokeAll(a1, a2);
		}
		
	}

}
