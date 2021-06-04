package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ChoixServiceController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void show_liste(MouseEvent event) throws IOException {
		((DashboardController)Main.getScenesloaders().get(SceneNames.DASHBOARD).getController()).updatetoliste();
	}

	@FXML
	private void show_mod(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(
				new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_couverture_sociale.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(
				new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/add_couverture_sociale.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

}
