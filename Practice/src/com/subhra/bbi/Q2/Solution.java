package com.subhra.bbi.Q2;

/* This is the Solution class
 * This Class contain 2 static methods :
 * mapIntervalToInt(float) and filteredData(String)
 */
public class Solution {
	
	//	This method map the interval to a int value
	public static int mapIntervalToInt(float value) {
		if(value < 0.2)
			return 0;
		else if(value < 0.4)
			return 1;
		else if(value < 0.6)
			return 2;
		else if(value < 0.8)
			return 3;
		else
			return 4;
	}
	
	//	This method will take the input string and filter the data
	public static String filteredData(String input) {
		
		// Variable initialization
		int key, min = Integer.MAX_VALUE, count = 0; float f;
		
		String result = "";
		
		//	Converting comma (,) separated string to Array of string by split() method
		String arr[] = input.split(",");
		
		//	This is the memory map which will store the number of values for each interval
		int[] map = new int[5];

		//	This is the float array store all values for further use
		//	We no need to parse the string to float repeated times
		float farr[] = new float[arr.length];
		
		//	Looping through the Array of string and updating appropriate value
		for(String s : arr)
		{
			//	Converting the string to float
			f = Float.parseFloat(s);
			//	Updating Array of floats 
			farr[count++] = f;
			//	Generating interval key for particular float by calling mapIntervalToInt() method
			key = mapIntervalToInt(f);
			//	Updating memory map, so that it will store the no of value present per interval
			map[key]++; 
		}
		
		//	Finding the minimum value present in memory map
		for(int i : map)
			if(i < min)
				min = i;
		
		//	Updating the memory map each interval value to min value
		//	As per requirement the all interval can have same subset
		count = 0;
		for(int i : map)
			map[count++] = min;

		//	Traversing through float array and taking minimum subset only
		//	And concat to result string
		for(float ff : farr) { 
			if(map[mapIntervalToInt(ff)]-- > 0) 
				result = result + ff +",";
		}
		
		//	Returning result string
		return result.substring(0, result.length()-1);
	}
}
