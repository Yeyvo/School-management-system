package ma.SchoolManagement.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class DashboardController implements Initializable {
	@FXML
	private BorderPane border_pane;

	String desktoppath = System.getProperty("user.home") + "/Desktop/";;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			DynamicViews.loadBorderCenter(border_pane, "eleves");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DashboardController() {

	}

//	@FXML
//	private void show_dashboard(MouseEvent event) throws IOException {
//		DynamicViews.loadBorderCenter(border_pane, "eleves");
//	}

	@FXML
	private void show_listeService(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "services-choix");
	}

	@FXML
	private void show_eleve(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "eleves");
	}

	@FXML
	private void etablissement(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "etablissement-choix");
	}

	@FXML
	private void filieres(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "filieres-choix");
	}

	public void updatetoliste() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "liste_services");
	}

	@FXML
	private void toexcel() {
		Set<Etudiant> etud = DAOFactory.getEtudiantDAO().all();
		Set<Etablissement> etab = DAOFactory.getEtablissementDAO().all();
		Set<Filiere> fil = DAOFactory.getFiliereDAO().all();
		Set<Inscription> insc = DAOFactory.getInscriptionDAO().all();
		Set<ServicesEtud> service = DAOFactory.getServicesEtudDAO().all();

		XSSFWorkbook workbook = new XSSFWorkbook();

		CellStyle stylecellhead = workbook.createCellStyle();

		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("Arial");
	    font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setItalic(false);

//	    stylecellhead.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		stylecellhead.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
		stylecellhead.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		stylecellhead.setAlignment(HorizontalAlignment.CENTER);
		stylecellhead.setVerticalAlignment(VerticalAlignment.CENTER);
		stylecellhead.setFont(font);

		CellStyle stylecellbase = workbook.createCellStyle();

		XSSFFont fontbase = workbook.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName("Arial");
//	    font.setColor(IndexedColors.WHITE.getIndex());
		font.setBold(true);
		font.setItalic(false);

		stylecellbase.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		stylecellbase.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		stylecellbase.setAlignment(HorizontalAlignment.CENTER);
		stylecellbase.setVerticalAlignment(VerticalAlignment.CENTER);
		stylecellbase.setFont(fontbase);
		stylecellbase.setBorderBottom(BorderStyle.HAIR);
		stylecellbase.setBorderLeft(BorderStyle.HAIR);
		stylecellbase.setBorderRight(BorderStyle.HAIR);
		stylecellbase.setBorderTop(BorderStyle.HAIR);

		XSSFSheet etudsheet = workbook.createSheet("Etudiants");
		writesheetEtudiant(etud, etudsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet etabsheet = workbook.createSheet("Etablissement");
		writesheetEtablissement(etab, etabsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet filsheet = workbook.createSheet("Filiere");
		writesheetFiliere(fil, filsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet inscsheet = workbook.createSheet("Inscription");
		writesheetInscription(insc, inscsheet, workbook, stylecellhead, stylecellbase);
		XSSFSheet servicesheet = workbook.createSheet("Service");
		writesheetServicesEtud(service, servicesheet, workbook, stylecellhead, stylecellbase);

		for (int x = 0; x < etudsheet.getRow(1).getPhysicalNumberOfCells(); x++) {
			etudsheet.autoSizeColumn(x);
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
			System.out.println("DONE");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writesheetEtudiant(Set<Etudiant> dataset, XSSFSheet sheet, XSSFWorkbook workbook,
			CellStyle stylecellhead, CellStyle stylecellbase) {
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
			writeEtudiant(data, row, stylecellbase);
		}

	}

	private void writeEtudiant(Etudiant data, XSSFRow row, CellStyle stylecellbase) {

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
		cell15.setCellStyle(stylecellbase);

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
		cell19.setCellStyle(stylecellbase);

		Cell cell20 = row.createCell(19);
		cell20.setCellValue(data.getEtudDDP());
		cell20.setCellStyle(stylecellbase);

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
		cell24.setCellStyle(stylecellbase);

		Cell cell25 = row.createCell(24);
		cell25.setCellValue(data.getEtudDDM());
		cell25.setCellStyle(stylecellbase);

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

}
