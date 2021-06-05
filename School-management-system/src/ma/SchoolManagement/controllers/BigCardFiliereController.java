package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Filiere;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class BigCardFiliereController implements Initializable {

	@FXML
	private Text DesFil;
	@FXML
	private Text CodeFil;
	@FXML
	private Text CodeEtab;


	private Filiere fil;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void show_edit() {
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
	private void detail() {
		((ControllerFiliere) Main.getScenesloaders().get(SceneNames.FILIERE).getController()).setBig(fil);
		
	}
	
	@FXML
	private void delete() {
		DAOFactory.getFiliereDAO().delete(fil);
		((ControllerFiliere) Main.getScenesloaders().get(SceneNames.FILIERE).getController()).search();
		((ControllerFiliere) Main.getScenesloaders().get(SceneNames.FILIERE).getController()).removeBig();
	}


	public Filiere getFlv() {
		return fil;
	}

	public void setFil(Filiere etab) {
		this.fil = etab;
		DesFil.setText(etab.getDesFil());
		CodeFil.setText(String.valueOf(etab.getCodeFil()));
		CodeEtab.setText(String.valueOf(etab.getCodeEtab()));

	}

}
