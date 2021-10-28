package com.br.hospital.wesley.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {	
	public static LocalDate stringToDate(String dateAsString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(dateAsString, formatter);
	}
	
	public static LocalDateTime stringToDateTime(String dateAsString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return LocalDateTime.parse(dateAsString, formatter);
	}

}
