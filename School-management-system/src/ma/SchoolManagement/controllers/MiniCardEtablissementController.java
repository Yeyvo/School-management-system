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
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class MiniCardEtablissementController implements Initializable {
	
	@FXML
	private Text nom;
	
	private Etablissement etab;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
	private void show_edit(){

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_etablissement.fxml"));
			Parent info = loader.load();
			((ModifEtablissementController) loader.getController()).setEtablissement(etab);
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
		((ControllerEtablissement)Main.getScenesloaders().get(SceneNames.ETABLISSEMENT).getController()).setBig(etab);
	}

	
	@FXML
	private void delete() {
		DAOFactory.getSQLDAOFactory().getEtablissementDAO().delete(etab);
		ControllerEtablissement cont  = ((ControllerEtablissement) Main.getScenesloaders().get(SceneNames.ETABLISSEMENT).getController());
		cont.search();
		if(cont.getBigetud().getCodeEtab() == etab.getCodeEtab()) {
			cont.removeBig();
		}
	}

	public Etablissement getElv() {
		return etab;
	}

	public void setElv(Etablissement etab) {
		this.etab = etab;
		nom.setText(etab.getDesEtab());

	}

}
