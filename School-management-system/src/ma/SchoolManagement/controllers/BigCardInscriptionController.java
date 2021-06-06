package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class BigCardInscriptionController implements Initializable {

	@FXML
	private Text nomprenom;
	@FXML
	private Text EtudId;
	@FXML
	private Text EtudEtab;
	@FXML
	private Text EtudFil;
	@FXML
	private Text EtudInsc;

	private Inscription elv;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void show_edit() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_eleve.fxml"));
			Parent info = loader.load();
			((ModifInscripionController) loader.getController()).setInsc(elv);
			Stage stage = new Stage();
			stage.setScene(new Scene(info));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void detail() {
		((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController()).setBig(elv);
		
	}
	
	@FXML
	private void delete() {
		DAOFactory.getSQLDAOFactory().getInscriptionDAO().delete(elv);
		((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController()).search();
		((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController()).removeBig();
	}


	public Inscription getElv() {
		return elv;
	}

	public void setElv(Inscription elv) {
		this.elv = elv;
		//nomprenom.setText(elv.getEtudNom() + " " + elv.getEtudPrenom());
		EtudId.setText(String.valueOf(elv.getEtudId()));
		EtudEtab.setText(String.valueOf(elv.getEtudEtab()));
		EtudFil.setText(String.valueOf(elv.getEtudFil()));
		EtudInsc.setText(elv.getEtudInsc());

	}

}
