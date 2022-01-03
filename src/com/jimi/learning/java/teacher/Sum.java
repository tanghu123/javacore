package com.jimi.learning.java.teacher;

public class Sum {

	static int[] nums = {8,5,1,3,4,2,7,10,0,9};
	
	public static void main(String[] args) {
		int count = 0;
		for(int i = 0; i< nums.length; i++) {
			for(int j = i +1; j < nums.length; j++) {
				count++;
//				System.out.println(nums[i] + " + " + nums[j] + " = " + (nums[i] + nums[j]) );
				if(nums[i] + nums[j] == 10) {
					System.out.println(nums[i] + " + " + nums[j] + " = 10  666666");
				}
			}
		}
		System.out.println("loop count = " + count);
		
		
	}

}
