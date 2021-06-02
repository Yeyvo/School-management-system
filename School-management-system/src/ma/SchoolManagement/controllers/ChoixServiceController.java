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
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.helpers.DynamicViews;

public class ChoixServiceController  implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
	}

	
	@FXML
	private void show_liste(MouseEvent event) throws IOException {
		Main.getControllerdashboard().updatetoliste();
	}
	@FXML
	private void show_mod(MouseEvent event) throws IOException {
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/edit_couverture_sociale.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(home));
		stage.show();
	}
	
	@FXML
	private javafx.scene.control.TextField idEtudiant;
	
	@FXML
	private javafx.scene.control.RadioButton ouiBourse;
	
	@FXML
	private javafx.scene.control.RadioButton nonBourse;
	
	@FXML
	private javafx.scene.control.RadioButton ouiCiteUniv;
	
	@FXML
	private javafx.scene.control.RadioButton nonCiteUniv;
	
	@FXML
	private javafx.scene.control.RadioButton ouiCouvMed;
	
	@FXML
	private javafx.scene.control.RadioButton nonCouvMed;
	
	@FXML
	private javafx.scene.control.TextField couvMed;
	
	@FXML
	private javafx.scene.control.Button modifCouvSoc;
	
	private void edit_couvSocial() throws IOException {
		String id = idEtudiant.getText();
		boolean ouiB = ouiBourse.isSelected();
		boolean nonB = nonBourse.isSelected();
		boolean ouiCU = ouiCiteUniv.isSelected();
		boolean nonCU = nonCiteUniv.isSelected();
		boolean ouiCM = ouiCouvMed.isSelected();
		boolean nonCM = nonCouvMed.isSelected();
		String CM = couvMed.getText();
	}
	
	@FXML
	private javafx.scene.control.TreeTableView serviceSociauxTable;
	
	@FXML
	private javafx.scene.control.TreeTableColumn idEtudColumn;
	
	@FXML
	private javafx.scene.control.TreeTableColumn etabEtudColumn;
	
	@FXML
	private javafx.scene.control.TreeTableColumn bourseEtudColumn;
	
	@FXML
	private javafx.scene.control.TreeTableColumn CUEtudColumn;
	
	@FXML
	private javafx.scene.control.TreeTableColumn couvMedEtudColumn;
	
}
