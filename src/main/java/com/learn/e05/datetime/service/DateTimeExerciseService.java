package com.learn.e05.datetime.service;

import java.util.List;
import java.util.Map;

import com.learn.e05.datetime.DateTimeExercise;
import com.learn.e05.datetime.Tablet;

public class DateTimeExerciseService {
	
	private DateTimeExercise dateTimeExercise = new DateTimeExercise();
	
	public  List<String> getExpiringTables(int months){
		return dateTimeExercise.getExpiringTables(months);
	}
	
	public  List<Tablet> getExpiringTabletsSorted(){
		return dateTimeExercise.getExpiringTabletsSorted();
	}
	
	public  Map<String, String> getTabletExpiryPeriod() {
		return dateTimeExercise.getTabletExpiryPeriod();
	}

	public  Map<String,List<String>> getSameYearExpiry() {
		return dateTimeExercise.getSameYearExpiry();
	}
}
