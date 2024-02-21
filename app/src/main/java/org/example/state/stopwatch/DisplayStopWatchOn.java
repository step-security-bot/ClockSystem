package org.example.state.stopwatch;

import org.example.component.*;
import org.example.state.alarm.DisplayAlarm;
import org.example.state.compositestate.stopwatch.StopWatchDisplayState;

public class DisplayStopWatchOn extends StopWatchDisplayState {
	
	// use Singleton Design Pattern
	private static StopWatchDisplayState instance;
	private DisplayStopWatchOn() {  // make default constructor private
		BUTTON_ONE_NAME = "MODE";
		BUTTON_TWO_NAME = "ADD MEMO";
		BUTTON_THREE_NAME = "OFF";
	}
	
	public static StopWatchDisplayState Instance() {
		if (instance==null) {
			instance = new DisplayStopWatchOn(); }
		return instance; }
	
	public void button1Pressed(ClockSystem context) {
		DisplayAlarm state = DisplayAlarm.Instance(); 
		if (context.hasClock()) {
			state.setClockColor(context); }
		context.setState(state); }

	public void button2Pressed(ClockSystem context) {
		context.getStopWatch().addMemoryTime(); }

	public void button3Pressed(ClockSystem context) {
		context.getStopWatch().stop();
		context.setState(DisplayStopWatchOff.Instance()); }

}