package ma.SchoolManagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class EditCouvSocialController implements Initializable {

	@FXML
	private TextField idEtudiant;
	
	@FXML
	private RadioButton ouiBourse;
	
	@FXML
	private RadioButton nonBourse;
	
	@FXML
	private RadioButton ouiCiteUniv;
	
	@FXML
	private RadioButton nonCiteUniv;
	
	@FXML
	private RadioButton ouiCouvMed;
	
	@FXML
	private RadioButton nonCouvMed;
	
	@FXML
	private TextField couvMed;
	
	@FXML
	private Button modifCouvSoc;
	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
