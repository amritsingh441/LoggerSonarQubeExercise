package com.learn.e05.datetime.service;

import java.time.LocalDate;
import java.util.List;

import com.learn.e05.datetime.WorkingDaysExercise;

public class WorkingDaysExerciseService {
	
	private WorkingDaysExercise workingDaysExercise = new WorkingDaysExercise();
	
	public List<String> getNextMonthWorkingDays(LocalDate todayDate){
		return workingDaysExercise.getNextMonthWorkingDays(todayDate);
	}

}
