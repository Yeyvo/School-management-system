package ma.SchoolManagement.model.dao.exel;

import java.time.LocalDate;
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
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;

public class EtudiantEXCELDAO extends DAOEXCEL<Etudiant> {

	@Override
	public boolean exportdata(Set<Etudiant> dataset, XSSFSheet sheet, XSSFWorkbook workbook, CellStyle stylecellhead,
			CellStyle stylecellbase, CellStyle datecell) {
		int rowC = 1;

		XSSFRow r = sheet.createRow(1);

		Cell cell1 = r.createCell(0);
		cell1.setCellValue("EtudId");
		cell1.setCellStyle(stylecellhead);
		
		Cell cell2 = r.createCell(1);
		cell2.setCellValue("EtudCPS");
		cell2.setCellStyle(stylecellhead);

		Cell cell3 = r.createCell(2);
		cell3.setCellValue("EtudCNE");
		cell3.setCellStyle(stylecellhead);

		Cell cell4 = r.createCell(3);
		cell4.setCellValue("EtudNom");
		cell4.setCellStyle(stylecellhead);

		Cell cell5 = r.createCell(4);
		cell5.setCellValue("EtudPre");
		cell5.setCellStyle(stylecellhead);

		Cell cell6 = r.createCell(5);
		cell6.setCellValue("EtudSfam");
		cell6.setCellStyle(stylecellhead);

		Cell cell7 = r.createCell(6);
		cell7.setCellValue("EtudNat");
		cell7.setCellStyle(stylecellhead);

		Cell cell8 = r.createCell(7);
		cell8.setCellValue("EtudSexe");
		cell8.setCellStyle(stylecellhead);

		Cell cell9 = r.createCell(8);
		cell9.setCellValue("EtudAd1");
		cell9.setCellStyle(stylecellhead);

		Cell cell10 = r.createCell(9);
		cell10.setCellValue("EtudVil");
		cell10.setCellStyle(stylecellhead);

		Cell cell12 = r.createCell(10);
		cell12.setCellValue("EtudDpt");
		cell12.setCellStyle(stylecellhead);

		Cell cell13 = r.createCell(11);
		cell13.setCellValue("EtudTel");
		cell13.setCellStyle(stylecellhead);

		Cell cell14 = r.createCell(12);
		cell14.setCellValue("EtudMail");
		cell14.setCellStyle(stylecellhead);

		Cell cell15 = r.createCell(13);
		cell15.setCellValue("EtudRib");
		cell15.setCellStyle(stylecellhead);

		Cell cell16 = r.createCell(14);
		cell16.setCellValue("EtudNai");
		cell16.setCellStyle(stylecellhead);

		Cell cell17 = r.createCell(15);
		cell17.setCellValue("CniePere");
		cell17.setCellStyle(stylecellhead);

		Cell cell18 = r.createCell(16);
		cell18.setCellValue("EtudNomp");
		cell18.setCellStyle(stylecellhead);

		Cell cell19 = r.createCell(17);
		cell19.setCellValue("EtudPrep");
		cell19.setCellStyle(stylecellhead);

		Cell cell20 = r.createCell(18);
		cell20.setCellValue("EtudDNP");
		cell20.setCellStyle(stylecellhead);

		Cell cell21 = r.createCell(19);
		cell21.setCellValue("EtudDDP");
		cell21.setCellStyle(stylecellhead);

		Cell cell22 = r.createCell(20);
		cell22.setCellValue("CnieMere");
		cell22.setCellStyle(stylecellhead);

		Cell cell123 = r.createCell(21);
		cell123.setCellValue("EtudNomm");
		cell123.setCellStyle(stylecellhead);

		Cell cell24 = r.createCell(22);
		cell24.setCellValue("Etudprem");
		cell24.setCellStyle(stylecellhead);

		Cell cell25 = r.createCell(23);
		cell25.setCellValue("EtudDNM");
		cell25.setCellStyle(stylecellhead);

		Cell cell26 = r.createCell(24);
		cell26.setCellValue("EtudDDM");
		cell26.setCellStyle(stylecellhead);

		for (Etudiant data : dataset) {
			XSSFRow row = sheet.createRow(++rowC);
			writeEtudiant(data, row, stylecellbase, workbook, datecell);
		}

		
		for (int y = 0; y < sheet.getRow(1).getPhysicalNumberOfCells(); y++) {
			sheet.autoSizeColumn(y);
		}

		return true;
	}

