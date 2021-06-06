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
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.dao.DAOFactory;

public class InscriptionEXCELDAO extends DAOEXCEL<Inscription> {

	@Override
	public boolean exportdata(Set<Inscription> dataset, XSSFSheet sheet, XSSFWorkbook workbook, CellStyle stylecellhead,
			CellStyle stylecellbase, CellStyle datecell) {
		int rowC = 1;

		XSSFRow r = sheet.createRow(1);

		Cell cell1 = r.createCell(0);
		cell1.setCellValue("EtudId");
		cell1.setCellStyle(stylecellhead);

		Cell cell2 = r.createCell(1);
		cell2.setCellValue("EtudEtab");
		cell2.setCellStyle(stylecellhead);

		Cell cell3 = r.createCell(2);
		cell3.setCellValue("EtudFil");
		cell3.setCellStyle(stylecellhead);

		Cell cell4 = r.createCell(3);
		cell4.setCellValue("EtudInsc");
		cell4.setCellStyle(stylecellhead);

		for (Inscription data : dataset) {
			XSSFRow row = sheet.createRow(++rowC);
			writeInscription(data, row, stylecellbase);
		}
		
		
		for (int y = 0; y < sheet.getRow(1).getPhysicalNumberOfCells(); y++) {
			sheet.autoSizeColumn(y);
		}
		
		
		return true;
	}

	private void writeInscription(Inscription data, XSSFRow row, CellStyle stylecellbase) {
		Cell cell1 = row.createCell(0);
		cell1.setCellValue(data.getEtudId());
		cell1.setCellStyle(stylecellbase);

		Cell cell2 = row.createCell(1);
		cell2.setCellValue(data.getEtudEtab());
		cell2.setCellStyle(stylecellbase);

		Cell cell3 = row.createCell(2);
		cell3.setCellValue(data.getEtudFil());
		cell3.setCellStyle(stylecellbase);

		Cell cell4 = row.createCell(3);
		cell4.setCellValue(data.getEtudInsc());
		cell4.setCellStyle(stylecellbase);

	}

	@Override
	public boolean importdata(Workbook wb) {

		Sheet firstSheet = wb.getSheetAt(3);
		Iterator<Row> rowIterator = firstSheet.iterator();

		rowIterator.next();
//			rowIterator.next(); 
		// skip the header row
		DataFormatter formatter = new DataFormatter();
		while (rowIterator.hasNext()) {
			Row nextRow = rowIterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			if (cellIterator.hasNext()) {

				int EtudId = Integer.valueOf(formatter.formatCellValue(cellIterator.next())),
						EtudEtab = Integer.valueOf(formatter.formatCellValue(cellIterator.next())),
						EtudFil = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
				String EtudInsc = formatter.formatCellValue(cellIterator.next());
				Inscription ins = new Inscription(EtudId, EtudEtab, EtudFil, EtudInsc);
				if (!DAOFactory.getSQLDAOFactory().getInscriptionDAO().create(ins)) {
					Alert alert = new Alert(AlertType.WARNING, "erreur dans la donée Inscription : " + ins.toString());
					alert.show();
					return false;
				}

			}
		}
		return true;
	}

}
