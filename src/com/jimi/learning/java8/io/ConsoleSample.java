package com.jimi.learning.java8.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleSample {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();
			while (input != null) {
				System.out.println(input);
				if(input.equals("exit")) {
					System.out.println("Exiting");
					System.exit(0);
				}
				input = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
