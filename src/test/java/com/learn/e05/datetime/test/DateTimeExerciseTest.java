package com.learn.e05.datetime.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import com.learn.e05.datetime.service.DateTimeExerciseService;

@RunWith(MockitoJUnitRunner.class)
public class DateTimeExerciseTest {
	
	@InjectMocks
	private DateTimeExerciseService dateTimeExerciseService;
	
	@Test
	public  void getExpiringTables(){
		List<String> expectedTabletList = Arrays.asList("Crocin","Dolo","Saridon","Cetrizine","Medicine1","Medicine2","Medicine3","Med_Exp1","Med_Exp2");
		assertEquals(expectedTabletList, dateTimeExerciseService.getExpiringTables(36));
	}
	
	@Test
	public void getExpiringTabletsSorted() {
		assertNotNull(dateTimeExerciseService.getExpiringTabletsSorted());
		
	}
	
	@Test
	public void getTabletExpiryPeriod() {
		assertNotNull(dateTimeExerciseService.getTabletExpiryPeriod());
	}
	
	
	@Test
	public void getSameYearExpiry() {
		assertNotNull(dateTimeExerciseService.getSameYearExpiry());
	}
}
