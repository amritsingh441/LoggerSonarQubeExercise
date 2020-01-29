package com.learn.e04.nio2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NIO2Exercise {
	
	private NIO2Exercise () {}
	
	private static final Logger logger = LoggerFactory.getLogger(NIO2Exercise.class);
	private static final String FILE_PATH = "src/data";
	private static final String FILE_NAME = "input.txt";
	

	public static Map<String, String> getExpiredTablets(String fileName, String manufacturer) {

		//try(Stream<String> fileData = Files.lines(Paths.get("data","input.txt")))
		try(Stream<String> fileData = Files.newBufferedReader(Paths.get(FILE_PATH,fileName)).lines())
		{
			List<String []> records = fileData.map(input ->input.split(",")).collect(Collectors.toList());
			Date date = new Date();
			SimpleDateFormat formatter = new  SimpleDateFormat("dd/MM/yyyy");
			String todayDate = formatter.format(date);
			return records.stream()
					.filter(str ->str[1].equalsIgnoreCase(manufacturer) && dateCompare(todayDate,str[3]))
					.collect(Collectors.toMap(str -> str[0], str -> str[3]));
			
			
		}catch(IOException ioe) {
			logger.debug(ioe.getMessage());
		}
		return null;

	}
	
	public static void writeData(String data) {
		
		try(BufferedWriter br = Files.newBufferedWriter(Paths.get(FILE_PATH,FILE_NAME), StandardOpenOption.APPEND))
		{
			br.newLine();
			br.write(data);
			
		}catch(IOException ioe) {
			logger.debug(ioe.getMessage());
			
		}
		
	}
	
	public static boolean dateCompare(String todayDate,String expiryDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(sdf.parse(todayDate).after(sdf.parse(expiryDate))) {
				return true;
			}
		}catch(ParseException pe) {
			logger.debug(pe.getMessage());
		}

		return false;
	}

	public static void getAllJavaFilesFromDirectory() {

		try(Stream<Path> path = Files.walk(Paths.get("src")))
		{
			path.filter(s -> s.toString().endsWith(".java")).forEach(msg -> logger.info(msg.toString()));

		}catch(IOException ioe) {
			logger.debug(ioe.getMessage());
		}

	}

	public static boolean checkIfFileIsPresent(String fileName, String absolutePath) {

		try(Stream<Path> path = Files.walk(Paths.get("src")))
		{
			Long totalCount = path.filter(s -> s.toString().contains(fileName) && s.toString().contains(absolutePath)).count();
			if(totalCount>0) {
				return true;
			}
		}catch(IOException ioe) {
			logger.debug(ioe.getMessage());
		}

		return false;
	}


}
