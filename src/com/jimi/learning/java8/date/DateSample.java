package com.jimi.learning.java8.date;

import java.time.*;
import static java.lang.System.out;

public class DateSample {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		out.println(now);
		
		LocalDate today = LocalDate.of(2019, 6, 19);
		out.println(today);
	}

}
