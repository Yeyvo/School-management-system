package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.stage.StageHelper;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.model.dao.exel.FiliereEXCELDAO;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class AjoutInscriptionController implements Initializable {

	@FXML
	private ChoiceBox<Etudiant> EtudId;
	@FXML
	private ChoiceBox<Etablissement> EtudEtab;
	@FXML
	private ChoiceBox<Filiere> EtudFil;
	@FXML
	private ChoiceBox<String> EtudInsc;

	@FXML
	private void add_eleve() throws IOException {

		if (EtudId.getValue() == null || EtudEtab.getValue() == null || EtudFil.getValue() == null
				|| EtudInsc.getValue() == null) {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		} else {
			Inscription data = new Inscription(EtudId.getValue().getEtudId(), EtudEtab.getValue().getCodeEtab(),
					EtudFil.getValue().getCodeFil(), EtudInsc.getValue());
			if (!DAOFactory.getSQLDAOFactory().getInscriptionDAO().create(data)) {
				Alert alert = new Alert(AlertType.WARNING, "Ajout impossible");
				alert.show();
			} else {
				((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController()).search();
			}
			Stage stage = (Stage) EtudInsc.getScene().getWindow();
			stage.close();
		}
	}

	@FXML
	void addelv(ActionEvent event) {
		Stage stage = new Stage();
		try {
//			Parent home = FXMLLoader
//					.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_eleve.fxml"));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_eleve.fxml"));
			Parent home = loader.load();
			stage.setScene(new Scene(home));
			stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
			stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
			stage.setResizable(false);
			stage.show();
			stage.setOnHiding(e -> {
				EtudId.getItems().clear();
				ObservableList<Etudiant> etuds = FXCollections
						.observableArrayList(DAOFactory.getSQLDAOFactory().getEtudiantDAO().all());
				EtudId.getItems().setAll(etuds);
			});
			((AjoutEleveController) loader.getController()).setSearch(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void addetab(ActionEvent event) {
		Stage stage = new Stage();
		try {
//			Parent home = FXMLLoader.load(new DynamicViews().getClass()
//					.getResource("/ma/SchoolManagement/view/fxml/ajout_etablissement.fxml"));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_etablissement.fxml"));
			Parent home = loader.load();
			stage.setScene(new Scene(home));
			stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
			stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
			stage.setResizable(false);
			stage.show();
			stage.setOnHiding(e -> {
				ObservableList<Etablissement> etabs = FXCollections
						.observableArrayList(DAOFactory.getSQLDAOFactory().getEtablissementDAO().all());
				EtudEtab.getItems().clear();
				EtudEtab.getItems().setAll(etabs);
			});
			((AjoutEtablissementController) loader.getController()).setSearch(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void addfil(ActionEvent event) {
		Stage stage = new Stage();
		try {
//			Parent home = FXMLLoader.load(
//					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_filiere.fxml"));
//			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_filiere.fxml"));
			Parent home = loader.load();
			stage.setScene(new Scene(home));
			stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
			stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
			stage.setResizable(false);
			stage.show();
			stage.setOnHiding(e -> {
				if (EtudEtab.getValue() != null) {
					EtudFil.getItems().clear();
					ObservableList<Filiere> fil = FXCollections.observableArrayList(
							DAOFactory.getSQLDAOFactory().getFiliereDAO().allinEtab(EtudEtab.getValue().getCodeEtab()));
					EtudFil.getItems().setAll(fil);
				}
			});
			((AjoutFiliereController) loader.getController()).setSearch(false);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Etablissement> etabs = FXCollections
				.observableArrayList(DAOFactory.getSQLDAOFactory().getEtablissementDAO().all());
		EtudEtab.getItems().setAll(etabs);

		ObservableList<Etudiant> etuds = FXCollections
				.observableArrayList(DAOFactory.getSQLDAOFactory().getEtudiantDAO().all());
		EtudId.getItems().setAll(etuds);

		ChangeListener<Etablissement> changeListener = new ChangeListener<Etablissement>() {

			@Override
			public void changed(ObservableValue<? extends Etablissement> observable, //
					Etablissement oldValue, Etablissement newValue) {
				if (newValue != null) {
					EtudFil.getItems().clear();
					ObservableList<Filiere> fil = FXCollections.observableArrayList(
							DAOFactory.getSQLDAOFactory().getFiliereDAO().allinEtab(newValue.getCodeEtab()));
					EtudFil.getItems().setAll(fil);
				}
			}
		};
		// Selected Item Changed.
		EtudEtab.getSelectionModel().selectedItemProperty().addListener(changeListener);

		EtudInsc.getItems().addAll("2019/2020", "2020/2021", "2021/2022", "2022/2023", "2023/2024", "2024/2025");

	}

}
