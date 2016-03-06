package com.sam.level1;

import static org.junit.Assert.*;

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
		Assert.assertEquals("Has correct output","tset",testObj.reverse_string_nsym("test".toCharArray()));
	}

	@Test
	public void ReverseAllSymbol() {
		Assert.assertEquals("Has correct output","*&@#$!",testObj.reverse_string_nsym("*&@#$!".toCharArray()));
	}

	@Test
	public void ReverseFewSymbol() {
		Assert.assertEquals("Has correct output","$rama#",testObj.reverse_string_nsym("$amar#".toCharArray()));
	}
}
