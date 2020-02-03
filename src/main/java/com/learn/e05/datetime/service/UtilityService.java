package com.learn.e05.datetime.service;

import java.time.Duration;
import java.util.List;

import com.learn.e05.datetime.Utility;

public class UtilityService {

	private Utility utility = new Utility();
	
	public  List<String>  getBusSchedule(String start, Duration frequency) {
		return utility.getBusSchedule(start, frequency);
	}
}
