package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class AjoutServiceController implements Initializable {

	@FXML
	private ChoiceBox<Etudiant> idEtudiant;
	@FXML
	private ChoiceBox<String> EtudANSC;
	@FXML
	private RadioButton ouiBourse;
	@FXML
	private RadioButton nonBourse;
	@FXML
	private RadioButton ouiCiteUniv;
	@FXML
	private RadioButton nonCiteUniv;
	@FXML
	private RadioButton ouiCouvMed;
	@FXML
	private RadioButton nonCouvMed;
	@FXML
	private TextField couvMed;
	@FXML
	private Button modifCouvSoc;
	
	
	

	@FXML
	private void add_couvSocial() {
		int id = idEtudiant.getValue().getEtudId();
		String ANSC = EtudANSC.getValue();
		boolean ouiB = ouiBourse.isSelected();
		boolean nonB = nonBourse.isSelected();
		boolean ouiCU = ouiCiteUniv.isSelected();
		boolean nonCU = nonCiteUniv.isSelected();
		boolean ouiCM = ouiCouvMed.isSelected();
		boolean nonCM = nonCouvMed.isSelected();
		String CM = couvMed.getText();

		if (idEtudiant == null || EtudANSC.getValue() == null || (ouiCM && CM.isBlank())) {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		} else {
			ServicesEtud data = new ServicesEtud(Integer.valueOf(id), ANSC, ouiB, ouiCU, ouiCM, CM);
			if (!DAOFactory.getSQLDAOFactory().getServicesEtudDAO().create(data)) {
				Alert alert = new Alert(AlertType.WARNING, "Ajout impossible");
				alert.show();
			} else {
				((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController()).search();
			}

			Stage stage = (Stage) couvMed.getScene().getWindow();
			stage.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Etudiant> etuds = FXCollections.observableArrayList(DAOFactory.getSQLDAOFactory().getEtudiantDAO().all());
        idEtudiant.getItems().setAll(etuds);
        
        EtudANSC.getItems().addAll("2019/2020","2020/2021","2021/2022","2022/2023","2023/2024","2024/2025");

        
	}

}
