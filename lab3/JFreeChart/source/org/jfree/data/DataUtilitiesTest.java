package org.jfree.data;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.Values2D;
import junit.framework.TestCase;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


// 100% line coverage 100% branch coverage

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
	@Test 
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
	public void testGetCumulativePercentagesAllPositive() {
		DefaultKeyedValues keyValues = new DefaultKeyedValues();
		keyValues.addValue((Comparable) 0.0, 2.0);
		keyValues.addValue((Comparable) 1.0,  3.0);
		keyValues.addValue((Comparable) 2.0, 5.0);
		KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues)keyValues);
		
		assertEquals(1.0,(double) object_under_test.getValue(2), .000000001d);
	}
	
	@Test
	public void testGetCumulativePercentagesWithNull() {
		try {
			DefaultKeyedValues keyValues = new DefaultKeyedValues();
			keyValues.addValue((Comparable) 0.0, null);
			keyValues.addValue((Comparable) 1.0,  11.0);
			keyValues.addValue((Comparable) 2.0, 3.0);
			KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues)keyValues);
			
			assertEquals(1.0, (double) object_under_test.getValue(2), .000000001d);
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(UnknownKeyException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesNullKeyValues() {
		try {
			KeyedValues object_under_test = DataUtilities.getCumulativePercentages((null));
			
			assertEquals(1.0, (double) object_under_test.getValue(2), .000000001d);
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesAllZeros() {
		DefaultKeyedValues keyValues = new DefaultKeyedValues();
		keyValues.addValue((Comparable) 0.0, 0.0);
		keyValues.addValue((Comparable) 1.0,  0.0);
		keyValues.addValue((Comparable) 2.0, 0.0);
		KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues)keyValues);
		
		assertEquals("GetCumulativePercentage: Did not return Expected Result", 1.0, (double) object_under_test.getValue(0), .000000001d);
	}


	//calculateColumnTotal Tests
	
	@Test
	public void testDataColumnTotalWithNullValue() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(null,6.0, 0.0);
		testValues.addValue(5.0, 3.0, 0.0);
		assertEquals("calculateColumnTotal: Did not Return the expected result", 5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d );
	
	}
	
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
	public void testBVAColumnTotal() {
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
			values2D = testValues;
			testValues.addValue(0.0,6.0, 0.0);
			testValues.addValue(5.0, 3.0, 0.0);
			assertEquals("calculateColumnTotal: Did not Return the expected result", 9.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d );
		}		
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testBVAPlusOneColumnTotal() {
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
			values2D = testValues;
			testValues.addValue(0.0,6.0, 0.0);
			testValues.addValue(5.0, 3.0, 0.0);
			DataUtilities.calculateColumnTotal(values2D, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testAllPositiveAndFinalElementColumnColumnTotal() {
		try {
			DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
			values2D = testValues;
			testValues.addValue(0.0,6.0, 0.0);
			testValues.addValue(5.0, 3.0, 0.0);
			assertEquals("calculateColumnTotal: Did not Return the expected result", 0.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d );
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAllNegativeColumnTotal() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(-0.0,-6.0, -0.0);
		testValues.addValue(-5.0, -3.0, -0.0);
		assertEquals("calculateColumnTotal: Did not Return the expected result", -5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d );
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
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	//createNumberArray2D Tests
	@Test
	public void testNullCreateNumberArray2D() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testAllPositiveCreateNumberArray2D() {
		double[][] dataInput = {{1,2,3},{1,2,3}}; 
		Number[][] actual = DataUtilities.createNumberArray2D(dataInput);
		Number[][] expected = {{1.0,2.0,3.0},{1.0,2.0,3.0}}; 
		assertArrayEquals("createNumberArray2D: Did not return the expected result", expected, actual);
	}
	
	@Test
	public void testAllNegativeCreateNumberArray2D() {
		double[][] dataInput = {{-1,-2,-3},{-1,-2,-3}}; 
		Number[][] actual = DataUtilities.createNumberArray2D(dataInput);
		Number[][] expected = {{-1.0,-2.0,-3.0},{-1.0,-2.0,-3.0}}; 
		assertArrayEquals("createNumberArray2D: Did not return the expected result", expected, actual);
	}
	
	@Test
	public void testAllZeroCreateNumberArray2D() {
		double[][] dataInput = {{0,0,0},{0,0,0}}; 
		Number[][] actual = DataUtilities.createNumberArray2D(dataInput);
		Number[][] expected = {{0.0,0.0,0.0},{0.0,0.0,0.0}}; 
		assertArrayEquals("createNumberArray2D: Did not return the expected result", expected, actual);
	}
	
	@Test
	public void testPositiveAndNegativeCreateNumberArray2D() {
		double[][] dataInput = {{1,2,3},{-1,-2,-3}}; 
		Number[][] actual = DataUtilities.createNumberArray2D(dataInput);
		Number[][] expected = {{1.0,2.0,3.0},{-1.0,-2.0,-3.0}}; 
		assertArrayEquals("createNumberArray2D: Did not return the expected result", expected, actual);
	}
	
	@Test
	public void testEmptyCreateNumberArray2D() {
		double[][] dataInput = {{},{}}; 
		Number[][] actual = DataUtilities.createNumberArray2D(dataInput);
		Number[][] expected = {{},{}}; 
		assertArrayEquals("createNumberArray2D: Did not return the expected result", expected, actual);
	}
}
