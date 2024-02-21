package org.example.state.compositestate.time;

import org.example.component.ClockSystem;
import org.example.utility.Time;

abstract public class TimeSettingState extends TimeState {

	public Time getObservedTime(ClockSystem context) {
		return context.getDisplayState().getObservedTime(context); } 
	
	public String getIcon(ClockSystem context) {
		return context.getDisplayState().getIcon(context); }
}
