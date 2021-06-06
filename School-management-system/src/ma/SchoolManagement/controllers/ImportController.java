package ma.SchoolManagement.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ma.SchoolManagement.model.dao.DAOFactory;

public class ImportController implements Initializable {

	List<String> validExtensions = Arrays.asList("xlsx");

	@FXML
	private Pane pane;

	@FXML
	private Stage stage;

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void dragov(DragEvent event) {
		Dragboard db = event.getDragboard();
		if (db.hasFiles()) {
			event.acceptTransferModes(TransferMode.COPY);

		} else {
			event.consume();
		}
	}

	@FXML
	private void dragdrop(DragEvent event) {
		if (validExtensions.containsAll(event.getDragboard().getFiles().stream()
				.map(file -> getExtension(file.getName())).collect(Collectors.toList()))) {
			Dragboard db = event.getDragboard();
			boolean success = false;
			if (db.hasFiles()) {
				success = true;
				String filePath = null;
				for (File file : db.getFiles()) {
					calc(file.getAbsolutePath());
					System.out.println(filePath);
				}
			}
			event.setDropCompleted(success);
			event.consume();

		} else {
			Alert alert = new Alert(AlertType.WARNING, "Ce type de fichier est indésiré ");
			alert.show();
			event.consume();
		}
		
	}

	private void calc(String excelFilePath) {
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);

			Workbook workbook;

			workbook = new XSSFWorkbook(inputStream);

			DAOFactory.getEXCELDAOFactory().getEtudiantDAO().importdata(workbook);
			DAOFactory.getEXCELDAOFactory().getEtablissementDAO().importdata(workbook);
			DAOFactory.getEXCELDAOFactory().getFiliereDAO().importdata(workbook);
			DAOFactory.getEXCELDAOFactory().getInscriptionDAO().importdata(workbook);
			DAOFactory.getEXCELDAOFactory().getServicesEtudDAO().importdata(workbook);
			
			
			workbook.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getExtension(String fileName) {
		String extension = "";

		int i = fileName.lastIndexOf('.');

		if (i > 0 && i < fileName.length() - 1)
			return fileName.substring(i + 1).toLowerCase();

		return extension;
	}

	
}
