package ma.SchoolManagement.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;

public class ChoixExcelController implements Initializable {

	String desktoppath = System.getProperty("user.home") + "/Desktop/";;
	String excelFilePath = System.getProperty("user.home")
			+ "/Desktop/schoolmanagementsystem(06-04-2021-20-13-19).xlsx";;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void imp() {

		try {
			long start = System.currentTimeMillis();

			FileInputStream inputStream = new FileInputStream(excelFilePath);

			Workbook workbook = new XSSFWorkbook(inputStream);

			for (int i = 0; i < 5; i++) {
				Sheet firstSheet = workbook.getSheetAt(i);
				workbook.getSheetName(i);
				Iterator<Row> rowIterator = firstSheet.iterator();

				rowIterator.next();
//			rowIterator.next(); 
				// skip the header row
				DataFormatter formatter = new DataFormatter();
				while (rowIterator.hasNext()) {
					Row nextRow = rowIterator.next();
					Iterator<Cell> cellIterator = nextRow.cellIterator();

					if (cellIterator.hasNext()) {
						switch (i) {
						case 0: {
							int id = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
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
							LocalDate EtudNai = convertToLocalDate(cellIterator.next().getDateCellValue());
							String CniePere = formatter.formatCellValue(cellIterator.next()),
									EtudNomp = formatter.formatCellValue(cellIterator.next()),
									EtudPrep = formatter.formatCellValue(cellIterator.next());
							LocalDate EtudDNP = convertToLocalDate(cellIterator.next().getDateCellValue()),
									EtudDDP = convertToLocalDate(cellIterator.next().getDateCellValue());
							String CnieMere = formatter.formatCellValue(cellIterator.next()),
									EtudNomm = formatter.formatCellValue(cellIterator.next()),
									Etudprem = formatter.formatCellValue(cellIterator.next());

							LocalDate EtudDNM = convertToLocalDate(cellIterator.next().getDateCellValue()),
									EtudDDM = convertToLocalDate(cellIterator.next().getDateCellValue());

							Etudiant Etud = new Etudiant(0, EtudCNE, EtudNom, EtudPre, EtudSfam, EtudNat, EtudNai,
									EtudSexe, EtudAd1, cps, EtudVil, EtudDpt, EtudTel, EtudMail, EtudRib, CniePere,
									EtudNomp, EtudPrep, EtudDNP, EtudDDP, CnieMere, EtudNomm, Etudprem, EtudDNM,
									EtudDDM);

							if (!DAOFactory.getEtudiantDAO().create(Etud)) {
								Alert alert = new Alert(AlertType.WARNING,
										"erreur dans la donée Etudiant : " + Etud.toStringimport());
								alert.show();
							}
							break;
						}
						case 1: {

							int CodeEtab = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
							String DesEtab = formatter.formatCellValue(cellIterator.next()),
									EtudDPM = formatter.formatCellValue(cellIterator.next());
							Etablissement etab = new Etablissement(CodeEtab, DesEtab, EtudDPM);
							if (!DAOFactory.getEtablissementDAO().create(etab)) {
								Alert alert = new Alert(AlertType.WARNING,
										"erreur dans la donée Etablissement : " + etab.toString());
								alert.show();
							}
							break;
						}
						case 2: {

							int CodeEtab = Integer.valueOf(formatter.formatCellValue(cellIterator.next())),
									CodeFil = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
							String DesFil = formatter.formatCellValue(cellIterator.next());
							Filiere fil = new Filiere(CodeEtab, CodeFil, DesFil);
							if (!DAOFactory.getFiliereDAO().create(fil)) {
								Alert alert = new Alert(AlertType.WARNING,
										"erreur dans la donée Filiere : " + fil.toString());
								alert.show();
							}
							break;
						}
						case 3: {

							int EtudId = Integer.valueOf(formatter.formatCellValue(cellIterator.next())),
									EtudEtab = Integer.valueOf(formatter.formatCellValue(cellIterator.next())),
									EtudFil = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
							String EtudInsc = formatter.formatCellValue(cellIterator.next());
							Inscription ins = new Inscription(EtudId, EtudEtab, EtudFil, EtudInsc);
							if (!DAOFactory.getInscriptionDAO().create(ins)) {
								Alert alert = new Alert(AlertType.WARNING,
										"erreur dans la donée Inscription : " + ins.toString());
								alert.show();
							}
							break;
						}
						case 4: {

							int EtudId = Integer.valueOf(formatter.formatCellValue(cellIterator.next()));
							boolean EtudBO = Boolean.valueOf(formatter.formatCellValue(cellIterator.next())),
									EtudCU = Boolean.valueOf(formatter.formatCellValue(cellIterator.next())),
									EtudCMB = Boolean.valueOf(formatter.formatCellValue(cellIterator.next()));
							String EtudCMBO = formatter.formatCellValue(cellIterator.next()),
									EtudANSC = formatter.formatCellValue(cellIterator.next());
							
							ServicesEtud serv = new ServicesEtud(EtudId, EtudANSC, EtudBO, EtudCU, EtudCMB, EtudCMBO);
							if (!DAOFactory.getServicesEtudDAO().create(serv)) {
								Alert alert = new Alert(AlertType.WARNING,
										"erreur dans la donée Service Etudiant : " + serv.toString());
								alert.show();
							}

							break;
						}
						}
					}

				}
			}
			workbook.close();

			long end = System.currentTimeMillis();
			System.out.printf("Import done in %d ms\n", (end - start));

		} catch (IOException ex1) {
			System.out.println("Error reading file");
			ex1.printStackTrace();
		}

	}

