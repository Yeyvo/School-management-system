package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ControllerEtablissement implements Initializable {

	@FXML
	private TextField searchbar;
	@FXML
	private VBox vbscroll;
	@FXML
	private VBox vboxBig;
	@FXML
	private ScrollPane scrollpane;

	Set<Etablissement> data = new HashSet<>();
	
	private Etablissement Bigetud;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		search();

	}

	@FXML
	private void show_edit() throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_etablissement.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

	@FXML
	private void show_add() throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_etablissement.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

	@FXML
	void search() {
		
		if(data != null) {
			Iterator<Etablissement> iter = data.iterator();
			if(iter.hasNext())
				setBig(iter.next());
		}
		
		vbscroll.getChildren().clear();
		
		if (searchbar.getText() != null && !searchbar.getText().equals("")) {
			data = DAOFactory.getEtablissementDAO().find(searchbar.getText());
		} else if (searchbar.getText().equals("")) {
			data = DAOFactory.getEtablissementDAO().all();
		}

		for (Etablissement etud : data) {

			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(new DynamicViews().getClass()
						.getResource("/ma/SchoolManagement/view/fxml/miniCardEtablissement.fxml"));
				HBox mini = loader.load();
				((MiniCardEtablissementController) loader.getController()).setElv(etud);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));
				
				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	

	public void setBig(Etablissement etab) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/bigCardEtablissement.fxml"));
			HBox big = loader.load();
			((BigCardEtablissementController) loader.getController()).setEtablissement(etab);
			Bigetud = etab;
			vboxBig.getChildren().clear();
			vboxBig.getChildren().add(big);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeBig() {
		vboxBig.getChildren().clear();
	}

	public Etablissement getBigetud() {
		return Bigetud;
	}

	public void setBigetud(Etablissement bigetud) {
		Bigetud = bigetud;
	}

	
	
}