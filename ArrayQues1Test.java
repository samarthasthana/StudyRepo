package com.sam.level1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayQues1Test {

	private ArrayQues1 testObj ;
	private int [] testArr;
	private Integer[] arr1,arr2;
	private List<Integer> result;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 testObj = new ArrayQues1();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindMaxEmpty() {
		testArr = new int[]{};
		Assert.assertEquals(-1, testObj.find_max_diff(testArr));
	}

	@Test
	public void TestFindMaxSingle() {
		testArr = new int[]{1};
		Assert.assertEquals(-1, testObj.find_max_diff(testArr));
	}

	@Test
	public void TestFindMaxTwo() {
		testArr = new int[]{1,2};
		Assert.assertEquals(1, testObj.find_max_diff(testArr));
	}

	@Test
	public void TestFindMaxNeg() {
		testArr = new int[]{9,1};
		Assert.assertEquals(0, testObj.find_max_diff(testArr));
	}

	@Test
	public void TestFindMaxMulti() {
		testArr = new int[]{9,1,10,15,2};
		Assert.assertEquals(14, testObj.find_max_diff(testArr));
	}

	@Test
	public void TestFindArrAddNull() {
		arr1 = new Integer[]{};
		arr2 = new Integer[]{};
		result = new ArrayList<Integer>();
		Assert.assertEquals(result, testObj.find_arr_addition(arr1, arr2));
	}

	@Test
	public void TestFindArrAddOneNull() {
		arr1 = new Integer[]{1};
		arr2 = new Integer[]{};
		result = new ArrayList<Integer>();
		result.add(1);
		Assert.assertEquals(result, testObj.find_arr_addition(arr1, arr2));
	}

	@Test
	public void TestFindArrAddEqLen() {
		arr1 = new Integer[]{1,1};
		arr2 = new Integer[]{2,1};
		result = new ArrayList<Integer>();
		result.add(3);
		result.add(2);
		Assert.assertEquals(result, testObj.find_arr_addition(arr1, arr2));
	}

	@Test
	public void TestFindArrAddUnEqLen() {
		arr1 = new Integer[]{1,4,2};
		arr2 = new Integer[]{2,1};
		result = new ArrayList<Integer>();
		result.add(1);
		result.add(6);
		result.add(3);
		Assert.assertEquals(result, testObj.find_arr_addition(arr1, arr2));
	}

	@Test
	public void TestFindArrAddCarryChq() {
		arr1 = new Integer[]{1,9,2};
		arr2 = new Integer[]{2,1};
		result = new ArrayList<Integer>();
		result.add(2);
		result.add(1);
		result.add(3);
		Assert.assertEquals(result, testObj.find_arr_addition(arr1, arr2));
	}

	@Test
	public void TestFindArrAddMaxCarryChq() {
		arr1 = new Integer[]{9,9};
		arr2 = new Integer[]{9,9};
		result = new ArrayList<Integer>();
		result.add(1);
		result.add(9);
		result.add(8);
		Assert.assertEquals(result, testObj.find_arr_addition(arr1, arr2));
	}

	@Test
	public void TestFindAvgNil() {
		int[] inArr = new int[]{};
		Assert.assertEquals(-1, testObj.find_arr_avg(inArr, 2));
	}

	@Test
	public void TestFindAvgHighK() {
		int[] inArr = new int[]{1,2,3};
		Assert.assertEquals(-1, testObj.find_arr_avg(inArr, 5));
	}

	@Test
	public void TestFindAvgKisLen() {
		int[] inArr = new int[]{1,2,3};
		Assert.assertEquals(0, testObj.find_arr_avg(inArr, 3));
	}

	@Test
	public void TestFindAvgHP1() {
		int[] inArr = new int[]{9,5,2,4,3};
		Assert.assertEquals(2, testObj.find_arr_avg(inArr, 3));
	}

	@Test
	public void TestFindAvgLongHP() {
		int[] inArr = new int[]{1,5,9,4,3,4,7,8,10,11,23,54,3,1,12,90};
		Assert.assertEquals(3, testObj.find_arr_avg(inArr, 3));
	}

}
