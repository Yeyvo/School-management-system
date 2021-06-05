package ma.SchoolManagement.view.helpers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import ma.SchoolManagement.Main;
import ma.SchoolManagement.view.SceneNames;

public class DynamicViews {

	public DynamicViews() {
	}

	public static void loadBorderCenter(BorderPane borderPane, String ressources) throws IOException {

//		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("fxml/"+ressources+".fxml"));
//		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/"+ressources+".fxml"));

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(
				new DynamicViews().getClass().getResource("/ma/SchoolManagement/view/fxml/" + ressources + ".fxml"));
		Parent home = loader.load();

		if (ressources.equals("eleves")) {
			Main.getScenesloaders().put(SceneNames.STUDENT, loader);
		} else 		if (ressources.equals("filiere")) {
			Main.getScenesloaders().put(SceneNames.FILIERE, loader);
		} else 		if (ressources.equals("etablissement")) {
			Main.getScenesloaders().put(SceneNames.ETABLISSEMENT, loader);
		} else 		if (ressources.equals("service")) {
			Main.getScenesloaders().put(SceneNames.SERVICE, loader);
		}

//		System.out.println("dkznqkcnl");
		borderPane.setCenter(home);
	}

//	public static void loadBorderCenterParent(BorderPane borderPane, String ressources) throws IOException {
//
////		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("fxml/"+ressources+".fxml"));
//		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/"+ressources+".fxml"));
//		System.out.println("dkznqkcnl");
//		borderPane.setCenter(home.getParent());
//	}

}
