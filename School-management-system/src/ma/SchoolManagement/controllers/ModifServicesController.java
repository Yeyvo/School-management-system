package ma.SchoolManagement.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class ModifServicesController implements Initializable {

	@FXML
	private Text fullname;
	@FXML
	private TextField idEtudiant;
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

	private ServicesEtud srv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void vall() {

		boolean ouiB = ouiBourse.isSelected();
		boolean ouiCU = ouiCiteUniv.isSelected();
		boolean ouiCM = ouiCouvMed.isSelected();
		String CM = couvMed.getText();

		boolean valide = true;

		srv.setEtudBO(ouiB);
		srv.setEtudCU(ouiCU);
		srv.setEtudCMB(ouiCM);
		if (ouiCM && !CM.isBlank()) {
			srv.setEtudCMBO(CM);
		} else if (ouiCM && CM.isBlank()) {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
			valide = false;
		}
		if (valide) {
			DAOFactory.getSQLDAOFactory().getServicesEtudDAO().update(srv, srv);
			ControllerService cont = ((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController());
			cont.search();
			Stage stage = (Stage) couvMed.getScene().getWindow();
			stage.close();
		}
	}

	public ServicesEtud getSrv() {
		return srv;
	}

	public void setSrv(ServicesEtud srv) {
		this.srv = srv;
		Etudiant etud = DAOFactory.getSQLDAOFactory().getEtudiantDAO().findid(String.valueOf(srv.getEtudId()));
		fullname.setText(etud.getEtudNom() + " " + etud.getEtudPrenom());
		
		if(srv.isEtudBO()) {
			ouiBourse.selectedProperty().set(true);
		} else {
			nonBourse.selectedProperty().set(true);
		}
		if(srv.isEtudCU()) {
			ouiCiteUniv.selectedProperty().set(true);
		} else {
			nonCiteUniv.selectedProperty().set(true);
		}
		if(srv.isEtudCMB()) {
			ouiCouvMed.selectedProperty().set(true);
			couvMed.setText(srv.getEtudCMBO());
		} else {
			nonCouvMed.selectedProperty().set(true);
		}
		
		
	}

}
