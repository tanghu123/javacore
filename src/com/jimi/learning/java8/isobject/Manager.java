package com.jimi.learning.java8.isobject;

public class Manager extends Employee {
	public static void main(String[] args) {
		Employee e = new Employee();
		Manager m = new Manager();
		System.out.println(getBouns(e));
		System.out.println(getBouns(m));
	}

	public static double getBouns(Employee emp) {
		if (emp instanceof Manager)
			return 0.3;

		else
			return 0.1;
	}

}
