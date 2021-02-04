package com.subhra.algo;

import java.util.Scanner;

public class MergeSort {

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
		
		//mergeSort(arr);
	}

/*	private static void mergeSort(int[] arr) {
		int size = arr.length, mid;
		if(size < 2)
			mid = size / 2;
			int[] leftArray = new int[];
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, end);
		}
	}
*/
	private static void merge(int start, int end) {
		// TODO Auto-generated method stub
		
	}

}
