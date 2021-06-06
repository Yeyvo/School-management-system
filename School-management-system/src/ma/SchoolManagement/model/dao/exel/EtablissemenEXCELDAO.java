package ma.SchoolManagement.model.dao.exel;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.dao.DAOFactory;

public class EtablissemenEXCELDAO extends DAOEXCEL<Etablissement> {



	@Override
	public boolean exportdata(Set<Etablissement> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase, CellStyle datecell) {
		int rowC = 1;

		XSSFRow r = sheet.createRow(1);

		Cell cell1 = r.createCell(0);
		cell1.setCellValue("CodeEtab");
		cell1.setCellStyle(stylecellhead);

		Cell cell2 = r.createCell(1);
		cell2.setCellValue("DesEtab");
		cell2.setCellStyle(stylecellhead);

		Cell cell3 = r.createCell(2);
		cell3.setCellValue("EtudDPM");
		cell3.setCellStyle(stylecellhead);

		for (Etablissement data : dataset) {
			XSSFRow row = sheet.createRow(++rowC);
			writeEtablissement(data, row, stylecellbase);
		}
		
		for (int y = 0; y < sheet.getRow(1).getPhysicalNumberOfCells(); y++) {
			sheet.autoSizeColumn(y);
		}
		
		
		return true;
	}
	
	private void writeEtablissement(Etablissement data, XSSFRow row, CellStyle stylecellbase) {
		Cell cell1 = row.createCell(0);
		cell1.setCellValue(data.getCodeEtab());
		cell1.setCellStyle(stylecellbase);

		Cell cell2 = row.createCell(1);
		cell2.setCellValue(data.getDesEtab());
		cell2.setCellStyle(stylecellbase);

		Cell cell3 = row.createCell(2);
		cell3.setCellValue(data.getEtudDPM());
		cell3.setCellStyle(stylecellbase);
	}


	@Override
	public boolean importdata(Workbook wb) {

		Sheet firstSheet = wb.getSheetAt(1);
		Iterator<Row> rowIterator = firstSheet.iterator();

		rowIterator.next();
//			rowIterator.next(); 
		// skip the header row
		DataFormatter formatter = new DataFormatter();
		while (rowIterator.hasNext()) {
			Row nextRow = rowIterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			if (cellIterator.hasNext()) {

//							int id = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
				int CodeEtab = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
				String DesEtab = formatter.formatCellValue(cellIterator.next()),
						EtudDPM = formatter.formatCellValue(cellIterator.next());
				Etablissement etab = new Etablissement(CodeEtab, DesEtab, EtudDPM);
				if (!DAOFactory.getSQLDAOFactory().getEtablissementDAO().create(etab)) {
					Alert alert = new Alert(AlertType.WARNING,
							"erreur dans la donée Etablissement : " + etab.toString());
					alert.show();
					return false;
				}

			}
		}
		return true;
	}

}
