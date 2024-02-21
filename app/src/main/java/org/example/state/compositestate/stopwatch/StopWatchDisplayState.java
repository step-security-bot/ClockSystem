package org.example.state.compositestate.stopwatch;

import org.example.component.*;
import org.example.utility.Time;

abstract public class StopWatchDisplayState extends StopWatchState {

	public String getLineInfo1(ClockSystem context) {
		Time time = context.getStopWatch().getMemoryTime().get(2);
		if (time!=null) {
			return "      "+time.toString(); }
		else {
			return ""; } }
	
	public String getLineInfo2(ClockSystem context) {
		Time time = context.getStopWatch().getMemoryTime().get(1);
		if (time!=null) {
			return "      "+time.toString(); }
		else {
			return ""; } }
	
	public String getLineInfo3(ClockSystem context) {
		Time time = context.getStopWatch().getMemoryTime().get(0);
		if (time!=null) {
			return "      "+time.toString(); }
		else {
			return ""; } }
	
}
