package com.jimi.learning.java8.date;

import java.time.*;

public class DateTimeSample {
	public static void main(String[] args) {
		ZoneId zone = ZoneId.of("UTC+8");
		ZonedDateTime bjTime = ZonedDateTime.now(zone);
		System.out.println(bjTime);
	}
}
