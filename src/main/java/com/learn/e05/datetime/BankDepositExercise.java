package com.learn.e05.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class BankDepositExercise {
	
	private static final Logger logger = LoggerFactory.getLogger(BankDepositExercise.class);

	/*
	 * Define the below static methods:
	 * 
	 * - getMaturityDate(String investmentDate, Period duration): - Method should
	 * take investment date and duration as input and return the maturity date as a
	 * string in the format <dd-mmm-yyyy> 
	 * 
	 * - getInvestmentPeriod(String investmentDate, String maturityDate) - Method should take investment date and
	 * maturity dates as input and return the duration as a string in the format <x
	 * years, y months>
	 * 
	 * The investment and maturity date can be in either of the formats <dd/mm/yyyy,
	 * dd-mm-yyyy>. Test the above methods
	 */
	
	public  String getMaturityDate(String investmentDate , Period duration) {

		logger.debug("Entering in getMaturityDate method");
		DateTimeFormatter dtFormatter1 = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd/MM/yyyy]");
		LocalDate lDate = LocalDate.parse(investmentDate, dtFormatter1);
		DateTimeFormatter dtFormatter2 = DateTimeFormatter.ofPattern("[dd-MMM-yyyy]");
		LocalDate maturityDate = lDate.plusYears(duration.getYears()).plusMonths(duration.getMonths()).plusDays(duration.getDays());
		return maturityDate.format(dtFormatter2);
	}

	public  String getInvestmentPeriod(String investmentDate , String maturityDate) {

		logger.debug("Entering in getInvestmentPeriod method");
		DateTimeFormatter dtFormatter1 = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd/MM/yyyy]");
		LocalDate iDate = LocalDate.parse(investmentDate, dtFormatter1);
		LocalDate mDate = LocalDate.parse(maturityDate, dtFormatter1);
		
		Period duration = Period.between(iDate, mDate);
		int years = duration.getYears();
		int months = duration.getMonths();
		return Integer.toString(years) +" years, "+Integer.toString(months)+" months";
	}

}
