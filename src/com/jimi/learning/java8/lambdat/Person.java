package com.jimi.learning.java8.lambdat;

import java.util.ArrayList;
import java.util.List;

import com.jimi.learning.java8.utils.RangUtil;

public class Person implements Comparable<Person>{
	private int id;
	private String name;
	private int age;
	private String address;
	public Person(int id, String name, int age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		//System.out.println("toString is invoked.");
		return "Person content information: ID = " + id + ", name = " + name + ", age = " + age + ", address = " + address;
	}
	
	public static class Builder{
		private int id;
		private String name;
		private int age;
		private String address;
		public int getId() {
			return id;
		}
		public Builder setId(int id) {
			this.id = id;
			return this;
		}
		public String getName() {
			return name;
		}
		public Builder(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		public String getAddress() {
			return address;
		}
		public Builder setAddress(String address) {
			this.address = address;
			return this;
		}
		public Person build() {
			return new Person(id, name, age, address);
		}
	}
	
	public static List<Person> createPersonList(){
		List<Person> persons = new ArrayList<>();
		persons.add(new Builder("Tang").setId(1).setAge(33).setAddress("Zao Yang").build());
		persons.add(new Builder("Li").setId(2).setAge(18).setAddress("Zao Yang").build());
		persons.add(new Builder("Yang").setId(3).setAge(7).setAddress("Zao Yang").build());
		return persons;
	}
	
	public static List<Person> createPersonList(int count){
		List<Person> persons = new ArrayList<>();
		while(count > 0) {
			persons.add(new Builder(RangUtil.getStringRange(8)).setId(count).setAge(RangUtil.R.nextInt(100)).setAddress(RangUtil.getStringRange(20)).build());
			count--;
		}
		return persons;
	}
	
	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.getName());
	}
}
