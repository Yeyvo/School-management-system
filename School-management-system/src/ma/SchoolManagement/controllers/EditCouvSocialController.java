package ma.SchoolManagement.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

public class EditCouvSocialController {

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
}
