package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Etablissement> etabs = FXCollections.observableArrayList(DAOFactory.getSQLDAOFactory().getEtablissementDAO().all());
		EtudEtab.getItems().setAll(etabs);

		ObservableList<Etudiant> etuds = FXCollections.observableArrayList(DAOFactory.getSQLDAOFactory().getEtudiantDAO().all());
		EtudId.getItems().setAll(etuds);
		
		
        ChangeListener<Etablissement> changeListener = new ChangeListener<Etablissement>() {
        	 
            @Override
            public void changed(ObservableValue<? extends Etablissement> observable, //
            		Etablissement oldValue, Etablissement newValue) {
                if (newValue != null) {
                	EtudFil.getItems().clear();
            		ObservableList<Filiere> fil = FXCollections.observableArrayList(DAOFactory.getSQLDAOFactory().getFiliereDAO().allinEtab(newValue.getCodeEtab()));
            		EtudFil.getItems().setAll(fil);
                }
            }
        };
        // Selected Item Changed.
        EtudEtab.getSelectionModel().selectedItemProperty().addListener(changeListener);
		

        
		EtudInsc.getItems().addAll("2019/2020","2020/2021","2021/2022","2022/2023","2023/2024","2024/2025");
		
	}

}
