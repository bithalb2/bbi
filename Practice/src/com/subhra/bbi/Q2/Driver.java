package com.subhra.bbi.Q2;

import java.util.Scanner;

/* This is the Driver class
 * This Driver class have main() method where the program will start execute
 */
public class Driver {
	
	// The is the main() method where the program will start execute
	public static void main(String[] args) {
		
		// Scanner class object creation to take input from console
		Scanner sc = new Scanner(System.in);
		
		// Taking input
		String input = sc.next();
		sc.close();
		
		//	Calling filteredData() method of Solution class
		String output = Solution.filteredData(input);
		
		//	Printing Output
		System.out.println(output);
	}

}
