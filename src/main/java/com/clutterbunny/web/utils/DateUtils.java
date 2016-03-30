package com.clutterbunny.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private final static SimpleDateFormat short_format = new SimpleDateFormat("MM/dd/yyyy");
	
	public static Date parseShort(String value) {
		try {
			return short_format.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatShortDate(Date d) {
		if(d == null) return "";
		return short_format.format(d);
	}
	
	
	public static boolean isDateEquals(Date one, Date two) {
		if(one != null && two != null) {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(one);
			c1.set(Calendar.HOUR_OF_DAY, 0);
			c1.set(Calendar.MINUTE, 0);
			c1.set(Calendar.SECOND, 0);
			c1.set(Calendar.MILLISECOND, 0);
			
			
			Calendar c2 = Calendar.getInstance();
			c2.setTime(two);
			c2.set(Calendar.HOUR_OF_DAY, 0);
			c2.set(Calendar.MINUTE, 0);
			c2.set(Calendar.SECOND, 0);
			c2.set(Calendar.MILLISECOND, 0);
				
			return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) 
					&& c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
					&& c1.get(Calendar.DATE) == c2.get(Calendar.DATE);
		}
		return false;
	}
	
	public static String getDateForDay(int day) {
		Calendar c = Calendar.getInstance();
		while(c.get(Calendar.DATE) != day) {
			c.add(Calendar.DATE, 1);
		}
		return formatShortDate(c.getTime());
	}
}
