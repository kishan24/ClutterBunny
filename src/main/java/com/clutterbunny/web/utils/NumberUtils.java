package com.clutterbunny.web.utils;

import java.util.Random;

public class NumberUtils {

	public static String generateMobileNumber() {
		long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		return String.valueOf(number);
	}
	
	public static String generateSimNumber() {
		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 32; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
	
	public static String generate12DigitLength() {
		long number = (long) Math.floor(Math.random() * 900000000000L) + 100000000000L;
		return String.valueOf(number);
	}
	
	public static int median(int a, int b, int c) {
	    if ( (a - b) * (c - a) >= 0 ) // a >= b and a <= c OR a <= b and a >= c
	        return a;
	    else if ( (b - a) * (c - b) >= 0 ) // b >= a and b <= c OR b <= a and b >= c
	        return b;
	    else
	        return c;
	}
	
}
