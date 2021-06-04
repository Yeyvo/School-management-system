package ma.SchoolManagement.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;

public class ModifEleveController implements Initializable {

	@FXML
	private CheckBox pereDeces;
	@FXML
	private CheckBox mereDeces;
	@FXML
	private Button modifEleve;
	@FXML
	private TextField adresseEleve;
	@FXML
	private TextField telephoneEleve;
	@FXML
	private TextField mailEleve;
	@FXML
	private TextField situationFamilialeEleve;
	@FXML
	private TextField RIBEleve;
	@FXML
	private DatePicker dateDecesMere;
	@FXML
	private Text fullname;
	
	private Etudiant elv;
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
	}
	
	@FXML
	private void vall() {
		String adresse = adresseEleve.getText();
		String tel = telephoneEleve.getText();
		String mail = mailEleve.getText();
		String sF = situationFamilialeEleve.getText();
		String RIB = RIBEleve.getText();
		boolean pere = pereDeces.isSelected();
		boolean mere = mereDeces.isSelected();
		LocalDate ddd = dateDecesMere.getValue();
		
		elv.setEtudAd1(adresse);
		elv.setEtudTel(tel);
		elv.setEtudMail(mail);
		elv.setEtudSfam(sF);
		elv.setEtudRib(RIB);
		
		if(pere) {
			elv.setEtudDDP(ddd);
		}
		if(mere) {
			elv.setEtudDDM(ddd);
		}
		
		DAOFactory.getEtudiantDAO().update(elv, elv);
		
	}
	
	public Etudiant getElv() {
		return elv;
	}

	public void setElv(Etudiant elv) {
		this.elv = elv;
		fullname.setText(elv.getEtudNom() + " " + elv.getEtudPrenom());
	}

}
