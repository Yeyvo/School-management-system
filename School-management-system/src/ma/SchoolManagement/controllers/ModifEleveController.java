package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;

public class ModifEleveController {

	@FXML
	private javafx.scene.control.CheckBox pereDeces;

	@FXML
	private javafx.scene.control.CheckBox mereDeces;

	@FXML
	private javafx.scene.control.Button modifEleve;
	
	@FXML
	private javafx.scene.control.TextField adresseEleve;
	
	@FXML
	private javafx.scene.control.TextField telephoneEleve;

	@FXML
	private javafx.scene.control.TextField mailEleve;

	@FXML
	private javafx.scene.control.TextField situationFamilialeEleve;

	@FXML
	private javafx.scene.control.TextField RIBEleve;
	
	@FXML
	private javafx.scene.control.DatePicker dateDecesMere;

	@FXML
	private void edit_eleve() throws IOException {
		String adresse = adresseEleve.getText();
		String tel = telephoneEleve.getText();
		String mail = mailEleve.getText();
		String sF = situationFamilialeEleve.getText();
		String RIB = RIBEleve.getText();
		boolean pere = pereDeces.isSelected();
		boolean mere = mereDeces.isSelected();
		LocalDate ddd = dateDecesMere.getValue();
	}
}
