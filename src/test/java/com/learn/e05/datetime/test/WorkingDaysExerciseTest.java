package com.learn.e05.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.learn.e05.datetime.service.WorkingDaysExerciseService;

@RunWith(MockitoJUnitRunner.class)
public class WorkingDaysExerciseTest {
	
	@InjectMocks
	private WorkingDaysExerciseService workingDaysExerciseService;
	
	@Test
	public void getNextMonthWorkingDays() {
		List<String> expectedDateList = Arrays.asList("03-02-2020","04-02-2020","05-02-2020","06-02-2020","07-02-2020","10-02-2020","11-02-2020","12-02-2020","13-02-2020","14-02-2020","17-02-2020","18-02-2020","19-02-2020","20-02-2020","21-02-2020","24-02-2020","25-02-2020","26-02-2020","27-02-2020","28-02-2020");
		assertEquals(expectedDateList,workingDaysExerciseService.getNextMonthWorkingDays(LocalDate.of(2020, 01, 31)));
	}

}
