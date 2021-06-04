package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class MiniCardStudentController implements Initializable {
	
	@FXML
	private Text nom;
	@FXML
	private Text prenom;
	
	
	private Etudiant elv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
	private void show_edit(){

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_eleve.fxml"));
			Parent info = loader.load();
			((ModifEleveController) loader.getController()).setElv(elv);
			Stage stage = new Stage();
			stage.setScene(new Scene(info));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void detail(){
		((controllerEleve)Main.getScenesloaders().get(SceneNames.STUDENT).getController()).setBig(elv);
	}

	
	@FXML
	private void delete() {
		DAOFactory.getEtudiantDAO().delete(elv);
		controllerEleve cont  = ((controllerEleve) Main.getScenesloaders().get(SceneNames.STUDENT).getController());
		cont.search();
		if(cont.getBigetud().getEtudId() == elv.getEtudId()) {
			cont.removeBig();
		}
	}

	public Etudiant getElv() {
		return elv;
	}

	public void setElv(Etudiant elv) {
		this.elv = elv;
		nom.setText(elv.getEtudNom());
		prenom.setText(elv.getEtudPrenom());
	}

}
