package com.jimi.learning.java8.utils;

import java.util.Random;

public class RangUtil {
	/***
	 * 97 - 122   lower-case character
	 * 65 - 90    capitals
	 * 33 - 126   all chars
	 */
	
	public static final char[] allChars = {'!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/','0','1','2','3','4','5','6','7','8','9',':',';','<','=','>','?',
											'@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[','\\',']','^','_','`',
											'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~'};
	
	public static final char[] allCharsWithOutNum = {'!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?',
			'@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[','\\',']','^','_','`',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~'};
	
	public static final char[] allLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static final char[] allSpeChars = {'!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?',
			'@','[','\\',']','^','_','`','{','|','}','~'};
	
	public static final Random R = new Random();
	
	static{
		System.out.println("-----    Static block Start   -----");
	}
	
	
	
	public static String getStringRange(int length) {
		StringBuffer sb = new StringBuffer();
		while(length > 0) {
			sb.append(getAnyLetter());
			length--;
		}
		return sb.toString();
	}
	
	public static char getAnyChar() {
		return allChars[R.nextInt(94)];
	}
	
	public static char getAnyLetter() {
		return allLetters[R.nextInt(52)];
	}
	
	public static char getSpecailChar() {
		return allSpeChars[R.nextInt(32)];
	}
	
	public static void main(String[] args) {
//		for(int i = 33; i< 127; i++) {
//			char c = (char) i;
//			System.out.print("'"+c + "',");
//		}
		System.out.println(allChars.length);
		System.out.println(allCharsWithOutNum.length);
		System.out.println(allLetters.length);
		System.out.println(allSpeChars.length);
		
		System.out.println(getStringRange(12000));
	}
	
	
}
