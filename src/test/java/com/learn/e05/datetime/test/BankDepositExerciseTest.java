package com.learn.e05.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.Period;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.learn.e05.datetime.service.BankDepositExerciseService;

@RunWith(MockitoJUnitRunner.class)
public class BankDepositExerciseTest {
	
	@InjectMocks
	private BankDepositExerciseService bankDepositExerciseService;
	
	@Test
	public void getMaturityDate() {
		String expectedVal = "26-Feb-2020";
		Period duration = Period.ofDays(6);
		assertEquals(expectedVal, bankDepositExerciseService.getMaturityDate("20-02-2020", duration));
	}
	
	@Test
	public void getInvestmentPeriod() {
		assertEquals("4 years, 4 months", bankDepositExerciseService.getInvestmentPeriod("20-02-2020", "20-06-2024"));
	}
	

}
