package com.jimi.learning.java8.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationSample {

	public static void main(String[] args) {
		Student st = new Student(1, 18,"Jack", "Huston");
		try {
			FileOutputStream out = new FileOutputStream("configure/object.text");
			ObjectOutputStream objout = new ObjectOutputStream(out);
			objout.writeObject(st);
			objout.close();
			FileInputStream in = new FileInputStream("configure/object.text");
			ObjectInputStream objin = new ObjectInputStream(in);
			Student readSt = (Student) objin.readObject();
			System.out.println(readSt.toString());
			objin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
