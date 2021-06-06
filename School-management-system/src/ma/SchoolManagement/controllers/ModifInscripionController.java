package ma.SchoolManagement.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;

public class ModifInscripionController implements Initializable {

	@FXML
	private Text fullname;
	@FXML
	private TextField EtudInsc;

	private Inscription insc;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void vall() {
		String EtudInscstr = EtudInsc.getText();

		if (!EtudInscstr.isBlank()) {
			insc.setEtudInsc(EtudInscstr);

			DAOFactory.getSQLDAOFactory().getInscriptionDAO().update(insc, insc);

			Stage stage = (Stage) EtudInsc.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		}
	}

	public Inscription getInsc() {
		return insc;
	}

	public void setInsc(Inscription insc) {
		this.insc = insc;
		fullname.setText(String.valueOf(insc.getEtudId()));
	}

}
