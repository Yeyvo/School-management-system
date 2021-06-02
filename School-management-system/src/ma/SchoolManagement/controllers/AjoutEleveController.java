package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;

public class AjoutEleveController {

	@FXML
	private javafx.scene.control.TextField nomEleve;

	@FXML
	private javafx.scene.control.TextField prenomEleve;

	@FXML
	private javafx.scene.control.RadioButton sexeHomme;

	@FXML
	private javafx.scene.control.RadioButton sexeFemme;

	@FXML
	private javafx.scene.control.DatePicker dateNaissanceEleve;

	@FXML
	private javafx.scene.control.TextField adresseEleve;

	@FXML
	private javafx.scene.control.TextField villeEleve;

	@FXML
	private javafx.scene.control.TextField codePostalEleve;

	@FXML
	private javafx.scene.control.TextField nationnaliteEleve;

	@FXML
	private javafx.scene.control.TextField telephoneEleve;

	@FXML
	private javafx.scene.control.TextField mailEleve;

	@FXML
	private javafx.scene.control.TextField situationFamilialeEleve;

	@FXML
	private javafx.scene.control.TextField RIBEleve;

	@FXML
	private javafx.scene.control.TextField CNIPere;

	@FXML
	private javafx.scene.control.TextField nomPere;

	@FXML
	private javafx.scene.control.TextField prenomPere;

	@FXML
	private javafx.scene.control.DatePicker dateNaissancePere;

	@FXML
	private javafx.scene.control.DatePicker dateDecesPere;

	@FXML
	private javafx.scene.control.TextField CNIMere;

	@FXML
	private javafx.scene.control.TextField nomMere;

	@FXML
	private javafx.scene.control.TextField prenomMere;

	@FXML
	private javafx.scene.control.DatePicker dateNaissanceMere;

	@FXML
	private javafx.scene.control.DatePicker dateDecesMere;

	@FXML
	private javafx.scene.control.TextField CNEEleve;

	@FXML
	private javafx.scene.control.TextField departementEleve;

	@FXML
	private javafx.scene.control.Button ajoutEleve;

	@FXML
	private void add_eleve() throws IOException {
		String nom = nomEleve.getText();
		String prenom = prenomEleve.getText();
		boolean homme = sexeHomme.isSelected();
		boolean femme = sexeFemme.isSelected();
		LocalDate ddnEleveLocal = dateNaissanceEleve.getValue();
		String adresse = adresseEleve.getText();
		String ville = villeEleve.getText();
		String codePostal = codePostalEleve.getText();
		String nationnalite = nationnaliteEleve.getText();
		String tel = telephoneEleve.getText();
		String mail = mailEleve.getText();
		String sFEleve = situationFamilialeEleve.getText();
		String RIB = RIBEleve.getText();
		String CNE = CNEEleve.getText();
		String dpt = departementEleve.getText();
		String CNIP = CNIPere.getText();
		String nomP = nomPere.getText();
		String prenomP = prenomPere.getText();
		LocalDate ddnPereLocal = dateNaissancePere.getValue();
		LocalDate dddPereLocal = dateDecesPere.getValue();
		String CNIM = CNIMere.getText();
		String nomM = nomMere.getText();
		String prenomM = prenomMere.getText();
		LocalDate ddnMereLocal = dateNaissancePere.getValue();
		LocalDate dddMereLocal = dateDecesPere.getValue();
	}
}
