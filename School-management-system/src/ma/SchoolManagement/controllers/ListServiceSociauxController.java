package ma.SchoolManagement.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class ListServiceSociauxController implements Initializable {

	@FXML
	private TreeTableView serviceSociauxTable;

	@FXML
	private TreeTableColumn idEtudColumn;

	@FXML
	private TreeTableColumn etabEtudColumn;

	@FXML
	private TreeTableColumn bourseEtudColumn;

	@FXML
	private TreeTableColumn CUEtudColumn;

	@FXML
	private TreeTableColumn couvMedEtudColumn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
