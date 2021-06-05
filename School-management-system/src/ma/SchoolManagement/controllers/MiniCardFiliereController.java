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
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class MiniCardFiliereController implements Initializable {
	
	@FXML
	private Text nom;
	
	private Filiere fil;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
	private void show_edit(){

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_filiere.fxml"));
			Parent info = loader.load();
			((ModifFiliereController) loader.getController()).setElv(fil);
			Stage stage = new Stage();
			stage.setScene(new Scene(info));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void detail(){
		((ControllerFiliere)Main.getScenesloaders().get(SceneNames.FILIERE).getController()).setBig(fil);
	}

	
	@FXML
	private void delete() {
		DAOFactory.getFiliereDAO().delete(fil);
		ControllerFiliere cont  = ((ControllerFiliere) Main.getScenesloaders().get(SceneNames.FILIERE).getController());
		cont.search();
		if(cont.getBigetud().getCodeEtab() == fil.getCodeEtab() && cont.getBigetud().getCodeFil() == fil.getCodeFil()) {
			cont.removeBig();
		}
	}

	public Filiere getElv() {
		return fil;
	}

	public void setElv(Filiere etab) {
		this.fil = etab;
		nom.setText(etab.getDesFil());

	}

}
