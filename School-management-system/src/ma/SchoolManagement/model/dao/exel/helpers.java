package ma.SchoolManagement.model.dao.exel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class helpers {
	private static String getExtension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');
		if (i > 0 && i < fileName.length() - 1) // if the name is not empty
			return fileName.substring(i + 1).toLowerCase();

		return extension;
	}
	
	public static LocalDate convertToLocalDate(Date dateToConvert) {
		if(dateToConvert == null)
			return null;
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