	@FXML
	private void exp() {
		Set<Etudiant> Etud = DAOFactory.getEtudiantDAO().all();
		Set<Etablissement> etab = DAOFactory.getEtablissementDAO().all();
		Set<Filiere> fil = DAOFactory.getFiliereDAO().all();
		Set<Inscription> insc = DAOFactory.getInscriptionDAO().all();
		Set<ServicesEtud> service = DAOFactory.getServicesEtudDAO().all();

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("Arial");
		font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setItalic(false);

		XSSFFont fontbase = workbook.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
		font.setBold(true);
		font.setItalic(false);

		CellStyle stylecellhead = workbook.createCellStyle();
		stylecellhead.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
		stylecellhead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		stylecellhead.setAlignment(HorizontalAlignment.CENTER);
		stylecellhead.setVerticalAlignment(VerticalAlignment.CENTER);
		stylecellhead.setFont(font);

		CellStyle stylecellbase = workbook.createCellStyle();
		stylecellbase.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		stylecellbase.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		stylecellbase.setAlignment(HorizontalAlignment.CENTER);
		stylecellbase.setVerticalAlignment(VerticalAlignment.CENTER);
		stylecellbase.setFont(fontbase);
		stylecellbase.setBorderBottom(BorderStyle.HAIR);
		stylecellbase.setBorderLeft(BorderStyle.HAIR);
		stylecellbase.setBorderRight(BorderStyle.HAIR);
		stylecellbase.setBorderTop(BorderStyle.HAIR);

		CellStyle datecell = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		datecell.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));
		datecell.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		datecell.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		datecell.setAlignment(HorizontalAlignment.CENTER);
		datecell.setVerticalAlignment(VerticalAlignment.CENTER);
		datecell.setFont(fontbase);
		datecell.setBorderBottom(BorderStyle.HAIR);
		datecell.setBorderLeft(BorderStyle.HAIR);
		datecell.setBorderRight(BorderStyle.HAIR);
		datecell.setBorderTop(BorderStyle.HAIR);

		XSSFSheet Etudsheet = workbook.createSheet("Etudiants");
		writesheetEtudiant(Etud, Etudsheet, workbook, stylecellhead, stylecellbase, datecell);
		XSSFSheet etabsheet = workbook.createSheet("Etablissement");
		writesheetEtablissement(etab, etabsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet filsheet = workbook.createSheet("Filiere");
		writesheetFiliere(fil, filsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet inscsheet = workbook.createSheet("Inscription");
		writesheetInscription(insc, inscsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet servicesheet = workbook.createSheet("Service");
		writesheetServicesEtud(service, servicesheet, workbook, stylecellhead, stylecellbase);

		for (int x = 0; x < Etudsheet.getRow(1).getPhysicalNumberOfCells(); x++) {
			Etudsheet.autoSizeColumn(x);
		}
		for (int x = 0; x < etabsheet.getRow(1).getPhysicalNumberOfCells(); x++) {
			etabsheet.autoSizeColumn(x);
		}
		for (int x = 0; x < filsheet.getRow(1).getPhysicalNumberOfCells(); x++) {
			filsheet.autoSizeColumn(x);
		}
		for (int x = 0; x < inscsheet.getRow(1).getPhysicalNumberOfCells(); x++) {
			inscsheet.autoSizeColumn(x);
		}
		for (int x = 0; x < servicesheet.getRow(1).getPhysicalNumberOfCells(); x++) {
			servicesheet.autoSizeColumn(x);
		}

		SimpleDateFormat logTime = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		Calendar cal = Calendar.getInstance();

		try {
			FileOutputStream out = new FileOutputStream(
					new File(desktoppath, "schoolmanagementsystem(" + logTime.format(cal.getTime()) + ").xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("EXPORT DONE");
			Alert alert = new Alert(AlertType.CONFIRMATION, "EXPORT REUSSI");
			alert.show();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writesheetEtudiant(Set<Etudiant> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase, CellStyle datecell) {
		int rowC = 1;

		XSSFRow r = sheet.createRow(1);

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

	}

	private void writeEtudiant(Etudiant data, XSSFRow row, CellStyle stylecellbase, XSSFWorkbook workbook,
			CellStyle datecell) {

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

	private void writesheetEtablissement(Set<Etablissement> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase) {
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

	private void writesheetFiliere(Set<Filiere> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase) {
		int rowC = 1;

		XSSFRow r = sheet.createRow(1);

		Cell cell1 = r.createCell(0);
		cell1.setCellValue("CodeEtab");
		cell1.setCellStyle(stylecellhead);

		Cell cell2 = r.createCell(1);
		cell2.setCellValue("CodeFil");
		cell2.setCellStyle(stylecellhead);

		Cell cell3 = r.createCell(2);
		cell3.setCellValue("DesFil");
		cell3.setCellStyle(stylecellhead);

		for (Filiere data : dataset) {
			XSSFRow row = sheet.createRow(++rowC);
			writeFiliere(data, row, stylecellbase);
		}
	}

	private void writeFiliere(Filiere data, XSSFRow row, CellStyle stylecellbase) {
		Cell cell1 = row.createCell(0);
		cell1.setCellValue(data.getCodeEtab());
		cell1.setCellStyle(stylecellbase);

		Cell cell2 = row.createCell(1);
		cell2.setCellValue(data.getCodeFil());
		cell2.setCellStyle(stylecellbase);

		Cell cell3 = row.createCell(2);
		cell3.setCellValue(data.getDesFil());
		cell3.setCellStyle(stylecellbase);
	}

	private void writesheetInscription(Set<Inscription> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase) {
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

	private void writesheetServicesEtud(Set<ServicesEtud> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase) {
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

	public LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
