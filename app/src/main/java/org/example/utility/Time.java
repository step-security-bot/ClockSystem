package org.example.utility;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	public Time() { 
		hour=0;
		minute=0;
		second=0; }
	
	public Time(int h, int m, int s) {
		hour=h;
		minute=m;
		second=s; }
	
	public int getHour() {
		return hour; }

	public int getMinute() {
		return minute; }

	public int getSecond() {
		return second; }
	
	public void setHour(int h) {
		hour=h; }

	public void setMinute(int m) {
		minute=m; }

	public void setSecond(int s) {
		second=s; }

	public void increaseHour() {
		if (hour==23) {
			hour=0; }
		else {
			hour+=1;} }

	public void increaseMinute() {
		if (minute==59) {
			minute=0; }
		else {
			minute+=1;} }
			
	public void increaseSecond() {
		if (second==59) {
			second=0; }
		else {
			second+=1;} }

	public void decreaseHour() {
		if (hour==0) {
			hour=23; }
		else {
			hour-=1;} }

	public void decreaseMinute() {
		if (minute==0) {
			minute=59; }
		else {
			minute-=1;} }

	public void decreaseSecond() {
		if (second==0) {
			second=59; }
		else {
			second-=1;} }

	public void tickUp() {
		if (second==59) {
			if (minute==59) {
				if (hour==23) {
					hour=0;
					minute=0;
					second=0; }
				else {
					hour+=1;
					minute=0;
					second=0; } }
			else {
				minute+=1;
				second=0; } }
		else {
			second+=1; } }

	public void tickDown() {
		if (second==0) {
			if (minute==0) {
				if (hour==0) {
					hour=23;
					minute=59;
					second=59; }
				else {
					hour-=1;
					minute=59;
					second=59; } }
			else {
				minute-=1;
				second=59; } }
		else {
			second-=1; } }

	public boolean equals(Time t) {
		if (this.second==t.getSecond() & this.minute==t.getMinute() & this.hour==t.getHour()) {
			return true; }
		else {
			return false; } }
	
	public String hourToString() {
		String hourString = (new Integer(hour)).toString();
		if (hour<10) {
			hourString = "0"+hourString; }
		return hourString; }
	
	public String minuteToString() {
		String minuteString = (new Integer(minute)).toString();
		if (minute<10) {
			minuteString = "0"+minuteString; }
		return minuteString; }
	
	public String secondToString() {
		String secondString = (new Integer(second)).toString();
		if (second<10) {
			secondString = "0"+secondString; }
		return secondString; }
	
	public String toString() {
		String hourString = (new Integer(hour)).toString();
		String minuteString = (new Integer(minute)).toString();
		String secondString = (new Integer(second)).toString();		
		if (hour<10) {
			hourString = "0"+hour; }
		if (minute<10) {
			minuteString = "0"+minute; }
		if (second<10) {
			secondString = "0"+second; }
		return hourString+":"+minuteString+":"+secondString; }
		
	public boolean isZero() {
		return (hour==0 & minute==0 & second==0); }
	
	public boolean isOne() {
		return (hour==0 & minute==0 & second==1); } }
