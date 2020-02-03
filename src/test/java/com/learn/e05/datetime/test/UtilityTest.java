package com.learn.e05.datetime.test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.learn.e05.datetime.service.UtilityService;

@RunWith(MockitoJUnitRunner.class)
public class UtilityTest {
	
	@InjectMocks
	private UtilityService utilityService;
	
	@Test
	public void getBusSchedule() {
		
		Duration duration = Duration.ofMinutes(120);
		List<String> expected = Arrays.asList("11::30","13::30","15::30","17::30","19::30","21::30","23::30");
		assertEquals(expected, utilityService.getBusSchedule("11:30", duration));
		
	}

}
