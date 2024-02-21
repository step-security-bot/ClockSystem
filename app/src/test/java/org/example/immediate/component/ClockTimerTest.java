package org.example.immediate.component;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.component.ClockTimer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ClockTimerTest {
	
	private ClockTimer ct;

	@BeforeEach
	public void setUp() {
		ct = new ClockTimer(); }
	
	@Test
	public void startInZeroTest() {
		ct.start();
		assertTrue(ct.getTime().isZero()); } }
