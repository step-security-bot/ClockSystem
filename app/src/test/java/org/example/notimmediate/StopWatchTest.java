package org.example.notimmediate;


import org.example.component.StopWatch;
import org.example.utility.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StopWatchTest {
	
	private StopWatch sw;

	@BeforeEach
	public void setUp() {
		sw = new StopWatch(); }
	
	@Test
	public void tickTest() throws InterruptedException {
		sw.start();
		Thread.sleep(2100);
		sw.stop();
		assertTrue(sw.getTime().equals(new Time(0,0,2)));
		}
	
	@Test
	public void resetingTest() throws InterruptedException {
		sw.start();
		Thread.sleep(2000);
		sw.stop();
		Time previous = sw.getTime();
		sw.reset();
		assertFalse(previous.isZero());
		Time actual = sw.getTime();
		assertTrue(actual.isZero());
		}
	}
