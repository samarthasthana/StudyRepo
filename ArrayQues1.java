package com.sam.level1;

import java.util.ArrayList;
import java.util.List;

public class ArrayQues1 {

	// Q
	// Given an array of stock values of a company. Find out the time when a
	// user would have bought the stock and sold the sock.
	// Basically find the maximum positive difference of any two given elements
	// in an array?

	// 2,5,3,1,5,7,4,5,9,2
	// Brute force traverse each element and find the max diff with elements
	// after it
	//
	public int find_max_diff(int[] arr1) {
		if (arr1.length <= 1)
			return -1;

		int minIdx = arr1[0];
		int maxIdx = 0;
		int diff = 0;
		int tempDiff = 0;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr1.length; j++) {
				tempDiff = arr1[j] - arr1[i];
				if (tempDiff > diff) {
					minIdx = i;
					maxIdx = j;
					diff = tempDiff;
				}
			}
		}
		return diff;
	}

	// write a method that takes in 2 int arrays of any size and returns an
	// array that calculates the sum of both.
	//
	// for example, [1,2,3] and [2,3,4] will return [3,5,7]
	//
	// Or [1,2,3] and [2,3,5,5] will return [2,4,7,8]
	//
	// however, if it's like [9,9,2] and [0,1,3] you need to carry the sum so it
	// returns as [1,0,0,5]
	//
	// ** SINGLE DIGIT ONLY

	// Reverse traverse and store the result in result array
	// Make result as arrayList
	// Have a var for carry
	// Add each digit and carry and store result %10 and make carry = result /10

	public List find_arr_addition(Integer[] arr1, Integer[] arr2) {
		List<Integer> result = new ArrayList<Integer>();

		int idx1 = arr1.length - 1;
		int idx2 = arr2.length - 1;
		Integer tempResult = 0;
		Integer carry = 0;

		while (idx1 >= 0 && idx2 >= 0) {
			tempResult = arr1[idx1] + arr2[idx2] + carry;
			result.add(tempResult % 10);
			carry = tempResult / 10;
			idx1--;
			idx2--;
		}
		if (idx1 > idx2) {
			while (idx1 >= 0) {
				tempResult = arr1[idx1] + carry;
				result.add(tempResult % 10);
				carry = tempResult / 10;
				idx1--;
			}
		} else {
			while (idx2 >= 0) {
				tempResult = arr2[idx2] + carry;
				result.add(tempResult % 10);
				carry = tempResult / 10;
				idx2--;
			}
		}
		if(carry > 0)result.add(carry);
		return reverse_list(result);
	}

	private List reverse_list(List<Integer> inList) {
		int listLen = inList.size();
		int idx = 0;
		int revIdx = listLen - 1;
		Integer tempVal;

		if (listLen < 2)
			return inList;

		while (idx <= revIdx) {
			tempVal = inList.get(idx);

			inList.set(idx, inList.get(revIdx));
			inList.set(revIdx, tempVal);
			revIdx--;
			idx++;
		}
		return inList;
	}

}
