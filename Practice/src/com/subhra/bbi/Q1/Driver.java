package com.subhra.bbi.Q1;

import java.util.Scanner;

/* This is the Driver class
 * This Driver class have main() method where the program will start execute
 */
public class Driver {
	
	// The is the main() method where the program will start execute
	public static void main(String[] args) {
		// Scanner class object creation to take input from console
		Scanner sc = new Scanner(System.in);
		// Taking input from console
		String input = sc.next();
		sc.close();
		
		/*	Object creation of MyDate class
		 * 	This is a User defined class contain the day, month and year properties
		 * 	This class also have validate() method which validate the input String
		 */
		MyDate inputDate = new MyDate();
		
		if(inputDate.validate(input))
		{
			long result = inputDate.calculateEpoch();
			System.out.println(result);
		} else {
			System.out.println("Unable to convert the provided date");
		}

	} //End of Main method
}