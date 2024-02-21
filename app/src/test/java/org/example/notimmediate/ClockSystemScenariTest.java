package org.example.notimmediate;


import org.example.component.ClockSystem;
import org.example.state.alarm.TriggeredAlarm;
import org.example.state.clocktimer.DisplayClockTimerOff;
import org.example.state.clocktimer.DisplayClockTimerOn;
import org.example.state.stopwatch.DisplayStopWatchOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;


public class ClockSystemScenariTest {
	
	private ClockSystem cs;

	@BeforeEach
	public void test() {
		cs = new ClockSystem(); }
	
	/* The next test controls if this scenario(1) is correct :
	 * 		- Switch in ClockTimer
	 * 		- Put 2seconds, start the ClockTimer and so switch in DisplayClockTimerOn
	 * 		- Switch in another state and waiting for MORE than 2sec
	 * 		- Switch in ClockTimer and being in DisplayClockTimerOff */
	
	@Test
	public void scenarioOneTest() throws InterruptedException {
		
		cs.button1Pressed();
		
		// In ClockTimer
		
		cs.getClockTimer().getTime().setSecond(2);
		cs.button3Pressed();
		
		cs.button1Pressed();
		cs.button1Pressed();
		cs.button1Pressed();
		
		// In DisplayTime
		
		Thread.sleep(2100);
		
		cs.button1Pressed();
		
		assertSame(DisplayClockTimerOff.Instance(),cs.getState()); }
	
	/* The next test controls if this scenario(2) is correct :
	 * 		- Switch in ClockTimer
	 * 		- Put 2seconds, start the ClockTimer and so switch in DisplayClockTimerOn
	 * 		- Switch in another state and waiting for LESS than 2sec
	 * 		- Switch in ClockTimer and being in DisplayClockTimerOn */
	
	@Test 
	public void scenarioTwoTest() throws InterruptedException {
		
		cs.button1Pressed();
		
		// In ClockTimer
		
		cs.getClockTimer().getTime().setSecond(2);
		cs.button3Pressed();
		
		cs.button1Pressed();
		cs.button1Pressed();
		cs.button1Pressed();
		
		// In DisplayTime
		
		Thread.sleep(1000);
		
		cs.button1Pressed();
		
		assertSame(DisplayClockTimerOn.Instance(), cs.getState());
		}
	
	/* The next test controls if this scenario(3) is correct :
	 * 		- Switch in StopWatch
	 * 		- Switch in DisplayStopWatchOn
	 * 		- Switch in another state and waiting for 1sec
	 * 		- Switch in StopWatch and being in DisplayStopWatchOn */
	
	@Test 
	public void scenarioThreeTest() throws InterruptedException {
		
		cs.button1Pressed();
		cs.button1Pressed();
		
		// In StopWatchState
		
		cs.button3Pressed();
		
		cs.button1Pressed();
		cs.button1Pressed();
		cs.button1Pressed();
		
		// In ClockTimer
		
		Thread.sleep(1000);
		
		cs.button1Pressed();
		
		assertSame(DisplayStopWatchOn.Instance(), cs.getState());
		}
	
	/* The next test controls if this scenario(4) is correct :
	 * 		- Set Alarm at 00:00:02
	 * 		- Waiting for 2sec
	 * 		- Alarm is ringing (cs in TriggeredAlarm) ----> First test
	 * 		- Press button one
	 * 		- cs is not ringing anymore ----> second test */
	
	@Test 
	public void scenarioFourTest() throws InterruptedException {
		
		cs.getAlarm(0).getTime().setSecond(2);
		cs.getAlarm(0).setPowerState(true);
		
		Thread.sleep(2100);

		assertSame(TriggeredAlarm.Instance(), cs.getState());
		
		cs.button1Pressed();
		
		assertNotSame(TriggeredAlarm.Instance(), cs.getState()); }
	
	/* The next test controls if this scenario(5) is correct :
	 * 		- Set Alarm at 00:00:02
	 * 		- Switch in DisplayClockTimerOff
	 * 		- Alarm ring
	 * 		- Press button one
	 * 		- cs return in DisplayClockTimerOff */
	
	@Test 
	public void scenarioFiveTest() throws InterruptedException {
		
		cs.getAlarm(0).getTime().setSecond(2);
		cs.getAlarm(0).setPowerState(true);
		
		cs.button1Pressed();
		
		// In ClockTimer
		
		Thread.sleep(2100);

		// Alarm is triggering
		
		cs.button1Pressed();
		
		assertSame(DisplayClockTimerOff.Instance(), cs.getState());
		
		}
	
	/* The next test controls if this scenario(6) is correct :
	 * 		- Set Alarm at 00:00:01
	 * 		- Switch in DisplayClockTimerOff
	 * 		- Put 2sec to ClockTimer and switch it on
	 * 		- cs is in DisplayClockTimerOn ----> First test
	 * 		- Wait for 2.1sec
	 * 		- Press button one
	 * 		- cs return in DisplayClockTimerOff ----> Second test
	 * 
	 * This this is really useful because it controls if the memoryState of TriggeredAlarm
	 * is aware of the ClockTimer's change of state */
	
	@Test 
	public void scenarioSixTest() throws InterruptedException {
		
		cs.getAlarm(0).getTime().setSecond(1);
		cs.getAlarm(0).setPowerState(true);
		
		cs.button1Pressed();
		
		// In ClockTimer
		
		cs.getClockTimer().getTime().setSecond(2);
		cs.button3Pressed();
		
		assertSame(DisplayClockTimerOn.Instance(), cs.getState());
		
		Thread.sleep(2200);

		// Alarm is triggering
		
		cs.button1Pressed();
		
		assertSame(DisplayClockTimerOff.Instance(),cs.getState());
		}
	
	/* The next test controls if this scenario(7) is correct :
	 * 		- Set first alarm at 00:00:01
	 * 		- Set second alarm at 00:00:02
	 * 		- Switch in ClockTimerState 
	 * 		- Wait that both alarm ring
	 * 		- Stop alarm
	 * 		- cs is in ClockTimerState 
	 * 
	 * This is a really useful test because it controls if the second alarm triggered doesn't 
	 * take TriggeredAlarm as a memoryState (else, we got a cycle...) */
	
	@Test 
	public void scenarioSevenTest() throws InterruptedException {
		
		// first alarm:
		cs.getAlarm(0).getTime().setSecond(1);
		cs.getAlarm(0).setPowerState(true);
		// second alarm:
		cs.getAlarm(1).getTime().setSecond(2);
		cs.getAlarm(1).setPowerState(true);
		
		cs.button1Pressed();
		
		// In ClockTimer
		
		Thread.sleep(2100);

		// Alarm is triggering
		
		cs.button1Pressed();
		
		assertSame(DisplayClockTimerOff.Instance(), cs.getState()); }
	
	/* The next test controls if this scenario(8) is correct :
	 * 		- Set alarm at 01:00:00
	 * 		- Set time at 00:59:59
	 * 		- Wait for 1sec
	 * 		- Alarm is ringing
	 * 
	 * This is a useful test  because it checks if the time modification doesn't influence
	 * the alarm */
	
	@Test 
	public void scenarioEigthTest() throws InterruptedException {
		
		cs.getAlarm(0).getTime().setHour(1);
		cs.getAlarm(0).setPowerState(true);

		
		cs.getTime().setMinute(59);
		cs.getTime().setSecond(59);
		
		Thread.sleep(1100);

		// Alarm is triggering
		assertSame(TriggeredAlarm.Instance(), cs.getState());
		}
	}
