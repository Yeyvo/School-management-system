package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;

public class AjoutEleveController implements Initializable {

	@FXML
	private TextField nomEleve;

	@FXML
	private TextField prenomEleve;

	@FXML
	private RadioButton sexeHomme;

	@FXML
	private RadioButton sexeFemme;

	@FXML
	private DatePicker dateNaissanceEleve;

	@FXML
	private TextField adresseEleve;

	@FXML
	private TextField villeEleve;

	@FXML
	private TextField codePostalEleve;

	@FXML
	private TextField nationnaliteEleve;

	@FXML
	private TextField telephoneEleve;

	@FXML
	private TextField mailEleve;

	@FXML
	private TextField situationFamilialeEleve;

	@FXML
	private TextField RIBEleve;

	@FXML
	private TextField CNIPere;

	@FXML
	private TextField nomPere;

	@FXML
	private TextField prenomPere;

	@FXML
	private DatePicker dateNaissancePere;

	@FXML
	private DatePicker dateDecesPere;

	@FXML
	private TextField CNIMere;

	@FXML
	private TextField nomMere;

	@FXML
	private TextField prenomMere;

	@FXML
	private DatePicker dateNaissanceMere;

	@FXML
	private DatePicker dateDecesMere;

	@FXML
	private TextField CNEEleve;

	@FXML
	private TextField departementEleve;

	@FXML
	private Button ajoutEleve;
	
	boolean homme ;
	boolean femme ;
	String nom, prenom,etudNat, etudAd1,ville,codePostal,tudNat,tel,mail,etudSfam,RIB,CNE,dpt ,CNIP ,nomP,prenomP,CNIM , nomM ,prenomM ;
	LocalDate etudNai, ddnPereLocal, dddPereLocal, ddnMereLocal , dddMereLocal;


	@FXML
	private void add_eleve() throws IOException {
		 nom = nomEleve.getText();
		 prenom = prenomEleve.getText();
		 homme = sexeHomme.isSelected();
		 femme = sexeFemme.isSelected();
		 etudNai = dateNaissanceEleve.getValue();
		 etudAd1 = adresseEleve.getText();
		 ville = villeEleve.getText();
		 codePostal = codePostalEleve.getText();
		 etudNat = nationnaliteEleve.getText();
		 tel = telephoneEleve.getText();
		 mail = mailEleve.getText();
		 etudSfam = situationFamilialeEleve.getText();
		 RIB = RIBEleve.getText();
		 CNE = CNEEleve.getText();
		 dpt = departementEleve.getText();
		 CNIP = CNIPere.getText();
		 nomP = nomPere.getText();
		 prenomP = prenomPere.getText();
		 ddnPereLocal = dateNaissancePere.getValue();
		 dddPereLocal = dateDecesPere.getValue();
		 CNIM = CNIMere.getText();
		 nomM = nomMere.getText();
		 prenomM = prenomMere.getText();
		 ddnMereLocal = dateNaissancePere.getValue();
		 dddMereLocal = dateDecesPere.getValue();

		Etudiant data = new Etudiant(0, CNE, nom, prenom, etudSfam, etudNat, etudNai, (homme ? "Male" : "Female"),
				etudAd1, Integer.valueOf(codePostal), ville, dpt, tel, mail, RIB, CNIP, nomP, prenomP, ddnPereLocal,
				dddPereLocal, CNIM, nomM, prenomM, ddnMereLocal, dddMereLocal);
		if (!DAOFactory.getEtudiantDAO().create(data)) {
			Alert alert = new Alert(AlertType.WARNING, "Ajout impossible");
			alert.show();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}