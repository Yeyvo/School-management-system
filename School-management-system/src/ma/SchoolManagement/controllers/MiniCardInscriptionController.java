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
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class MiniCardInscriptionController implements Initializable {

	@FXML
	private Text id;
	@FXML
	private Text ans;
	
	private Inscription fil;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
	private void show_edit(){

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_inscription.fxml"));
			Parent info = loader.load();
			((ModifInscripionController) loader.getController()).setInsc(fil);
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
		((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController()).setBig(fil);
	}

	
	@FXML
	private void delete() {
		DAOFactory.getSQLDAOFactory().getInscriptionDAO().delete(fil);
		ControllerInscription cont  = ((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController());
		cont.search();
		if(cont.getBigetud().getEtudId() == fil.getEtudId() && cont.getBigetud().getEtudInsc() == fil.getEtudInsc() && cont.getBigetud().getEtudEtab() == fil.getEtudEtab()) {
			cont.removeBig();
		}
	}

	public Inscription getSrv() {
		return fil;
	}

	public void setSlv(Inscription srv) {
		this.fil = srv;
		Etudiant etud = DAOFactory.getSQLDAOFactory().getEtudiantDAO().findid(String.valueOf(srv.getEtudId()));
		id.setText(etud.getEtudNom() + " " + etud.getEtudPrenom());
		ans.setText(srv.getEtudInsc());
	}
}
