package com.sam.level1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringQTests {
	public StringQ testObj;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testObj = new StringQ();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void OnesComplementIsValid() {
		Assert.assertEquals("Has correct output", "0100",
				testObj.find_ones_comp("1011"));
	}

	@Test
	public void OnesComplementIsEmpty() {
		Assert.assertEquals("Has empty output", "", testObj.find_ones_comp(""));
	}

	@Test
	public void OnesComplementAllZeros() {
		Assert.assertEquals("Has empty output", "00000",
				testObj.find_ones_comp("11111"));
	}

	@Test
	public void TwosComplementIsValid() {
		Assert.assertEquals("Has correct output", "0101",
				testObj.find_twos_comp("1011"));
	}

	@Test
	public void TwosComplementIsEmpty() {
		Assert.assertEquals("Has correct output", "",
				testObj.find_twos_comp(""));
	}

	@Test
	public void TwosComplementAllZeros() {
		Assert.assertEquals("Has correct output", "100000",
				testObj.find_twos_comp("00000"));
	}

	@Test
	public void TwosComplementAllOnes() {
		Assert.assertEquals("Has correct output", "0001",
				testObj.find_twos_comp("1111"));
	}

	@Test
	public void ReverseAllAlpha() {
		Assert.assertEquals("Has correct output", "tset",
				testObj.reverse_string_nsym("test".toCharArray()));
	}

	@Test
	public void ReverseAllSymbol() {
		Assert.assertEquals("Has correct output", "*&@#$!",
				testObj.reverse_string_nsym("*&@#$!".toCharArray()));
	}

	@Test
	public void ReverseFewSymbol() {
		Assert.assertEquals("Has correct output", "$rama#",
				testObj.reverse_string_nsym("$amar#".toCharArray()));
	}

	@Test
	public void EditDistZero() {
		Assert.assertTrue(testObj.edit_dist_check("Apple", "Apple"));
	}

	@Test
	public void EditDistMany() {
		Assert.assertFalse(testObj.edit_dist_check("Apple", "Crane"));
	}

	@Test
	public void EditDistOneSubs() {
		Assert.assertTrue(testObj.edit_dist_check("Apple", "Ppple"));
	}

	@Test
	public void EditDistOneDel() {
		Assert.assertTrue(testObj.edit_dist_check("Apple", "Aapple"));
	}

	@Test
	public void EditDistTwoSubs() {
		Assert.assertFalse(testObj.edit_dist_check("People", "Coecle"));
	}

	@Test
	public void EditDistTwoDel() {
		Assert.assertFalse(testObj.edit_dist_check("People", "Peoe"));
	}

	@Test
	public void ReverseWordsEmppty() {
		Assert.assertEquals("", testObj.reverse_words(""));
	}

	@Test
	public void ReverseWordsOneWord() {
		Assert.assertEquals("tahW", testObj.reverse_words("What"));
	}

	@Test
	public void ReverseWordsMultiWord() {
		Assert.assertEquals("tahW si gnitae",
				testObj.reverse_words("What is eating"));
	}

	@Test
	public void ReverseWordsMultiWordWithNums() {
		Assert.assertEquals("tahW si gnitae 4321",
				testObj.reverse_words("What is eating 1234"));
	}

	@Test
	public void DeserializeEmpty() {
		ArrayList<String> results = new ArrayList<String>();
		Assert.assertEquals(results,
				testObj.deserializeStr(""));
	}

	@Test
	public void DeserializeOneString() {
		ArrayList<String> results = new ArrayList<String>();
		results.add("Subway");
		Assert.assertEquals(results,
				testObj.deserializeStr("Subway[;]"));
	}

	@Test
	public void DeserializeManyStrings() {
		ArrayList<String> results = new ArrayList<String>();
		results.add("Subway");
		results.add("Eat");
		results.add("Fresh");
		Assert.assertEquals(results,
				testObj.deserializeStr("Subway[;]Eat[;]Fresh[;]"));
	}

	@Test
	public void DeserializeManyStringsWithDelimiter() {
		ArrayList<String> results = new ArrayList<String>();
		results.add("Subway");
		results.add("Eat");
		results.add("Fresh");
		Assert.assertEquals(results,
				testObj.deserializeStr("Subway<:>Eat[;]Fresh[;]"));
	}

	@Test
	public void DeserializeWithSymbols() {
		ArrayList<String> results = new ArrayList<String>();
		results.add("Subway[]");
		results.add("<>Eat");
		results.add("<@>Fresh");
		Assert.assertEquals(results,
				testObj.deserializeStr("Subway[]<:><>Eat[;]<@>Fresh[;]"));
	}

	@Test
	public void DeserializeWithEmptyStrs() {
		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("");
		results.add("");
		Assert.assertEquals(results,
				testObj.deserializeStr("<:>[;][;]"));
	}

	@Test
	public void SerializeWithEmptyStrs() {

		String[] inStrs = new String[] {"","",""};
		Assert.assertEquals("[;][;][;]",
				testObj.serializeArray(inStrs));
	}

	@Test
	public void SerializeWithOneString() {

		String[] inStrs = new String[] {"Chipotle"};
		Assert.assertEquals("Chipotle[;]",
				testObj.serializeArray(inStrs));
	}

	@Test
	public void SerializeWithEmptyArray() {

		String[] inStrs = new String[] {};
		Assert.assertEquals("",
				testObj.serializeArray(inStrs));
	}

	@Test
	public void SerializeWithMultiStrings() {

		String[] inStrs = new String[] {"Game","Of","Thrones"};
		Assert.assertEquals("Game[;]Of[;]Thrones[;]",
				testObj.serializeArray(inStrs));
	}

	@Test
	public void SerializeWithMultiStringsDelimiter() {

		String[] inStrs = new String[] {"Game[;]","Of","Thrones"};
		Assert.assertEquals("Game[;]<:>Of[;]Thrones[;]",
				testObj.serializeArray(inStrs));
	}

	@Test
	public void RotateStrEmpty() {
		Assert.assertEquals("",
				testObj.leftRotateStr("", 2));
	}

	@Test
	public void RotateStrByTooMuch() {
		Assert.assertEquals("a",
				testObj.leftRotateStr("a", 2));
	}

	@Test
	public void RotateStrByZero() {
		Assert.assertEquals("a",
				testObj.leftRotateStr("a", 0));
	}

	@Test
	public void RotateStrByOne() {
		Assert.assertEquals("yrionT",
				testObj.leftRotateStr("Tyrion", 1));
	}

	@Test
	public void RotateStrByMany() {
		Assert.assertEquals("rionTy",
				testObj.leftRotateStr("Tyrion", 2));
	}

	@Test
	public void RotateStrBylength() {
		Assert.assertEquals("Tyrion",
				testObj.leftRotateStr("Tyrion", 6));
	}

	@Test
	public void RotateStrByNeg() {
		Assert.assertEquals("Tyrion",
				testObj.leftRotateStr("Tyrion", -2));
	}
}
