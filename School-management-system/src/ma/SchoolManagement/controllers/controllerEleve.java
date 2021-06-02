package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ma.SchoolManagement.helpers.DynamicViews;

public class controllerEleve  implements Initializable {

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}

	
	@FXML
	private void show_edit(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/edit_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/ajout_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	@FXML
	private void show_info(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/info_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	
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
	private void add_eleve() throws IOException{
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
	
	@FXML
	private javafx.scene.control.CheckBox pereDeces;
	
	@FXML
	private javafx.scene.control.CheckBox mereDeces;
	
	@FXML
	private javafx.scene.control.Button modifEleve;
	
	@FXML
	private void edit_eleve() throws IOException{
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