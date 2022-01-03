package com.jimi.learning.java8.lambdat;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.function.IntFunction;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class PersonSort {

	public static void main(String[] args) {
		List<Person> persons = Person.createPersonList();
		persons.forEach(p -> System.out.println(p));
		
		Collections.sort(persons);
		System.out.println("After sore by name");
		persons.forEach(p -> System.out.println(p));
		
		System.out.println("After sore by age");
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}});		
		persons.forEach(p -> System.out.println(p));
		
		System.out.println("Filter age >= 18");
		persons.stream().filter(p -> p.getAge() >= 18).forEach(p -> System.out.println(p));
		
		System.out.println("Filter age < 18");
		Predicate<Person> filter = (p) -> {return p.getAge() < 18;};
		persons.stream().filter(filter).forEach(Person::toString);
		
		System.out.println("Consumer Test");
		Consumer<Person> con = t -> System.out.println(t.toString());
		con.accept(persons.get(0));
		
		
		System.out.println("Apply Test");
		Function <Person, String> applyName = t -> t.getName();
		System.out.println(applyName.apply(persons.get(0)));
		
		System.out.println("ToInt  Test");
		ToIntFunction<Person> toInt = t -> t.getAge();
		System.out.println(toInt.applyAsInt(persons.get(0)));
		
		System.out.println("IntFunction  Test");
		IntFunction<Integer> intFunction = t->t*3;
		System.out.println(intFunction.apply(7));
		
		System.out.println("BiPredicate  Test");
		BiPredicate<Person, String> biPre = (t,s) -> t.getAddress().equalsIgnoreCase(s);
		for(Person p: persons) {
			if(biPre.test(p, "Zao Yang")) {
				System.out.println(p);
			}
		}
		
		System.out.println("UnaryOperator  Test");
		UnaryOperator<String> toUpper = t -> t.toUpperCase();
		System.out.println(toUpper.apply("AAAaas8daf"));
		
		System.out.println("Stream Map Test");
		persons.stream().peek(con).map(t->t.getAge()).forEach(age -> System.out.println(age));
	}

}
