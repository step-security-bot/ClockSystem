package org.example.immediate.utility;


import org.example.utility.PointedArray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointedArrayTest {
	
	private PointedArray<Integer> array;

	@BeforeEach
	public void setUp() {
		Integer[] intArray = {Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)};
		array = new PointedArray<Integer>(intArray); }
	
	@Test
	public void setPointerException1() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> array.setPointer(-1));
	}

	@Test
	public void setPointerException2() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> array.setPointer(3));
		}

	@Test
	public void getException1() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
	}

	@Test
	public void getException2() {
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> array.get(3));
	}

	@Test
	public void getPointedItemTest() {
		array.setPointer(2);
		assertEquals(Integer.valueOf(2), array.getPointedItem());
		array.setPointer(1);
		assertEquals(Integer.valueOf(1), array.getPointedItem());
		}
	
}
