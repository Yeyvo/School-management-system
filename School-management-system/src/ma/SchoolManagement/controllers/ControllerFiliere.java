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
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ControllerFiliere implements Initializable {

	@FXML
	private TextField searchbar;
	@FXML
	private VBox vbscroll;
	@FXML
	private VBox vboxBig;
	@FXML
	private ScrollPane scrollpane;

	Set<Filiere> fil = new HashSet<>();
	
	private Filiere Bigetud;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		search();

	}

	@FXML
	private void show_edit(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_filiere.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_filiere.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

	@FXML
	void search() {
		
		if(fil != null) {
			Iterator<Filiere> iter = fil.iterator();
			if(iter.hasNext())
				setBig(iter.next());
		}
		
		vbscroll.getChildren().clear();
		
		if (searchbar.getText() != null && !searchbar.getText().equals("")) {
			fil = DAOFactory.getFiliereDAO().find(searchbar.getText());
		} else if (searchbar.getText().equals("")) {
			fil = DAOFactory.getFiliereDAO().all();
		}

		for (Filiere etud : fil) {

			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(new DynamicViews().getClass()
						.getResource("/ma/SchoolManagement/view/fxml/miniCardFiliere.fxml"));
				HBox mini = loader.load();
				((MiniCardFiliereController) loader.getController()).setElv(etud);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));
				
				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	

	public void setBig(Filiere elv) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/bigCardFiliere.fxml"));
			HBox big = loader.load();
			((BigCardFiliereController) loader.getController()).setFil(elv);
			Bigetud = elv;
			vboxBig.getChildren().clear();
			vboxBig.getChildren().add(big);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeBig() {
		vboxBig.getChildren().clear();
	}

	public Filiere getBigetud() {
		return Bigetud;
	}

	public void setBigetud(Filiere bigetud) {
		Bigetud = bigetud;
	}

	
	
}