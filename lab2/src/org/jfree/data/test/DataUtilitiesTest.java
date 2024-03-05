package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.Values2D;
import junit.framework.TestCase;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
	private Values2D values2D;

	@Before
	public void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1,0,0);
		testValues.addValue(4, 1, 0);
	}

	@After
	public void tearDown() {
		values2D = null;
	}

	
	// calculateRowTotal Tests
	//Has an issue somewhere, all tests return 0
	@Test //Has an invalid input so returns 0
	public void testValidDataAndRowTotal() {
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d );
	}
	
	
	@Test
	public void testNullDataRowTotal() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testAllPositiveRowTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0.0,6.0, 0.0);
		testValues.addValue(5.0, 3.0, 0.0);
		assertEquals("calculateRowTotal: Did not Return the expected result", 6.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d );
	}
	
	@Test
	public void testAllPositiveAndFinalElementRowRowTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0.0,6.0, 0.0);
		testValues.addValue(5.0, 3.0, 0.0);
		assertEquals("calculateRowTotal: Did not Return the expected result", 8.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d );
	}
	
	@Test
	public void testAllNegativeRowTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(-0.0,-6.0, -0.0);
		testValues.addValue(-5.0, -3.0, -0.0);
		assertEquals("calculateRowTotal: Did not Return the expected result", -6.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d );
	}
	
	@Test
	public void testAllNegativeAndFinalElementRowRowTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(-0.0,-6.0, -0.0);
		testValues.addValue(-5.0, -3.0, -1.0);
		assertEquals("calculateRowTotal: Did not Return the expected result", -9.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d );
	}
	
	
	
	// getCumulativePercentages Tests
	@Test
	public void testGetCumulativePercentages() {
		DefaultKeyedValues keyValues = new DefaultKeyedValues();
		keyValues.addValue((Comparable) 0.0, 6.0);
		keyValues.addValue((Comparable) 1.0,  11.0);
		keyValues.addValue((Comparable) 2.0, 3.0);
		KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) ke
				yValues);
		
		assertEquals((double) object_under_test.getValue(2), 1.0, .000000001d);
	}
	
	//calculateColumnTotal Tests
	@Test
	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testAllPositiveColumnTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0.0,6.0, 0.0);
		testValues.addValue(5.0, 3.0, 0.0);
		assertEquals("calculateColumnTotal: Did not Return the expected result", 5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d );
	}
	
	@Test
	public void testAllPositiveAndFinalElementColumnColumnTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(0.0,6.0, 0.0);
		testValues.addValue(5.0, 3.0, 0.0);
		assertEquals("calculateColumnTotal: Did not Return the expected result", 0.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d );
	}
	
	@Test
	public void testAllNegativeColumnTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(-0.0,-6.0, -0.0);
		testValues.addValue(-5.0, -3.0, -0.0);
		assertEquals("calculateColumnTotal: Did not Return the expected result", -5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d );
	}
	
	@Test
	public void testAllNegativeAndFinalElementColumnColumnTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(-0.0,-6.0, -0.0);
		testValues.addValue(-5.0, -3.0, -1.0);
		assertEquals("calculateColumnTotal: Did not Return the expected result", -1.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d );
	}
	

	
	//createNumberArray Tests
	@Test
	public void testPositiveCreateNumberArray() {
		double[] dataInput = {1.1, 2.2, 3.3}; 
		Number[] actual = DataUtilities.createNumberArray(dataInput);
		Number[] expected = {1.1, 2.2, 3.3}; 
		assertArrayEquals("createNumberArray: Did not return the expected result", expected, actual);
		
	}
	
	@Test
	public void testNegativeCreateNumberArray() {
		double[] dataInput = {-1.1, -2.2, -3.3}; 
		Number[] actual = DataUtilities.createNumberArray(dataInput);
		Number[] expected = {-1.1, -2.2, -3.3}; 
		assertArrayEquals("createNumberArray: Did not return the expected result", expected, actual);
		
	}
	
	@Test
	public void testOneElementCreateNumberArray() {
		double[] dataInput = {1}; 
		Number[] actual = DataUtilities.createNumberArray(dataInput);
		Number[] expected = {1}; 
		assertArrayEquals("createNumberArray: Did not return the expected result", expected, actual);
		
	}
	
	@Test
	public void testAllSameCreateNumberArray() {
		double[] dataInput = {0,0,0,0}; 
		Number[] actual = DataUtilities.createNumberArray(dataInput);
		Number[] expected = {0.0,0.0,0.0,0.0}; 
		assertArrayEquals("createNumberArray: Did not return the expected result", expected, actual);
		
	}
	
	@Test
	public void testNullCreateNumberArray() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	//createNumberArray2D Tests
	
}
