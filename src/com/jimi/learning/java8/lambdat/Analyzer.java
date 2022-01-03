package com.jimi.learning.java8.lambdat;

public class Analyzer implements StringAnalyzer {

	@Override
	public boolean analyze(String source, String search) {
			return source.contains(search);		
	}
	
	public static void main(String[] args) {
		StringAnalyzer analyzer = (t,s) -> t.contains(s);
		String[] sourcList = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		String searchStr = "Thur";
		System.out.println("Search " + searchStr);
		
		for(String currentStr: sourcList) {
			if(analyzer.analyze(currentStr, searchStr)) {
				System.out.println(currentStr);
			}
		}		
	}

}
