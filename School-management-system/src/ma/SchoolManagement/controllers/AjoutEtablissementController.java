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
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class AjoutEtablissementController implements Initializable {

	@FXML
	private TextField des;

	@FXML
	private TextField dpm;

	boolean search = true;
	
	@FXML
	private void add_eleve() throws IOException {

		if (des.getText().isBlank() || dpm.getText().isBlank()) {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		} else {

			Etablissement data = new Etablissement(0, des.getText(), dpm.getText());
			if (!DAOFactory.getSQLDAOFactory().getEtablissementDAO().create(data)) {
				Alert alert = new Alert(AlertType.WARNING, "Ajout impossible");
				alert.show();
			} else {
				if(search)
				((ControllerEtablissement) Main.getScenesloaders().get(SceneNames.ETABLISSEMENT).getController())
						.search();
			}
			Stage stage = (Stage) dpm.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	
	
}
