package com.subhra.other;

import java.util.Scanner;

public class PrimeNumber {

	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String result = "";

		int number = sc.nextInt(), temp;

		temp = number - 1;
		while (true) {
			if (isPrime(temp))
				break;
			else
				temp--;
		}

		result = result + temp + " and ";

		temp = number + 1;
		while (true) {
			if (isPrime(temp))
				break;
			else
				temp++;
		}

		result = result + temp;

		System.out.println(result);
	}
}
