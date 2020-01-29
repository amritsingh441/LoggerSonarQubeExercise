package com.learn.e05.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingDaysExercise {
	
private WorkingDaysExercise () {}
	
	/*
	 * getNextMonthsWorkingDays():List<String> - Method should return a List of
	 * String containing the working days for the next month given todays date. -
	 * Saturday and Sunday should be considered non working days - The date returned
	 * should be in format dd-mm-yyyy
	 */
	
	public static List<String> getNextMonthWorkingDays(LocalDate todayDate){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy]");
		
	LocalDate firstDayOfNextMonth = todayDate.with(TemporalAdjusters.firstDayOfNextMonth());
	LocalDate lastDayOfNextMonth = firstDayOfNextMonth.with(TemporalAdjusters.lastDayOfMonth());
	return firstDayOfNextMonth.datesUntil(lastDayOfNextMonth.plusDays(1))
			.filter(f -> f.getDayOfWeek().getValue() != 6 && f.getDayOfWeek().getValue()!=7)
			.map(date -> date.format(formatter))
			.collect(Collectors.toList());
	}
	

}
