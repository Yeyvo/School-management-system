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
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;

public class ServicesEtudEXCELDAO extends DAOEXCEL<ServicesEtud> {



	@Override
	public boolean exportdata(Set<ServicesEtud> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase, CellStyle datecell) {
		int rowC = 1;

		XSSFRow r = sheet.createRow(1);

		Cell cell1 = r.createCell(0);
		cell1.setCellValue("EtudId");
		cell1.setCellStyle(stylecellhead);

		Cell cell2 = r.createCell(1);
		cell2.setCellValue("EtudANSC");
		cell2.setCellStyle(stylecellhead);

		Cell cell3 = r.createCell(2);
		cell3.setCellValue("EtudCU");
		cell3.setCellStyle(stylecellhead);

		Cell cell4 = r.createCell(3);
		cell4.setCellValue("EtudBO");
		cell4.setCellStyle(stylecellhead);

		Cell cell5 = r.createCell(4);
		cell5.setCellValue("EtudCMB");
		cell5.setCellStyle(stylecellhead);

		Cell cell6 = r.createCell(5);
		cell6.setCellValue("EtudCMBO");
		cell6.setCellStyle(stylecellhead);

		for (ServicesEtud data : dataset) {
			XSSFRow row = sheet.createRow(++rowC);
			writeServicesEtud(data, row, stylecellbase);
		}
		
		for (int y = 0; y < sheet.getRow(1).getPhysicalNumberOfCells(); y++) {
			sheet.autoSizeColumn(y);
		}
		
		return true;
	}
	
	private void writeServicesEtud(ServicesEtud data, XSSFRow row, CellStyle stylecellbase) {
		Cell cell1 = row.createCell(0);
		cell1.setCellValue(data.getEtudId());
		cell1.setCellStyle(stylecellbase);

		Cell cell2 = row.createCell(1);
		cell2.setCellValue(data.getEtudANSC());
		cell2.setCellStyle(stylecellbase);

		Cell cell3 = row.createCell(2);
		cell3.setCellValue(data.isEtudCU());
		cell3.setCellStyle(stylecellbase);

		Cell cell4 = row.createCell(3);
		cell4.setCellValue(data.isEtudBO());
		cell4.setCellStyle(stylecellbase);

		Cell cell5 = row.createCell(4);
		cell5.setCellValue(data.isEtudCMB());
		cell5.setCellStyle(stylecellbase);

		Cell cell6 = row.createCell(5);
		cell6.setCellValue(data.getEtudCMBO());
		cell6.setCellStyle(stylecellbase);

	}

	@Override
	public boolean importdata(Workbook wb) {

		Sheet firstSheet = wb.getSheetAt(4);
		Iterator<Row> rowIterator = firstSheet.iterator();

		rowIterator.next();
//			rowIterator.next(); 
		// skip the header row
		DataFormatter formatter = new DataFormatter();
		while (rowIterator.hasNext()) {
			Row nextRow = rowIterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			if (cellIterator.hasNext()) {

				int EtudId = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
				boolean EtudBO = Boolean.valueOf(formatter.formatCellValue(cellIterator.next())),
						EtudCU = Boolean.valueOf(formatter.formatCellValue(cellIterator.next())),
						EtudCMB = Boolean.valueOf(formatter.formatCellValue(cellIterator.next()));
				String EtudCMBO = formatter.formatCellValue(cellIterator.next()),
						EtudANSC = formatter.formatCellValue(cellIterator.next());

				ServicesEtud serv = new ServicesEtud(EtudId, EtudANSC, EtudBO, EtudCU, EtudCMB, EtudCMBO);
				if (!DAOFactory.getSQLDAOFactory().getServicesEtudDAO().create(serv)) {
					Alert alert = new Alert(AlertType.WARNING,
							"erreur dans la donée Service Etudiant : " + serv.toString());
					alert.show();
					return false;
				}

			}
		}
		return true;
	}
}
