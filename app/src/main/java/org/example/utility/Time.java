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
		hour = (hour + 1) % 24; }

	public void increaseMinute() {
		minute = (minute + 1) % 60; }

	public void increaseSecond() {
		second = (second + 1) % 60; }

	public void decreaseHour() {
		hour = (hour - 1) % 24; }

	public void decreaseMinute() {
		minute = (minute - 1) % 60; }

	public void decreaseSecond() {
		second = (second - 1) % 60; }

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
		return (this.second==t.getSecond() & this.minute==t.getMinute() & this.hour==t.getHour()); }

	public String toString(int v) {
		String s = String.valueOf(v);
		if (v<10) s = "0"+s;
		return s; }

	public boolean isZero() {
		return (hour==0 & minute==0 & second==0); }
	
	public boolean isOne() {
		return (hour==0 & minute==0 & second==1); } }
