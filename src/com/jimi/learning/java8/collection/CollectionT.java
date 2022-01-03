package com.jimi.learning.java8.collection;

import java.util.Set;
import java.util.TreeSet;

public class CollectionT {

	public static void main(String[] args) {
		
		Set<String> set = new TreeSet<>();
		set.add("one");
		set.add("two");
		set.add("three");
		for(String str: set) {
			System.out.println(str);
		}
	}

}
