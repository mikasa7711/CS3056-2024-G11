package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// 90% line coverage 70% branch coverage


public class RangeTest {

	private Range rangeObjectUnderTest;
	
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1,1);
	}

	@After
	public void tearDown() throws Exception {
	}

	//combine Tests
	@Test
	public void testCombine() {
		Range r1 = new Range(2,3);
		Range r2 = new Range(4,5);
		Range expectedRange = new Range(2,5);
		assertEquals("Combine: Did not return the expected output", expectedRange, Range.combine(r1, r2));
	}
	
	@Test
	public void testCombineR1Null() {
		Range r1 = null;
		Range r2 = new Range(4,5);
		Range expectedRange = r2;
		assertEquals("Combine: Did not return the expected output", expectedRange, Range.combine(r1, r2));
	}
	
	@Test
	public void testCombineR2Null() {
		Range r1 = new Range(2,3);
		Range r2 = null;
		Range expectedRange = r1;
		assertEquals("Combine: Did not return the expected output", expectedRange, Range.combine(r1, r2));
	}
	
	
	//constrain Tests
	@Test
	public void testConstrainUpper() {
		Range r1 = new Range(2,3);
		double value = 4;
		double expectedValue = 3;
		assertEquals("Constrain: Did not return the expected output", expectedValue, r1.constrain(value), 0.000000001d);
	}
	
	@Test
	public void testConstrainLower() {
		Range r1 = new Range(2,3);
		double value = 1;
		double expectedValue = 2;
		assertEquals("Constrain: Did not return the expected output", expectedValue, r1.constrain(value), 0.000000001d);
	}
	
	@Test
	public void testConstrainContains() {
		Range r1 = new Range(2,4);
		double value = 3;
		double expectedValue = 3;
		assertEquals("Constrain: Did not return the expected output", expectedValue, r1.constrain(value), 0.000000001d);
	}
	
	
	//contains Tests
	@Test
	public void testContains() {
		Range r1 = new Range(2,4);
		double value = 3;
		boolean expectedValue = true;
		assertEquals("Contains: Did not return the expected output", expectedValue, r1.constrain(value));
	}
	
	@Test
	public void testContainsFalse() {
		Range r1 = new Range(2,4);
		double value = 10;
		boolean expectedValue = false;
		assertEquals("Contains: Did not return the expected output", expectedValue, r1.constrain(value));
	}
	
	
	//equals Test
	@Test
	public void testEqualsTrue() {
		Range r1 = new Range(2,3);
		Range r2 = new Range(2,3);
		boolean expectedValue = true;
		assertEquals("Equals: Did not return the expected output", expectedValue, r1.equals(r2));
	}
	
	@Test
	public void testEqualsFalseDifferentLower() {
		Range r1 = new Range(2,3);
		Range r2 = new Range(1,3);
		boolean expectedValue = false;
		assertEquals("Equals: Did not return the expected output", expectedValue, r1.equals(r2));
	}
	
	@Test
	public void testEqualsFalseWrongObj() {
		Range r1 = new Range(2,3);
		double r2 = 6;
		boolean expectedValue = false;
		assertEquals("Equals: Did not return the expected output", expectedValue, r1.equals(r2));
	}

	
	//expand Tests
	@Test
	public void testExpand() {
		Range r1 = new Range(2,6);
		double lower = 0.25;
		double upper = 0.5;
		Range expectedRange = new Range(1,8);
		assertEquals("Expand: Did not return the expected output", expectedRange, Range.expand(r1, lower, upper));
	}
	
	@Test
	public void testExpandNull() {
		try {
			Range r1 = null;
			double lower = 0.25;
			double upper = 0.5;
			Range.expand(r1, lower, upper);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown",
				e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	//getLength Tests
	@Test
	public void testGetLength() {
		Range r1 = new Range(2,6);
		double expectedValue = 4;
		assertEquals("GetLength: Did not return the expected output", expectedValue, r1.getLength(), 0.000000001d);

	}
	
	//shift Tests
	@Test
	public void testShift() {
		Range r1 = new Range(2,6);
		double value = 1;
		Range expectedRange = new Range(3,7);
		assertEquals("Shift: Did not return the expected output", expectedRange, Range.shift(r1, value));

	}

	
	//getCentralValue Tests
	@Test //Example
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueBothPositive() {
		Range initialRange = new Range(1,5);
		assertEquals("getCentralValue: Did not return the expected output", 3.0, initialRange.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueBothNegative() {
		Range initialRange = new Range(-5,-1);
		assertEquals("getCentralValue: Did not return the expected output", -3.0, initialRange.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueOnePositiveOneNegative() {
		Range initialRange = new Range(-5,1);
		assertEquals("getCentralValue: Did not return the expected output", -2.0, initialRange.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueFloatValue() {
		Range initialRange = new Range(2,3);
		assertEquals("getCentralValue: Did not return the expected output", 2.5, initialRange.getCentralValue(), 0.000000001d);
	}
	
	//getLength Tests
	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2,2);
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength(), 0.000000001d);
	}
	
	@Test
	public void testGetLengthBothPositiveAndNotEqual() {
		Range r2 = new Range(4,9);
		assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength(), 0.000000001d);
	}
	
	@Test
	public void testGetLengthBothNegativeAndEqual() {
		Range r3 = new Range(-99,-99);
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength(), 0.000000001d);
	}
	
	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		Range r4 = new Range(-11,-4);
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength(), 0.000000001d);
	}
	
	@Test
	public void testGetLengthOnePositiveOneNegative() {
		Range r5 = new Range(-5,3);
		assertEquals("getLength: Did not return the expected output", 8, r5.getLength(), 0.000000001d);
	}
	
	
	//expandToInclude Tests
	@Test
	public void testExpandToIncludeBothPositiveRangeAndAboveRangeValue() {
		Range initialRange = new Range(1,3);
		Range expectedRange = new Range(1,4);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange, 4));

	}
	
	@Test
	public void testExpandToIncludeBothPositiveRangeAndBelowRangeValue() {
		Range initialRange = new Range(1,3);
		Range expectedRange = new Range(-1,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,-1));
	}
	
	@Test
	public void testExpandToIncludeBothPositiveRangeAndWithinRangeValue() {
		Range initialRange = new Range(1,3);
		Range expectedRange = new Range(1,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,2));
	}
	
	@Test
	public void testExpandToIncludeBothNegativeRangeAndAboveRangeValue() {
		Range initialRange = new Range(-3,-1);
		Range expectedRange = new Range(-3,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,3));
	}
	
	@Test
	public void testExpandToIncludeBothNegativeRangeAndBelowRangeValue() {
		Range initialRange = new Range(-3,-1);
		Range expectedRange = new Range(-4,-1);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,-4));
	}
	
	@Test
	public void testExpandToIncludeBothNegativeRangeAndWithinRangeValue() {
		Range initialRange = new Range(-3,-1);
		Range expectedRange = new Range(-3,-1);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,-2));
	}
	
	@Test
	public void testExpandToIncludeOnePositiveOneNegativeRangeAndAboveRangeValue() {
		Range initialRange = new Range(-3,3);
		Range expectedRange = new Range(-3,5);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange, 5));
	}
	
	@Test
	public void testExpandToIncludeOnePositiveOneNegativeRangeAndBelowRangeValue() {
		Range initialRange = new Range(-3,3);
		Range expectedRange = new Range(-4,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,-4));
	}
	
	@Test
	public void testExpandToIncludeOnePositiveOneNegativeRangeAndWithinRangeValue() {
		Range initialRange = new Range(-3,3);
		Range expectedRange = new Range(-3,-1);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,1));
	}
	
	@Test
	public void testExpandToIncludeEqualAndPositiveRangeAndAboveRangeValue() {
		Range initialRange = new Range(3,3);
		Range expectedRange = new Range(3,5);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange, 5));
	}
	
	@Test
	public void testExpandToIncludeEqualAndPositiveRangeAndBelowRangeValue() {
		Range initialRange = new Range(3,3);
		Range expectedRange = new Range(1,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,1));
	}
	
	@Test
	public void testExpandToIncludeEqualAndPositiveRangeAndWithinRangeValue() {
		Range initialRange = new Range(3,3);
		Range expectedRange = new Range(3,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,3));
	}
	
	@Test
	public void testExpandToIncludeEqualAndNegativeRangeAndAboveRangeValue() {
		Range initialRange = new Range(-3,-3);
		Range expectedRange = new Range(-3,-1);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange, -1));
	}
	
	@Test
	public void testExpandToIncludeEqualAndNegativeRangeAndBelowRangeValue() {
		Range initialRange = new Range(-3,-3);
		Range expectedRange = new Range(-10,-3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,-10));
	}
	
	@Test
	public void testExpandToIncludeEqualAndNegativeRangeAndWithinRangeValue() {
		Range initialRange = new Range(-3,-3);
		Range expectedRange = new Range(-3,-3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(initialRange,-2));
	}
	
	@Test
	public void testExpandToIncludeNullRange() {
		Range expectedRange = new Range(3,3);
		assertEquals("expandToInclude: Did not return the expected output", expectedRange, rangeObjectUnderTest.expandToInclude(null,3));
	}
	
	//getLowerBound Tests
	@Test
	public void testGetLowerBoundPositiveRange() {
		Range initialRange = new Range(1,3);
		assertEquals("getLowerBound: Did not return the expected output", 1, initialRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testGetLowerBoundPositiveAndEqualRange() {
		Range initialRange = new Range(3,3);
		assertEquals("getLowerBound: Did not return the expected output", 3, initialRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testGetLowerBoundNegativeRange() {
		Range initialRange = new Range(-3,-1);
		assertEquals("getLowerBound: Did not return the expected output", -3, initialRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testGetLowerBoundNegativeAndEqualRange() {
		Range initialRange = new Range(-3,-3);
		assertEquals("getLowerBound: Did not return the expected output", -3, initialRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testGetLowerBoundPositiveAndNegativeRange() {
		Range initialRange = new Range(-3,3);
		assertEquals("getLowerBound: Did not return the expected output", -3, initialRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testGetLowerBoundBothZeroRange() {
		Range initialRange = new Range(0,0);
		assertEquals("getLowerBound: Did not return the expected output", 0, initialRange.getLowerBound(), 0.000000001d);
	}
	
	//getUpperBound Test
	@Test
	public void testGetUpperBoundPositiveRange() {
		Range initialRange = new Range(1,3);
		assertEquals("getUpperBound: Did not return the expected output", 3, initialRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testGetUpperBoundPositiveAndEqualRange() {
		Range initialRange = new Range(3,3);
		assertEquals("getUpperBound: Did not return the expected output", 3, initialRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testGetUpperBoundNegativeRange() {
		Range initialRange = new Range(-3,-1);
		assertEquals("getUpperBound: Did not return the expected output", -1, initialRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testGetUpperBoundNegativeAndEqualRange() {
		Range initialRange = new Range(-3,-3);
		assertEquals("getUpperBound: Did not return the expected output", -3, initialRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testGetUpperBoundPositiveAndNegativeRange() {
		Range initialRange = new Range(-3,3);
		assertEquals("getUpperBound: Did not return the expected output", 3, initialRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testGetUpperBoundBothZeroRange() {
		Range initialRange = new Range(0,0);
		assertEquals("getUpperBound: Did not return the expected output", 0, initialRange.getUpperBound(), 0.000000001d);
	}
	
	//intersects Tests
	@Test
	public void testIntersectsAllPositiveTrue() {
		Range initialRange = new Range(2,5);
		assertEquals("intersects: Did not return the expected output", true, initialRange.intersects(1,4));
	}
	
	@Test
	public void testIntersectsAllPositiveFalse() {
		Range initialRange = new Range(5,6);
		assertEquals("intersects: Did not return the expected output", false, initialRange.intersects(1,4));
	}
	
	@Test
	public void testIntersectsAllPositiveAndEqual() {
		Range initialRange = new Range(1,1);
		assertEquals("intersects: Did not return the expected output", true, initialRange.intersects(1,1));
	}
	
	@Test
	public void testIntersectsAllNegativeTrue() {
		Range initialRange = new Range(-3,-2);
		assertEquals("intersects: Did not return the expected output", true, initialRange.intersects(-4,-1));
	}
	
	@Test
	public void testIntersectsAllNegativeFalse() {
		Range initialRange = new Range(-6,-5);
		assertEquals("intersects: Did not return the expected output", false, initialRange.intersects(-4,-1));
	}
	
	@Test
	public void testIntersectsAllNegativeAndEqual() {
		Range initialRange = new Range(-5,-5);
		assertEquals("intersects: Did not return the expected output", true, initialRange.intersects(-5,-5));
	}
	
	@Test
	public void testIntersectsInitialRangeNegativeInputPositive() {
		Range initialRange = new Range(-6,-5);
		assertEquals("intersects: Did not return the expected output", false, initialRange.intersects(5,6));
	}
	
	@Test
	public void testIntersectsInitialRangePositiveInputNegative() {
		Range initialRange = new Range(5,6);
		assertEquals("intersects: Did not return the expected output", false, initialRange.intersects(-6,-5));
	}
	
	@Test
	public void testIntersectsAllZero() {
		Range initialRange = new Range(0,0);
		assertEquals("intersects: Did not return the expected output", true, initialRange.intersects(0,0));
	}
	
	@Test
	public void testIntersectsBothLowersNegative() {
		Range initialRange = new Range(-6,5);
		assertEquals("intersects: Did not return the expected output", true, initialRange.intersects(-6,5));
	}
}












