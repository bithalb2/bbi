package com.subhra.bbi.Q1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
 * This is the MyDate user defined class
 * The class have 3 properties day, month and year
 * This class also contain validate() method to validate the input string
 * This class also contain calculateEpoch() method to calculate Epoch time
 */
public class MyDate {
	
	private int day;
	private int month;
	private int year;
	
	/* This the the validate() method to validate the input string
	 */
	public boolean validate(String input) {
		// monthArray holds the maximum days in a particular month (Indexing start from 1)
		int[] monthArray = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		try {
			
			/*	This condition will check the input String length = 8 or not
			 * 	As per the requirement we can have string length equal to 8 OR 10
			 * 	i.e, ddmmyyyy or mmddyyyy will be 8 char length 
			 * 	Whether day will come first or month will be checked as part of validate method
			 */
			if(input.length() == 8) {
				
				/* Here we are setting the properties of MyDate class
				 * We are parsing the String to day, month and Year format
				 */
				day = Integer.parseInt(input.substring(0, 2));
				month = Integer.parseInt(input.substring(2, 4));
				year = Integer.parseInt(input.substring(4, 8));
				
				/* This will check the string having '/', '.' OR '-' separated value
				 * i.e, dd/mm/yyyy OR dd.mm.yyyy OR dd-mm-yyyy
				 * Whether day will come first or month will be checked as part of validate method
				 */
			} else if(input.length() == 10) {
				
				if(input.charAt(2) == input.charAt(5) && 
						(input.charAt(2) == '/' || input.charAt(2) == '-' || input.charAt(2) == '.')) {
					/*
					 * Here we are setting the properties of MyDate class
					 * We are parsing the String to day, month and Year format
					 */
					day = Integer.parseInt(input.substring(0, 2));
					month = Integer.parseInt(input.substring(3, 5));
					year = Integer.parseInt(input.substring(6, 10));
					
				} else {return false;} // If Separator are not same
			
			} else {return false;} //If String length is not 8 OR 10
		} catch(Exception e) {
			return false;
		}
		
		/*
		 * As per requirement this condition is checking the year must be with 1970 to current year
		 * 
		 */
		if(year >= 1970 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
			
			//	This condition is checking whether day or month is not equal to zero
			if(day > 0 && month > 0) {
				
				/* This condition is checking whether the input string is in the form
				 * "ddmmyyyy" or "mmddyyyy"
				 * By default it will consider the "ddmmyyyy" until it is satisfying date format
				 */
				if(month > 12) {
					int temp = day;
					day = month;
					month = temp;
				}
				
				/* This condition is checking month should not be greater than 12
				 * And also check the day having proper range of value
				 * E.g, 31/04/2020 is not a valid ad April month only have 30 days
				 */
				if(month > 12)
					return false;
				else {
					if(month == 2 && isLeapYear(year))
						if(day <= monthArray[month]+1)
							return true;
						else
							return false;
					else
						if(day <= monthArray[month])
							return true;
						else
							return false;
				}
			} else {return false;}
		} else {return false;}
	}
	
	/*
	 * The is the method to check whether a given year is Leap Year or not
	 */
	private boolean isLeapYear(int year) {
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return  false;
	}
	
	/*
	 * This is the calculateEpoch() method of Driver class
	 * This will take MyDate as input and return the Epoch time
	 */
	public long calculateEpoch() {
		try {
			/*
			 * Creating SimpleDateFormat object to parse input String to Java Object
			 */
			SimpleDateFormat initialSdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			/*
			 * As per requirement parsing "01/01/1970" as Java Date Object
			 */
			Date initialDate = initialSdf.parse("01/01/1970 12:00:00.000");
			/*
			 * Parsing our input String to Java Date Object
			 */
			Date finalDate = initialSdf.parse(day+"/"+month+"/"+year+" 12:00:00.000");
			/*
			 * Calling getTime() method of Date class which will return 
			 * Subtracting the given date from input date to generate the difference in millisecond
			 * Dividing the result by 1000 will generate the Epoch Date
			 */
			long result = (finalDate.getTime() - initialDate.getTime()) / 1000;
			
			return result; 
		} catch(Exception e) {
			System.out.println("Unable to convert the provided date");
			System.exit(0);
		}
		return 0;
	}
}
