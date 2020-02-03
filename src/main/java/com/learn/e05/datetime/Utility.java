package com.learn.e05.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utility {
	
	
	private static final Logger logger = LoggerFactory.getLogger(Utility.class);
	
	/*
	 * - getBusSchedule(String start, Duration frequency) : List<String> - Method
	 * should return a List of String containing the bus timings for a day given the
	 * start time and duration as parameters. - The timing in the list should be in
	 * 24 hour format hh:mm
	 */
	
	public  List<String>  getBusSchedule(String start, Duration frequency) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[HH::mm]");
		LocalTime startTime = LocalTime.parse(start);
		LocalTime endTime = LocalTime.MIDNIGHT;
		int gap = (int) frequency.toMinutes();
		List<String> busTimings = new ArrayList();
		int startMinVal = startTime.getHour()*60 + startTime.getMinute();
		int endMinVal = endTime.minusHours(1).getHour()*60 + endTime.minusMinutes(1).getMinute();
		  while(endMinVal - startMinVal > gap) {
		  busTimings.add(startTime.format(formatter));
		  startTime = startTime.plusMinutes(gap);
		  startMinVal = startMinVal+gap;
		  
		  }
		  busTimings.add(startTime.format(formatter));
		  busTimings.forEach(logger::debug);
		
		return busTimings;
	}

}
