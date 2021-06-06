package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class DashboardController implements Initializable {
	@FXML
	private BorderPane border_pane;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			DynamicViews.loadBorderCenter(border_pane, "eleves");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DashboardController() {

	}


	@FXML
	private void show_listeService() throws IOException   {
		DynamicViews.loadBorderCenter(border_pane, "service");
	}

	@FXML
	private void show_eleve() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "eleves");
	}

	@FXML
	private void etablissement() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "etablissement");
	}

	@FXML
	private void filieres() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "filiere");
	}
	@FXML
	private void inscription() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "inscription");
	}



	@FXML
	private void toexcel() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "choixExcel");
	}

}
