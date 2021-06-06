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
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class MiniCardServicesController implements Initializable {

	@FXML
	private Text id;
	@FXML
	private Text ans;

	private ServicesEtud fil;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private void show_edit() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_service.fxml"));
			Parent info = loader.load();
			((ModifServicesController) loader.getController()).setSrv(fil);
			Stage stage = new Stage();
			stage.setScene(new Scene(info));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void detail() {
		((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController()).setBig(fil);
	}

	@FXML
	private void delete() {
		DAOFactory.getSQLDAOFactory().getServicesEtudDAO().delete(fil);
		ControllerService cont = ((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController());
		cont.search();
		if (cont.getBigetud().getEtudId() == fil.getEtudId() && cont.getBigetud().getEtudANSC() == fil.getEtudANSC()) {
			cont.removeBig();
		}
	}

	public ServicesEtud getSrv() {
		return fil;
	}

	public void setSlv(ServicesEtud srv) {
		this.fil = srv;
		id.setText(String.valueOf(srv.getEtudId()));
		ans.setText(srv.getEtudANSC());
	}

}
