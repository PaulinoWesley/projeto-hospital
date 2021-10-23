package com.br.hospital.wesley.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {	
	public static LocalDate stringToDate(String dateAsString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		formatter = formatter.withLocale( putAppropriateLocaleHere );  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
		return LocalDate.parse(dateAsString, formatter);
	}

}
