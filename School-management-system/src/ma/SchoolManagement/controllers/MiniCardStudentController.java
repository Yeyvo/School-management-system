package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
	@FXML
	private Text email;
	
	
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
			stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
			stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void detail(){
		((ControllerEleve)Main.getScenesloaders().get(SceneNames.STUDENT).getController()).setBig(elv);
	}

	
	@FXML
	private void delete() {
		DAOFactory.getSQLDAOFactory().getEtudiantDAO().delete(elv);
		ControllerEleve cont  = ((ControllerEleve) Main.getScenesloaders().get(SceneNames.STUDENT).getController());
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
		email.setText(elv.getEtudMail());
		prenom.setText(elv.getEtudPrenom());
	}

}
