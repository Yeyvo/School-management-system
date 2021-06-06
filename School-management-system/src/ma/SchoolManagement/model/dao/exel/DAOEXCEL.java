package ma.SchoolManagement.model.dao.exel;

import java.util.Set;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class DAOEXCEL<T> {


	
	public abstract boolean exportdata(Set<T> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase, CellStyle datecell);

	public abstract boolean importdata(Workbook wb);



}
