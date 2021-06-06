package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class AjoutInscriptionController implements Initializable {

	@FXML
	private TextField EtudId;
	@FXML
	private TextField EtudEtab;
	@FXML
	private TextField EtudFil;
	@FXML
	private TextField EtudInsc;

	@FXML
	private void add_eleve() throws IOException {

		if (EtudId.getText().isBlank() || EtudEtab.getText().isBlank() || EtudFil.getText().isBlank()
				|| EtudInsc.getText().isBlank()) {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		} else {
			Inscription data = new Inscription(Integer.valueOf(EtudId.getText()), Integer.valueOf(EtudEtab.getText()),
					Integer.valueOf(EtudFil.getText()), EtudInsc.getText());
			if (!DAOFactory.getSQLDAOFactory().getInscriptionDAO().create(data)) {
				Alert alert = new Alert(AlertType.WARNING, "Ajout impossible");
				alert.show();
			} else {
				((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController()).search();
			}
			Stage stage = (Stage) EtudInsc.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
