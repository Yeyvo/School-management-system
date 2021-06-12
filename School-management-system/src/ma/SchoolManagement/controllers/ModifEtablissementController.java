package ma.SchoolManagement.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class ModifEtablissementController implements Initializable {

	@FXML
	private Text fullname;
	@FXML
	private TextField destxt;
	@FXML
	private TextField dpmtxt;

	private Etablissement etab;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	@FXML
	private void vall() {
		String designation = destxt.getText();
		String dpm = dpmtxt.getText();

		if (!designation.isBlank())
			etab.setDesEtab(designation);

		if (!dpm.isBlank())
			etab.setEtudDPM(dpm);

		if(DAOFactory.getSQLDAOFactory().getEtablissementDAO().update(etab, etab)) {
			((ControllerEtablissement) Main.getScenesloaders().get(SceneNames.ETABLISSEMENT).getController()).setBig(etab);
			((ControllerEtablissement) Main.getScenesloaders().get(SceneNames.ETABLISSEMENT).getController()).search();
		}

		Stage stage = (Stage) dpmtxt.getScene().getWindow();
		stage.close();

	}

	public Etablissement getEtablissement() {
		return etab;
	}

	public void setEtablissement(Etablissement etab) {
		this.etab = etab;
		fullname.setText(etab.toString());
		destxt.setText(etab.getDesEtab());
		dpmtxt.setText(etab.getEtudDPM());
		
	}

}
