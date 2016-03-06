package com.sam.level1;

import java.util.ArrayList;
import java.util.HashMap;

public class StringQ {

	// i's complement
	public String find_ones_comp(String num) {
		char zero = '0';
		char one = '1';
		StringBuilder result = new StringBuilder();
		for (char ch : num.toCharArray()) {
			if (ch == zero)
				result.append(one);
			else
				result.append(zero);
		}
		return result.toString();
	}

	// 2's complement
	public String find_twos_comp(String num) {
		if (num.isEmpty())
			return num;
		String onesComp = find_ones_comp(num);
		char rem = '1'; // initial remainder
		char zero = '0';
		char one = '1';
		char[] intermVal = onesComp.toCharArray();
		StringBuilder result = new StringBuilder();
		for (int i = intermVal.length - 1; i >= 0; i--) {
			char ch = intermVal[i];
			if (ch == one && rem == one) {
				rem = one;
				result.append(zero);
			} else if (rem == one) {
				result.append(one);
				rem = zero;
			} else {
				result.append(ch);
			}
		}
		if (rem == one)
			result.append(rem);
		return result.reverse().toString();
	}

	// Reverses string leaving symbols as is
	public String reverse_string_nsym(char[] strArr) {
		int start = 0;
		char tempVal;
		StringBuilder result = new StringBuilder();
		int end = strArr.length - 1;
		while (end >= start) {
			if (is_alpha(strArr[end])) {
				if (is_alpha(strArr[start])) {
					tempVal = strArr[end];
					strArr[end] = strArr[start];
					strArr[start] = tempVal;
					start++;
					end--;
				} else {
					start++;
				}
			} else {
				end--;
			}
		}// while
		result.append(strArr);
		return result.toString();
	}

	private boolean is_alpha(char ch) {
		int charVal = (int) ch;
		int caVal = (int) 'A';
		int czVal = (int) 'Z';
		int aVal = (int) 'a';
		int zVal = (int) 'z';
		if ((charVal >= caVal && charVal <= czVal)
				|| (charVal >= aVal && charVal <= zVal))
			return true;
		else
			return false;
	}

	public boolean edit_dist_check(String str1, String str2) {
		int lengthDiff = Math.abs(str1.length() - str2.length());
		if (lengthDiff > 1)
			return false;
		int count1 = 0, count2 = 0, charDiff = 0;
		while (count1 < str1.length() && count2 < str2.length()) {
			if (charDiff > 1)
				return false;
			if (str1.charAt(count1) == str2.charAt(count2)) {
				count1++;
				count2++;
			} else if (lengthDiff == 0) {
				charDiff++;
				count1++;
				count2++;
			} else {
				charDiff++;
				if ((str1.length() - str2.length()) > 0)
					count1++;
				else
					count2++;
			}
		}
		return true;
	}

	// Reverse words in a string
	// add a space after the last word, to use as delimiter
	// reverse each word in place
	public String reverse_words(String inStr) {
		if (inStr.isEmpty())
			return inStr;
		int start = 0;
		int runner = 0;
		char[] workArr = (inStr + " ").toCharArray();
		while (runner < workArr.length) {
			if (workArr[runner] == ' ') {
				reverse_string(workArr, start, runner - 1);
				start = runner + 1;
			}

			runner++;
		}
		return (new String(workArr)).trim();
	}

	private char[] reverse_string(char[] inStr, int start, int end) {
		char temp;
		while (start < end) {
			temp = inStr[start];
			inStr[start] = inStr[end];
			inStr[end] = temp;
			start++;
			end--;
		}
		return inStr;
	}

	// Deserializes a string into an array
	public ArrayList<String> deserializeStr(String inStr) {
		String delimiter = "[;]";
		String delimiter2 = "<:>";
		String temp_str;
		int current = 0;
		ArrayList<String> result_arr = new ArrayList<String>();
		StringBuilder work_str = new StringBuilder();
		while ((current + 2) < inStr.length()) {
			temp_str = inStr.substring(current, current + 3);
			if (temp_str.equals(delimiter) || temp_str.equals(delimiter2)) {
				result_arr.add(work_str.toString());
				work_str.setLength(0);
				current = current + 2;
			} else {
				work_str.append(temp_str.charAt(0));
			}
			current++;
		}
		return result_arr;
	}

	// Serialize an array of strings
	public String serializeArray(String[] strArr) {
		// Use a symbol combination for delimiting the strings
		String delimiter = "[;]";
		String delimiter2 = "<:>";
		StringBuilder work_str = new StringBuilder();
		for (String strVal : strArr) {
			work_str.append(strVal);
			if (strVal.contains(delimiter))
				work_str.append(delimiter2);
			else
				work_str.append(delimiter);
		}
		return work_str.toString();
	}

	// left rotate a string
	// pineapple , 3
	// eapplepin
	public String leftRotateStr(String inStr, int rotate_by) {
		if (rotate_by <= 0)
			return inStr;
		if (inStr.length() < rotate_by)
			return inStr;
		StringBuilder work_str = new StringBuilder();
		int runner = rotate_by;
		while (runner < inStr.length()) {
			work_str.append(inStr.charAt(runner));
			runner++;
		}
		runner = 0;
		while (runner < rotate_by) {
			work_str.append(inStr.charAt(runner));
			runner++;
		}
		return work_str.toString();
	}
}
