package ma.SchoolManagement.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

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
	private TextField ville;
	@FXML
	private TextField cps;
	@FXML
	private ChoiceBox<String> situationFamilialeEleve;
	@FXML
	private TextField RIBEleve;
	@FXML
	private DatePicker dateDecesMere;
	@FXML
	private DatePicker dateDecesPere;
	@FXML
	private Text fullname;

	private Etudiant elv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		situationFamilialeEleve.getItems().addAll("C?libataire", "Mari?(e)", "Divorc?(e)", "Autre");

	}

	@FXML
	private void vall() {
		String adresse = adresseEleve.getText();
		String tel = telephoneEleve.getText();
		String v = ville.getText();
		String cp = cps.getText();
		String mail = mailEleve.getText();
		String sF = situationFamilialeEleve.getValue();
		String RIB = RIBEleve.getText();
		boolean pere = pereDeces.isSelected();
		boolean mere = mereDeces.isSelected();
		LocalDate dddm = dateDecesMere.getValue();
		LocalDate dddp = dateDecesPere.getValue();

		if (!adresse.isBlank())
			elv.setEtudAd1(adresse);

		if (!v.isBlank())
			elv.setEtudVil(v);

		if (!cp.isBlank())
			elv.setEtudCPS(Integer.valueOf(cp));

		if (!tel.isBlank())
			elv.setEtudTel(tel);

		if (!mail.isBlank())
			elv.setEtudMail(mail);

		if (sF != null)
			elv.setEtudSfam(sF);

		if (!RIB.isBlank())
			elv.setEtudRib(RIB);

		boolean valide = true;

		if (pere) {
			if (dateDecesPere.getValue() != null) {
				elv.setEtudDDP(dddp);
			} else {
				Alert alert = new Alert(AlertType.WARNING,
						"Veuillez remplir correctement tout les champs obligatoires");
				alert.show();
				valide = false;

			}
		}
		if (mere) {
			if (dateDecesMere.getValue() != null) {
				elv.setEtudDDM(dddm);
			} else {
				Alert alert = new Alert(AlertType.WARNING,
						"Veuillez remplir correctement tout les champs obligatoires");
				alert.show();
				valide = false;
			}
		}
		if (valide) {
			DAOFactory.getSQLDAOFactory().getEtudiantDAO().update(elv, elv);
			ControllerEleve cont = ((ControllerEleve) Main.getScenesloaders().get(SceneNames.STUDENT).getController());
			cont.search();
			Stage stage = (Stage) pereDeces.getScene().getWindow();
			stage.close();
		}

	}

	public Etudiant getElv() {
		return elv;
	}

	public void setElv(Etudiant elv) {
		this.elv = elv;
		fullname.setText(elv.getEtudNom() + " " + elv.getEtudPrenom());

		adresseEleve.setText(elv.getEtudAd1());
		ville.setText(elv.getEtudVil());
		cps.setText(String.valueOf(elv.getEtudCPS()));
		telephoneEleve.setText(elv.getEtudTel());
		mailEleve.setText(elv.getEtudMail());
		situationFamilialeEleve.getSelectionModel().select(elv.getEtudSfam());
		RIBEleve.setText(elv.getEtudRib());
		if (elv.getEtudDDP() != null) {
			pereDeces.setSelected(true);
			dateDecesPere.setValue(elv.getEtudDDP());
		}
		if (elv.getEtudDDM() != null) {
			mereDeces.setSelected(true);
			dateDecesMere.setValue(elv.getEtudDDM());
		}

	}

}
