package com.learn.e05.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkingDaysExercise {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkingDaysExercise.class);
	
	/*
	 * getNextMonthsWorkingDays():List<String> - Method should return a List of
	 * String containing the working days for the next month given todays date. -
	 * Saturday and Sunday should be considered non working days - The date returned
	 * should be in format dd-mm-yyyy
	 */
	
	public List<String> getNextMonthWorkingDays(LocalDate todayDate){
		logger.debug("Entering in getNextMonthWorkingDays method");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy]");
		
	LocalDate firstDayOfNextMonth = todayDate.with(TemporalAdjusters.firstDayOfNextMonth());
	LocalDate lastDayOfNextMonth = firstDayOfNextMonth.with(TemporalAdjusters.lastDayOfMonth());
	return firstDayOfNextMonth.datesUntil(lastDayOfNextMonth.plusDays(1))
			.filter(f -> f.getDayOfWeek().getValue() != 6 && f.getDayOfWeek().getValue()!=7)
			.map(date -> date.format(formatter))
			.collect(Collectors.toList());
	}
	

}
