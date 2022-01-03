package com.jimi.learning.java8.nio;

import java.nio.file.*;

public class PathSample {

	public static void main(String[] args) {
		Path p1 = Paths.get("/configure/FileWriter.text");
		System.out.format("File name %s%n", p1.getFileName());
		System.out.format("File name count %s%n", p1.getNameCount());
		System.out.format("File parent %s%n", p1.getParent());
		System.out.format("File root %s%n", p1.getRoot());
		System.out.format("File isAbsolute %s%n", p1.isAbsolute());
	}
}
