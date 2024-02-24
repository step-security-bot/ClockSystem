package org.example.state.time;

import java.awt.Color;

import org.example.component.*;
import org.example.state.compositestate.time.TimeDisplayState;
import org.example.utility.Time;

public class DisplayBritishTime extends TimeDisplayState {
	
	//use Singleton design pattern
	private static DisplayBritishTime instance;
	private DisplayBritishTime() { // make default constructor private
			BUTTON_ONE_NAME = "MODE";
			BUTTON_TWO_NAME = "SET";
			BUTTON_THREE_NAME = "DISPLAY MODE";
	}

	public static DisplayBritishTime getInstance() {
		if (instance==null) {
			instance = new DisplayBritishTime(); }
		return instance; }

	@Override
	public void button1Pressed(ClockSystem context) {
		context.setState(context.getClockTimer().getPowerState()); }

	@Override
	public void button2Pressed(ClockSystem context) {
		if (context.hasClock()) {
			context.getClock().setHourColor(new Color(46,127, 189)); }
		context.setState(TimeHourSetting.getInstance());
		context.getTimer().cancel(); }

	@Override
	public void button3Pressed(ClockSystem context) {
		context.setDisplayState(DisplayNormalTime.Instance()) ;
		context.setState(DisplayNormalTime.Instance()); }

	public Time getObservedTime(ClockSystem context) {
		Time myTime = context.getTime();
		if (myTime.getHour()==0) {
			return new Time(12, myTime.getMinute(), myTime.getSecond()); }
		else if (myTime.getHour()>12) {
			return new Time(myTime.getHour()-12, myTime.getMinute(), myTime.getSecond()); }
		else {
			return myTime; } }

	@Override
	public String getIcon(ClockSystem context) {
		if(context.getTime().getHour()>=12) {
			return " PM"; }
		else {
			return " AM"; } } }
