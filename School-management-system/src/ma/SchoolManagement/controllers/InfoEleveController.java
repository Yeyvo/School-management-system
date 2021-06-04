package ma.SchoolManagement.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import ma.SchoolManagement.model.Etudiant;

public class InfoEleveController implements Initializable {

	@FXML
	private Text nomEleveText;

	@FXML
	private Text prenomEleveText;

	@FXML
	private Text sexeText;

	@FXML
	private Text dateNaissanceEleveText;

	@FXML
	private Text adresseEleveText;

	@FXML
	private Text villeEleveText;

	@FXML
	private Text codePostalEleveText;

	@FXML
	private Text nationnaliteEleveText;

	@FXML
	private Text telephoneEleveText;

	@FXML
	private Text mailEleveText;

	@FXML
	private Text situationFamilialeEleveText;

	@FXML
	private Text RIBEleveText;

	@FXML
	private Text CNIPereText;

	@FXML
	private Text nomPereText;

	@FXML
	private Text prenomPereText;

	@FXML
	private Text dateNaissancePereText;

	@FXML
	private Text dateDecesPereText;

	@FXML
	private Text CNIMereText;

	@FXML
	private Text nomMereText;

	@FXML
	private Text prenomMereText;

	@FXML
	private Text dateNaissanceMereText;

	@FXML
	private Text dateDecesMereText;

	@FXML
	private Text CNEEleveText;

	@FXML
	private Text departementEleveText;
	
	private Etudiant elv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public Etudiant getElv() {
		return elv;
	}

	public void setElv(Etudiant elv) {
		this.elv = elv;
		nomEleveText.setText(elv.getEtudNom());
		prenomEleveText.setText(elv.getEtudPrenom());
		sexeText.setText(elv.getEtudSexe());
		dateNaissanceEleveText.setText(elv.getEtudNai().toString());
		adresseEleveText.setText(elv.getEtudAd1());
		villeEleveText.setText(elv.getEtudVil());
		codePostalEleveText.setText(String.valueOf(elv.getEtudCPS()));
		nationnaliteEleveText.setText(elv.getEtudNat());
		
		telephoneEleveText.setText(elv.getEtudTel());
		mailEleveText.setText(elv.getEtudMail());
		situationFamilialeEleveText.setText(elv.getEtudSfam());
		RIBEleveText.setText(elv.getEtudRib());
		CNIPereText.setText(elv.getCniePere());
		nomPereText.setText(elv.getEtudNomp());
		prenomPereText.setText(elv.getEtudPrenom());
		dateNaissancePereText.setText(elv.getEtudDNP().toString());
		
		dateDecesPereText.setText(elv.getEtudDDP().toString());
		CNIMereText.setText(elv.getCnieMere());
		nomMereText.setText(elv.getEtudNomm());
		prenomMereText.setText(elv.getEtudprem());
		dateNaissanceMereText.setText(elv.getEtudDNM().toString());
		dateDecesMereText.setText(elv.getEtudDDM().toString());
		CNEEleveText.setText(elv.getEtudCNE());
		departementEleveText.setText(elv.getEtudDpt());
		
	}
}















