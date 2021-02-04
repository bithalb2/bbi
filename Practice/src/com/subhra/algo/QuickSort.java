package com.subhra.algo;

import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the Array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.print("Enter "+size+" elements for Array : ");
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		quickSort(arr, 0, size - 1);
		
		System.out.print("Array after Sort : ");
		for(int i : arr) {
			System.out.print(i+" ");
		}

	}

	private static void quickSort(int[] arr, int beg, int end) {
		if(beg < end) {
			int pivote = partation(arr, beg, end);
			quickSort(arr, beg, pivote - 1);
			quickSort(arr, pivote + 1, end);
		}
		
	}

	private static int partation(int[] arr, int beg, int end) {
		int pivoteValue = arr[beg], pivote = beg;
		
		for(int i = beg + 1; i <= end; i++) {
			if(arr[i] < pivoteValue) {
				pivote++;
				int temp = arr[i];
				arr[i] = arr[pivote];
				arr[pivote] = temp;
			}
		}
		arr[beg] = arr[pivote];
		arr[pivote] = pivoteValue;
		
		return pivote;
	}

}
