package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.helpers.DynamicViews;

public class ControllerService implements Initializable {

	@FXML
	private TextField searchbar;
	@FXML
	private VBox vbscroll;
	@FXML
	private VBox vboxBig;
	@FXML
	private ScrollPane scrollpane;

	Set<ServicesEtud> services = new HashSet<>();
	
	private ServicesEtud Bigetud;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		services = DAOFactory.getSQLDAOFactory().getServicesEtudDAO().all();
		search();

	}

	@FXML
	private void show_edit(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/edit_service.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
		stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
		stage.setResizable(false);
		stage.show();
	}

	@FXML
	private void show_add(MouseEvent event) throws IOException {
		Parent home = FXMLLoader
				.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/ajout_service.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
		stage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
		stage.setResizable(false);
		stage.show();
	}

	@FXML
	void search() {
		
		if(services != null) {
			Iterator<ServicesEtud> iter = services.iterator();
			if(iter.hasNext())
				setBig(iter.next());
		}
		
		vbscroll.getChildren().clear();
		
		if (searchbar.getText() != null && !searchbar.getText().equals("")) {
			services = DAOFactory.getSQLDAOFactory().getServicesEtudDAO().find(searchbar.getText());
		} else if (searchbar.getText().equals("")) {
			services = DAOFactory.getSQLDAOFactory().getServicesEtudDAO().all();
		}

		for (ServicesEtud etud : services) {

			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(new DynamicViews().getClass()
						.getResource("/ma/SchoolManagement/view/fxml/miniCardServices.fxml"));
				HBox mini = loader.load();
				((MiniCardServicesController) loader.getController()).setSlv(etud);
				HBox.setMargin(mini, new Insets(0, 0, 5, 0));
				
				vbscroll.setAlignment(Pos.CENTER);
				vbscroll.getChildren().add(mini);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	

	public void setBig(ServicesEtud srv) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(
					new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/bigCardServices.fxml"));
			HBox big = loader.load();
			((BigCardServicesController) loader.getController()).setSrv(srv);
			Bigetud = srv;
			vboxBig.getChildren().clear();
			vboxBig.getChildren().add(big);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeBig() {
		vboxBig.getChildren().clear();
	}

	public ServicesEtud getBigetud() {
		return Bigetud;
	}

	public void setBigetud(ServicesEtud bigetud) {
		Bigetud = bigetud;
	}

	
	
}