package org.example.notimmediate;


import org.example.component.ClockTimer;
import org.example.state.clocktimer.DisplayClockTimerOff;
import org.example.state.clocktimer.DisplayClockTimerOn;
import org.example.utility.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ClockTimerTest {
	
	private ClockTimer ct;

	@BeforeEach
	public void setUp() {
		ct = new ClockTimer(); }
	
	@Test
	public void autoStopStateTest() throws InterruptedException {
		ct.getTime().setSecond(2);
		ct.start();
		assertSame(DisplayClockTimerOn.Instance(), ct.getPowerState());
		
		Thread.sleep(2100);
		assertSame(DisplayClockTimerOff.Instance(), ct.getPowerState());
		}
	
	@Test
	public void tickTest() throws InterruptedException {
		ct.getTime().setMinute(1);
		ct.start();
		Thread.sleep(2100);
		ct.stop();
		Time expected = new Time(0,0,58);
		assertTrue(ct.getTime().equals(expected));
		}
	}
