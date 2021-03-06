package ma.SchoolManagement.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.model.Etablissement;
import ma.SchoolManagement.model.Etudiant;
import ma.SchoolManagement.model.Inscription;
import ma.SchoolManagement.model.ServicesEtud;
import ma.SchoolManagement.model.dao.DAOFactory;
import ma.SchoolManagement.view.SceneNames;

public class ModifInscripionController implements Initializable {

	@FXML
	private Text fullname;
	@FXML
	private ChoiceBox<String> EtudInsc;

	private Inscription insc;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		EtudInsc.getItems().addAll("2019/2020", "2020/2021", "2021/2022", "2022/2023", "2023/2024", "2024/2025");
	}

	@FXML
	private void vall() {
		String EtudInscstr = EtudInsc.getValue();

		if (EtudInsc.getValue() != null) {
			insc.setEtudInsc(EtudInscstr);

			DAOFactory.getSQLDAOFactory().getInscriptionDAO().update(insc, insc);
			ControllerInscription cont  = ((ControllerInscription) Main.getScenesloaders().get(SceneNames.INSCRIPTION).getController());
			cont.search();
			Stage stage = (Stage) EtudInsc.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(AlertType.WARNING, "Veuillez remplir correctement tout les champs obligatoires");
			alert.show();
		}
	}

	public Inscription getInsc() {
		return insc;
	}

	public void setInsc(Inscription insc) {
		this.insc = insc;
		Etudiant etud = DAOFactory.getSQLDAOFactory().getEtudiantDAO().findid(String.valueOf(insc.getEtudId()));
		fullname.setText(etud.getEtudNom() + " " + etud.getEtudPrenom());
		EtudInsc.getSelectionModel().select(insc.getEtudInsc());
	}

}
