package me.fabricionogueira.api.modules.tests.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Generate {

	public static Long value() {
		long value = new Random().nextLong();
		if (value < 0) {
			value++;
		}
		return Math.abs(value);
	}

	public static String value(Integer length) {
		return RandomStringUtils.randomAlphanumeric(new Random().nextInt(checkLength(length)));
	}

	public static String email(Integer length) {
		return value(checkLength(length)) + "@" + value(checkLength(length)) + ".com";
	}

	public static boolean active() {
		final int value = new Random().nextInt();
		return value % 2 == 0;
	}

	private static Integer checkLength(Integer length) {
		return length != null && length > 0 ? length : 3;
	}
}
