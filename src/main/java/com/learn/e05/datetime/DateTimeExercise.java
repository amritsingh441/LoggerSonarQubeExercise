package com.learn.e05.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DateTimeExercise {
	
private DateTimeExercise() {}

	/*
	 * Create a class Tablet with attributes,tablet name, manufacturer, manufacture
	 * date and expiry date(LocalDate).
	 *  - Create a class DateTimeExercise with the
	 * following methods and variables 
	 * - create a variable tablets of type
	 * ArrayList<Tablet> and initialize with some tablet objects
	 * 
	 * - getExpiringTables(int months):List<String> - method should take number of
	 * months as parameter and return a List of tablet names expiring within the
	 * given months from today.
	 * 
	 * - getExpiringTabletsSorted - return a List of Tablets, in the ascending order
	 * of expiry date
	 * 
	 * - getTabletExpiryPeriod - return a Map with the tablet name as key and the
	 * period between the manufacture date and expiry date as value. The period
	 * should be a string containing years, months and days (ex: 1 year/s 2 month/s
	 * 5 day/s , 3 month/s 5 day/s, 3 year/s ..) 
	 * 
	 * - getSameYearExpiry - Return a Map
	 * with key as manufacturer and value as list of tablet names which are
	 * manufactured in the current year and are already expired
	 */

	private static List<Tablet> tabletList = new ArrayList<>();



	static {

		tabletList.add(new Tablet("Crocin", "GSK", LocalDate.of(2020, 01, 12), LocalDate.of(2022, 01, 12)));
		tabletList.add(new Tablet("Calpol", "GSK", LocalDate.of(2019, 01, 26), LocalDate.of(2024, 12, 31)));
		tabletList.add(new Tablet("Dolo", "MicroLabs", LocalDate.of(2017, 03, 01), LocalDate.of(2021, 12, 31)));
		tabletList.add(new Tablet("Saridon", "Piramal", LocalDate.of(2019, 12, 01), LocalDate.of(2022, 07, 01)));
		tabletList.add(new Tablet("Cetrizine", "Dihal", LocalDate.of(2020, 04, 17), LocalDate.of(2022, 10, 01)));
		tabletList.add(new Tablet("Amoxycilin", "Mylan", LocalDate.of(2020, 12, 01), LocalDate.of(2024, 8, 23)));
		tabletList.add(new Tablet("Medicine1", "Manfctr1", LocalDate.of(2016, 10, 01), LocalDate.of(2018, 8, 23)));
		tabletList.add(new Tablet("Medicine2", "Manfctr2", LocalDate.of(2014, 10, 01), LocalDate.of(2016, 8, 23)));
		tabletList.add(new Tablet("Medicine3", "Manfctr3", LocalDate.of(2019, 01, 01), LocalDate.of(2019, 12, 23)));
		tabletList.add(new Tablet("Med_Exp1", "Manfctr4", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 27)));
		tabletList.add(new Tablet("Med_Exp2", "Manfctr5", LocalDate.of(2020, 01, 11), LocalDate.of(2020, 01, 26)));
	}

	public static List<String> getExpiringTables(int months){
		return tabletList.stream()
				.filter(tablet -> ChronoUnit.MONTHS.between(LocalDate.now(), tablet.getExpiryDate()) < months) 
				.map(Tablet :: getTabletName).collect(Collectors.toList());

	}


	public static List<Tablet> getExpiringTabletsSorted(){

		return tabletList.stream()
				.filter(tablet -> ChronoUnit.DAYS.between(LocalDate.now(), tablet.getExpiryDate()) < 0)
				.sorted(Comparator.comparing(Tablet :: getExpiryDate))
				.collect(Collectors.toList());

	}

	public static Map<String, String> getTabletExpiryPeriod() {

		return tabletList.stream()
				.collect(Collectors.toMap(Tablet :: getTabletName, 
						(tablet -> {
							Period p =Period.between(tablet.getManufactureDate(), tablet.getExpiryDate());
							StringBuilder sb = new StringBuilder();
							if(p.getYears()>0) { sb.append(p.getYears()+" year/s ");}
							if(p.getMonths()>0) { sb.append(p.getMonths()+" month/s ");}
							if(p.getDays()>0) { sb.append(p.getDays()+" day/s ");}
							return sb.toString();})));
	}
	
	public static Map<String,List<String>> getSameYearExpiry() {
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		return tabletList.stream()
				.filter(tablet -> tablet.getManufactureDate().getYear() == currentYear && 
						ChronoUnit.DAYS.between(today, tablet.getExpiryDate()) < 0)
				.collect(Collectors.groupingBy(Tablet :: getManufacturer,
						Collectors.mapping(Tablet :: getTabletName, Collectors.toList())));
	}


}
