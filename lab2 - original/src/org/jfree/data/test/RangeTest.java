package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {

	private Range rangeObjectUnderTest;
	
	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1,1);
	}

	@After
	public void tearDown() throws Exception {
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












