package com.jimi.learning.string;

public class StringCompare {

	public static void main(String[] args) {
//		String s1 = "aaa";
//		long stringStart = System.currentTimeMillis();
//		for(int i = 0; i<100000; i++) {
//			s1 = s1 + "aaa";
//		}
//		long stringEnd = System.currentTimeMillis();
//		System.out.println("String add 100000 times cost " + (stringEnd - stringStart) + "ms");
		
		StringBuffer sBuffer = new StringBuffer();
		long sBufferStart = System.currentTimeMillis();
		for(int i = 0; i<10000000; i++) {
			sBuffer.append("aaa");
		}
		long sBufferEnd = System.currentTimeMillis();
		System.out.println("StringBuffer add 10000000 times cost " + (sBufferEnd - sBufferStart) + "ms");
		
		StringBuilder sBuilder = new StringBuilder();
		long sBuilderStart = System.currentTimeMillis();
		for(int i = 0; i<10000000; i++) {
			sBuilder.append("aaa");
		}
		long sBuilderEnd = System.currentTimeMillis();
		System.out.println("StringBuilder add 10000000 times cost " + (sBuilderEnd - sBuilderStart) + "ms");
	}

}
