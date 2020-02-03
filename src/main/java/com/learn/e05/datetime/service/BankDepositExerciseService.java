package com.learn.e05.datetime.service;

import java.time.Period;

import com.learn.e05.datetime.BankDepositExercise;

 public class BankDepositExerciseService {
	
	private BankDepositExercise bankDepositExercise = new BankDepositExercise();
	
	public String getMaturityDate(String investmentDate , Period duration) {
		return bankDepositExercise.getMaturityDate(investmentDate, duration);
	}
	
	public String getInvestmentPeriod(String investmentDate , String maturityDate) {
		return bankDepositExercise.getInvestmentPeriod(investmentDate, maturityDate);
	}

}
