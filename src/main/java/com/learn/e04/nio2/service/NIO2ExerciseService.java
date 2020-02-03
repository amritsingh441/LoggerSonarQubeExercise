package com.learn.e04.nio2.service;

import java.util.Map;

import com.learn.e04.nio2.NIO2Exercise;

public class NIO2ExerciseService {

	private NIO2Exercise nio2Exercise =  new NIO2Exercise();
	
	public  Map<String, String> getExpiredTablets(String fileName, String manufacturer) {
		return nio2Exercise.getExpiredTablets(fileName,manufacturer);
	}

	public boolean checkIfFileIsPresent(String fileName, String absolutePath) {
	return nio2Exercise.checkIfFileIsPresent(fileName, absolutePath);
	}
	
	public  boolean dateCompare(String todayDate,String expiryDate) {
		return nio2Exercise.dateCompare(todayDate, expiryDate);
	}

}
