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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ControllerEleve implements Initializable {

	@FXML
	private TextField searchbar;
	@FXML
	private VBox vbscroll;
	@FXML
	private VBox vboxBig;
	@FXML
	private ScrollPane scrollpane;

	@FXML
	private RadioButton tout;
	@FXML
	private RadioButton male;
	@FXML
	private RadioButton female;

	Set<Etudiant> etudiants = new HashSet<>();

	private Etudiant Bigetud;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().all();
		search();
	}

	@FXML
	private void show_edit(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
		stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
		stage.setResizable(false);
		stage.show();
	}

	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_eleve.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
		stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
		stage.setResizable(false);
		stage.show();
	}
	
	@FXML
	void sc() {
		search();
	}

	@FXML
	void search() {

		if (etudiants != null) {
			Iterator<Etudiant> iter = etudiants.iterator();
			if (iter.hasNext())
				setBig(iter.next());
		}

		vbscroll.getChildren().clear();

		if (tout.isSelected()) {

			if (searchbar.getText() != null && !searchbar.getText().equals("")) {
				etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().find(searchbar.getText());
			} else if (searchbar.getText().equals("")) {
				etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().all();
			}

		} else if (male.isSelected()) {

			if (searchbar.getText() != null && !searchbar.getText().equals("")) {
				etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().find(searchbar.getText(),"male");
			} else if (searchbar.getText().equals("")) {
				etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().all("male");
			}
			
		} else {

			if (searchbar.getText() != null && !searchbar.getText().equals("")) {
				etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().find(searchbar.getText(),"female");
			} else if (searchbar.getText().equals("")) {
				etudiants = DAOFactory.getSQLDAOFactory().getEtudiantDAO().all("female");
			}
			
		}

		for (Etudiant etud : etudiants) {

			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(new DynamicViews().getClass()
						.getResource("/ma/SchoolManagement/view/fxml/miniCardStudent.fxml"));
				HBox mini = loader.load();
				((MiniCardStudentController) loader.getController()).setElv(etud);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));

				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void setBig(Etudiant elv) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/bigCardStudent.fxml"));
			HBox big = loader.load();
			((BigCardStudentController) loader.getController()).setElv(elv);
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

	public Etudiant getBigetud() {
		return Bigetud;
	}

	public void setBigetud(Etudiant bigetud) {
		Bigetud = bigetud;
	}

}