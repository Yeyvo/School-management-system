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
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class AjoutFiliereController implements Initializable {

	@FXML
	private TextField CodeEtab;
	@FXML
	private TextField CodeFil;
	@FXML
	private TextField DesFil;

	@FXML
	private void add_eleve() throws IOException {

		if (CodeEtab.getText().isBlank() || CodeFil.getText().isBlank() || DesFil.getText().isBlank()) {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		} else {
			Filiere data = new Filiere(Integer.valueOf(CodeEtab.getText()), Integer.valueOf(CodeFil.getText()),
					DesFil.getText());
			if (!DAOFactory.getSQLDAOFactory().getFiliereDAO().create(data)) {
				Alert alert = new Alert(AlertType.WARNING, "Ajout impossible");
				alert.show();
			} else {
				((ControllerFiliere) Main.getScenesloaders().get(SceneNames.FILIERE).getController()).search();
			}
			Stage stage = (Stage) DesFil.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
