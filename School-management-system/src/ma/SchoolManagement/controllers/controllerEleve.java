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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.helpers.DynamicViews;

public class controllerEleve  implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}

	
	@FXML
	private void show_edit(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/edit_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/ajout_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	@FXML
	private void show_info(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/info_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
}