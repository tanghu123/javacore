/**
 * 
 */
package com.jimi.learning.java8.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author HuTang
 *
 */
public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5635574317171854659L;
	private int id;
	private int age;
	private String name;
	private String address;
	
	Student(int id, int age, String name, String address){
		this.id = id;
		this.age = age;
		this.name = name;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + "]";
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		setAddress("6666");
	}
	
}
