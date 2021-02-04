/**
 * Given two first names of two persons, please calculate name_pproximity_score. Name proximity score is calculated as follows :
 * 		-	if a letter occurs in the same position in both names, the score increments by two.
 * 		-	if a letter occurs in both names, but in different positions, the score is increments by 1.
 * 		-	Once a letter in a particular position is used in any of the names, it cannot be considered again. However, if the same letter occurs in another position, it can be used.
 * 
 * Input : The first line contains the first name and the second line contains the second name
 * Output : Only an integer value, showing the name_proximity_score
 * 
 * 
 * Sample test cases :
 * Input :
 * Amitabh
 * Ajitabh
 * Output :
 * 12
 * 
 * Input :
 * Ryaan
 * Nagesh
 * Output :
 * 2
 */

package com.subhra.maventic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Sample {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * 
		 * String str1 = br.readLine(); String str2 = br.readLine();
		 */

		String str1 = sc.next();
		String str2 = sc.next();

		sc.close();

		int score = 0;

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					if (i == j) {
						score += 2;
					} else {
						score += 1;
					}
				}
			}
		}

		System.out.println(score);

	}

}
