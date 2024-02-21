package org.example.state.time;

import java.awt.Color;

import org.example.component.*;
import org.example.state.compositestate.time.TimeDisplayState;
import org.example.utility.Time;

public class DisplayNormalTime extends TimeDisplayState {
	
	// use Singleton design pattern
	private static DisplayNormalTime instance;
	private DisplayNormalTime() { // make default constructor private
			BUTTON_ONE_NAME = "MODE";
			BUTTON_TWO_NAME = "SET";
			BUTTON_THREE_NAME = "DISPLAY MODE";
	}
	public static DisplayNormalTime Instance() {
		if (instance==null) {
			instance = new DisplayNormalTime(); }
		return instance; }
	
	public void button1Pressed(ClockSystem context) {
		context.setState(context.getClockTimer().getPowerState()); }

	public void button2Pressed(ClockSystem context) {
		if (context.hasClock()) {
			context.getClock().setHourColor(new Color(46,127, 189)); }
		context.setState(TimeHourSetting.Instance());
		context.getTimer().cancel(); }

	public void button3Pressed(ClockSystem context) {
		context.setDisplayState(DisplayBritishTime.Instance()) ;
		context.setState(DisplayBritishTime.Instance()); }

	public Time getObservedTime(ClockSystem context) {
		return context.getTime(); } }
