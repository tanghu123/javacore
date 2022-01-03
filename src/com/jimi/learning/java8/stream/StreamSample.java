package com.jimi.learning.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jimi.learning.java8.lambdat.Person;

public class StreamSample {

	public static void main(String[] args) {
		System.out.println("---------Count function-----------");
		List<Person> p = Person.createPersonList();
		System.out.println(p.stream().filter(t->t.getAge()>0).sequential().count());
		
		System.out.println("---------Max function-----------");
		Optional<Person> large = p.stream().max(Comparator.comparing(Person::getAge));
		if(large.isPresent()) {
			System.out.println(large.get().toString());
		}
		
		System.out.println("---------Min function-----------");
		Optional<Person> smallest = p.stream().min(Comparator.comparing(Person::getAge));
		if(smallest.isPresent()) {
			System.out.println(smallest.get().toString());
		}
		
		System.out.println("---------  Sort function  -----------");
		System.out.println("*********     Before      ***********");
		p.stream().forEach(t->System.out.println(t.toString()));
		System.out.println("*********     After      ***********");
		p.stream().sorted(Comparator.comparing(Person::getAge)).forEach(t->System.out.println(t.toString()));
		System.out.println("********* Sort Array by Stream ***********");
		Object[] sortP = p.stream().sorted(Comparator.comparing(Person::getAge).reversed()).toArray();
		for (Object object : sortP) {
			System.out.println(object.toString());
		}
		
		List<Person> p2 = Person.createPersonList(1000000);		
		for(int i = 0; i < 10; i ++) {
			System.out.println(p2.get(i));
		}
		System.out.println("---------  Sort Performance Start -----------");
		long startTime = System.currentTimeMillis();
		List<Person> p3 = new ArrayList<>();
		p3 = p2.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		System.out.println("---------Stream Sort cost " + (System.currentTimeMillis() - startTime));
		for(int i = 0; i < 10; i ++) {
			System.out.println(p3.get(i));
		}
		long startTime2 = System.currentTimeMillis();
		Collections.sort(p2, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		System.out.println("---------Collection Sort cost " + (System.currentTimeMillis() - startTime2));
		for(int i = 0; i < 10; i ++) {
			System.out.println(p2.get(i));
		}
		
		System.out.println("---------  Stream.of -----------");
		Stream.of("one", "two", "three", "four").filter(t->t.startsWith("t")).forEach(t-> System.out.println(t));
	}

}
