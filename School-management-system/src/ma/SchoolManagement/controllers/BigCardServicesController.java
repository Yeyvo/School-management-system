package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class BigCardServicesController implements Initializable {

	@FXML
	private Text id;
	@FXML
	private Text EtudANSC;
	@FXML
	private Text EtudCMBO;
	@FXML
	private CheckBox EtudBO;
	@FXML
	private CheckBox EtudCU;
	@FXML
	private CheckBox EtudCMB;
	@FXML
	private HBox boxCMBO;


	private ServicesEtud srv;

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
			((ModifServicesController) loader.getController()).setSrv(srv);
			Stage stage = new Stage();
			stage.setScene(new Scene(info));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void detail() {
		((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController()).setBig(srv);
		
	}
	
	@FXML
	private void delete() {
		DAOFactory.getSQLDAOFactory().getServicesEtudDAO().delete(srv);
		((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController()).search();
		((ControllerService) Main.getScenesloaders().get(SceneNames.SERVICE).getController()).removeBig();
	}


	public ServicesEtud getSrv() {
		return srv;
	}

	public void setSrv(ServicesEtud srv) {
		this.srv = srv;
		id.setText(String.valueOf(srv.getEtudId()));
		EtudANSC.setText(srv.getEtudANSC());
		EtudBO.setSelected(srv.isEtudBO());
		EtudCU.setSelected(srv.isEtudCU());
		EtudCMB.setSelected(srv.isEtudCMB());
		if(srv.getEtudCMBO() != null) {
			EtudCMBO.setText(srv.getEtudCMBO());
		}else {
			boxCMBO.setVisible(false);
		}

	}

}
