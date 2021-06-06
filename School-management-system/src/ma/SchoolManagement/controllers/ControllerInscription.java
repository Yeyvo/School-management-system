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
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ControllerInscription implements Initializable {

	@FXML
	private TextField searchbar;
	@FXML
	private VBox vbscroll;
	@FXML
	private VBox vboxBig;
	@FXML
	private ScrollPane scrollpane;

	Set<Inscription> Inscription = new HashSet<>();
	
	private Inscription Bigetud;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Inscription = DAOFactory.getSQLDAOFactory().getInscriptionDAO().all();
		search();

	}

	@FXML
	private void show_edit(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_inscription.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_inscription.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}

	@FXML
	void search() {
		
		if(Inscription != null) {
			Iterator<Inscription> iter = Inscription.iterator();
			if(iter.hasNext())
				setBig(iter.next());
		}
		
		vbscroll.getChildren().clear();
		
		if (searchbar.getText() != null && !searchbar.getText().equals("")) {
			Inscription = DAOFactory.getSQLDAOFactory().getInscriptionDAO().find(searchbar.getText());
		} else if (searchbar.getText().equals("")) {
			Inscription = DAOFactory.getSQLDAOFactory().getInscriptionDAO().all();
		}

		for (Inscription etud : Inscription) {

			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(new DynamicViews().getClass()
						.getResource("/ma/SchoolManagement/view/fxml/miniCardInscription.fxml"));
				HBox mini = loader.load();
				((MiniCardInscriptionController) loader.getController()).setSlv(etud);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));
				
				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	

	public void setBig(Inscription srv) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/bigCardInscription.fxml"));
			HBox big = loader.load();
			((BigCardInscriptionController) loader.getController()).setElv(srv);
			Bigetud = srv;
			vboxBig.getChildren().clear();
			vboxBig.getChildren().add(big);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeBig() {
		vboxBig.getChildren().clear();
	}

	public Inscription getBigetud() {
		return Bigetud;
	}

	public void setBigetud(Inscription bigetud) {
		Bigetud = bigetud;
	}

	
	
}