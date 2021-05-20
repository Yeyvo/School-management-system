package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import ma.SchoolManagement.helpers.DynamicViews;

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
	private void show_dashboard(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "eleves");
	}

	@FXML
	private void show_listeService(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "services-choix");
	}

	@FXML
	private void show_eleve(MouseEvent event) throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "eleves");
	}


	public void updatetoliste() throws IOException {
		DynamicViews.loadBorderCenter(border_pane, "liste_services");		
	}

}