	private void writeEtudiant(Etudiant data, XSSFRow row, CellStyle stylecellbase, XSSFWorkbook workbook,
			CellStyle datecell) {

		Cell cell1 = row.createCell(0);
		cell1.setCellValue(data.getEtudId());
		cell1.setCellStyle(stylecellbase);
		
		Cell cell2 = row.createCell(1);
		cell2.setCellValue(data.getEtudCPS());
		cell2.setCellStyle(stylecellbase);

		Cell cell3 = row.createCell(2);
		cell3.setCellValue(data.getEtudCNE());
		cell3.setCellStyle(stylecellbase);

		Cell cell4 = row.createCell(3);
		cell4.setCellValue(data.getEtudNom());
		cell4.setCellStyle(stylecellbase);

		Cell cell5 = row.createCell(4);
		cell5.setCellValue(data.getEtudPrenom());
		cell5.setCellStyle(stylecellbase);

		Cell cell6 = row.createCell(5);
		cell6.setCellValue(data.getEtudSfam());
		cell6.setCellStyle(stylecellbase);

		Cell cell7 = row.createCell(6);
		cell7.setCellValue(data.getEtudNat());
		cell7.setCellStyle(stylecellbase);

		Cell cell8 = row.createCell(7);
		cell8.setCellValue(data.getEtudSexe());
		cell8.setCellStyle(stylecellbase);

		Cell cell9 = row.createCell(8);
		cell9.setCellValue(data.getEtudAd1());
		cell9.setCellStyle(stylecellbase);

		Cell cell10 = row.createCell(9);
		cell10.setCellValue(data.getEtudVil());
		cell10.setCellStyle(stylecellbase);

		Cell cell11 = row.createCell(10);
		cell11.setCellValue(data.getEtudDpt());
		cell11.setCellStyle(stylecellbase);

		Cell cell12 = row.createCell(11);
		cell12.setCellValue(data.getEtudTel());
		cell12.setCellStyle(stylecellbase);

		Cell cell13 = row.createCell(12);
		cell13.setCellValue(data.getEtudMail());
		cell13.setCellStyle(stylecellbase);

		Cell cell14 = row.createCell(13);
		cell14.setCellValue(data.getEtudRib());
		cell14.setCellStyle(stylecellbase);

		Cell cell15 = row.createCell(14);
		cell15.setCellValue(data.getEtudNai());
		cell15.setCellStyle(datecell);

		Cell cell16 = row.createCell(15);
		cell16.setCellValue(data.getCniePere());
		cell16.setCellStyle(stylecellbase);

		Cell cell17 = row.createCell(16);
		cell17.setCellValue(data.getEtudNomp());
		cell17.setCellStyle(stylecellbase);

		Cell cell18 = row.createCell(17);
		cell18.setCellValue(data.getEtudPrep());
		cell18.setCellStyle(stylecellbase);

		Cell cell19 = row.createCell(18);
		cell19.setCellValue(data.getEtudDNP());
		cell19.setCellStyle(datecell);

		Cell cell20 = row.createCell(19);
		cell20.setCellValue(data.getEtudDDP());
		cell20.setCellStyle(datecell);

		Cell cell21 = row.createCell(20);
		cell21.setCellValue(data.getCnieMere());
		cell21.setCellStyle(stylecellbase);

		Cell cell22 = row.createCell(21);
		cell22.setCellValue(data.getEtudNomm());
		cell22.setCellStyle(stylecellbase);

		Cell cell23 = row.createCell(22);
		cell23.setCellValue(data.getEtudprem());
		cell23.setCellStyle(stylecellbase);

		Cell cell24 = row.createCell(23);
		cell24.setCellValue(data.getEtudDNM());
		cell24.setCellStyle(datecell);

		Cell cell25 = row.createCell(24);
		cell25.setCellValue(data.getEtudDDM());
		cell25.setCellStyle(datecell);

	}

	@Override
	public boolean importdata(Workbook wb) {

		Sheet firstSheet = wb.getSheetAt(0);
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
				int cps = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));

				String EtudCNE = formatter.formatCellValue(cellIterator.next()),
						EtudNom = formatter.formatCellValue(cellIterator.next()),
						EtudPre = formatter.formatCellValue(cellIterator.next()),
						EtudSfam = formatter.formatCellValue(cellIterator.next()),
						EtudNat = formatter.formatCellValue(cellIterator.next()),
						EtudSexe = formatter.formatCellValue(cellIterator.next()),
						EtudAd1 = formatter.formatCellValue(cellIterator.next()),
						EtudVil = formatter.formatCellValue(cellIterator.next()),
						EtudDpt = formatter.formatCellValue(cellIterator.next()),
						EtudTel = formatter.formatCellValue(cellIterator.next()),
						EtudMail = formatter.formatCellValue(cellIterator.next()),
						EtudRib = formatter.formatCellValue(cellIterator.next());
				LocalDate EtudNai = helpers.convertToLocalDate(cellIterator.next().getDateCellValue());
				String CniePere = formatter.formatCellValue(cellIterator.next()),
						EtudNomp = formatter.formatCellValue(cellIterator.next()),
						EtudPrep = formatter.formatCellValue(cellIterator.next());
				LocalDate EtudDNP = helpers.convertToLocalDate(cellIterator.next().getDateCellValue()),
						EtudDDP = helpers.convertToLocalDate(cellIterator.next().getDateCellValue());
				String CnieMere = formatter.formatCellValue(cellIterator.next()),
						EtudNomm = formatter.formatCellValue(cellIterator.next()),
						Etudprem = formatter.formatCellValue(cellIterator.next());

				LocalDate EtudDNM = helpers.convertToLocalDate(cellIterator.next().getDateCellValue()),
						EtudDDM = helpers.convertToLocalDate(cellIterator.next().getDateCellValue());

				Etudiant Etud = new Etudiant(0, EtudCNE, EtudNom, EtudPre, EtudSfam, EtudNat, EtudNai, EtudSexe,
						EtudAd1, cps, EtudVil, EtudDpt, EtudTel, EtudMail, EtudRib, CniePere, EtudNomp, EtudPrep,
						EtudDNP, EtudDDP, CnieMere, EtudNomm, Etudprem, EtudDNM, EtudDDM);

				if (!DAOFactory.getSQLDAOFactory().getEtudiantDAO().create(Etud)) {
					Alert alert = new Alert(AlertType.WARNING,
							"erreur dans la donée Etudiant : " + Etud.toStringimport());
					alert.show();
					return false;
				}

			}
		}
		return true;
	}

}
