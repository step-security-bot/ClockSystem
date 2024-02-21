package org.example.immediate.utility;

import org.example.utility.Time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {
	
	@Test
	public void testEquals() {
		Time time_one = new Time(22,42,42);
		Time time_two = new Time(22,42,42);
		assertNotSame(time_one,time_two);
		assertTrue(time_one.equals(time_two));
		}

	@Test
	public void testTickUp() {
		Time time_one = new Time(23,59,59);
		Time time_two = new Time(0,0,0);
		time_one.tickUp();
		assertTrue(time_one.equals(time_two));
		}
	
	@Test
	public void testTickDown() {
		Time time_one = new Time(23,59,59);
		Time time_two = new Time(0,0,0);
		time_two.tickDown();
		assertTrue(time_one.equals(time_two));
		}
	
	@Test
	public void testIsZeroOne() {
		Time time = new Time(0,0,1);
		assertFalse(time.isZero());
		assertTrue(time.isOne());
		}
	}
