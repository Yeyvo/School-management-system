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
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ChoixExcelController implements Initializable {

	String desktoppath = System.getProperty("user.home") + "/Desktop/";;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void imp() {

		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/drop.fxml"));
			Parent root;
			root = loader.load();
			stage.setScene(new Scene(root));
			((ImportController) loader.getController()).setStage(stage);
			stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
			stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
			stage.setResizable(false);

			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void exp() {

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
		XSSFSheet etabsheet = workbook.createSheet("Etablissement");
		XSSFSheet filsheet = workbook.createSheet("Filiere");
		XSSFSheet inscsheet = workbook.createSheet("Inscription");
		XSSFSheet servicesheet = workbook.createSheet("Service");

		DAOFactory.getEXCELDAOFactory().getEtudiantDAO().exportdata(
				DAOFactory.getSQLDAOFactory().getEtudiantDAO().all(), Etudsheet, workbook, stylecellhead, stylecellbase,
				datecell);
		DAOFactory.getEXCELDAOFactory().getEtablissementDAO().exportdata(
				DAOFactory.getSQLDAOFactory().getEtablissementDAO().all(), etabsheet, workbook, stylecellhead,
				stylecellbase, datecell);
		DAOFactory.getEXCELDAOFactory().getFiliereDAO().exportdata(DAOFactory.getSQLDAOFactory().getFiliereDAO().all(),
				filsheet, workbook, stylecellhead, stylecellbase, datecell);
		DAOFactory.getEXCELDAOFactory().getInscriptionDAO().exportdata(
				DAOFactory.getSQLDAOFactory().getInscriptionDAO().all(), inscsheet, workbook, stylecellhead,
				stylecellbase, datecell);
		DAOFactory.getEXCELDAOFactory().getServicesEtudDAO().exportdata(
				DAOFactory.getSQLDAOFactory().getServicesEtudDAO().all(), servicesheet, workbook, stylecellhead,
				stylecellbase, datecell);

		
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
}
