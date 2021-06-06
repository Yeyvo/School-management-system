package ma.SchoolManagement.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.dao.DAOFactory;

public class ModifFiliereController implements Initializable {

	@FXML
	private TextField DesFil;
	@FXML
	private Text fullname;

	private Filiere elv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void vall() {

		if (!DesFil.getText().isBlank()) {

			elv.setDesFil(DesFil.getText());

			DAOFactory.getSQLDAOFactory().getFiliereDAO().update(elv, elv);
			Stage stage = (Stage) DesFil.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		}
	}

	public Filiere getElv() {
		return elv;
	}

	public void setElv(Filiere elv) {
		this.elv = elv;
		fullname.setText(elv.getDesFil());
	}

}
