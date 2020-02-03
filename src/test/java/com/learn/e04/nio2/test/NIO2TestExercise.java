package com.learn.e04.nio2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.learn.e04.nio2.service.NIO2ExerciseService;

@RunWith(MockitoJUnitRunner.class)
public class NIO2TestExercise {

	@InjectMocks
	private NIO2ExerciseService nio2ExerciseService;
	private static final String FILE_NAME = "input.txt";

	@Test
	public void testGetExpiredTablets() {
		Map<String, String> expectedValue = new HashMap<>();
		expectedValue.put("expiredM1", "12/12/2018");
		Map<String, String> actualValue = nio2ExerciseService.getExpiredTablets(FILE_NAME, "gsk");
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testGetExpiredTabletsNegativeScenario() {
		assertNull(nio2ExerciseService.getExpiredTablets("hello.csv", "piramal"));
	}
	
	
	@Test
	public void testCheckIfFileIsPresent() {
		assertEquals(true, nio2ExerciseService.checkIfFileIsPresent(FILE_NAME,"src"));
	}
	
	@Test
	public void testDateCompareEqualsCondition() {
		assertEquals(false, nio2ExerciseService.dateCompare("10/10/2020","12/01/2030"));
	}
	

}
