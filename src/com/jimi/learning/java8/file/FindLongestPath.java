package com.jimi.learning.java8.file;

import java.io.File;
import java.util.Arrays;

public class FindLongestPath {

    static String longestPath = "";
    static int count = 0;

    public static void main(String[] args){

        File rootPath = new File("D:\\李燕");
        readFile(rootPath);
    }

    public static void readFile(File file){
        Arrays.stream(file.listFiles()).forEach(file1 -> {
            if(file1.isDirectory()){
                readFile(file1);
            }else if(file1.isFile()){
                count++;
                if(file1.getAbsolutePath().length() > longestPath.length()){
                    longestPath = file1.getAbsolutePath();
                    System.out.println("Count: "+ count + " Current The Longest Path is " + longestPath + " Length: " + longestPath.length());
                }
            }
        });
    }
}
