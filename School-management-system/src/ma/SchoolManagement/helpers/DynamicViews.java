package ma.SchoolManagement.helpers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class DynamicViews {

	public DynamicViews() {
	}
	
	public static void loadBorderCenter(BorderPane borderPane, String ressources) throws IOException {

//		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("fxml/"+ressources+".fxml"));
		Parent home = FXMLLoader.load(new DynamicViews().getClass().getResource("/ma/SchoolManagement/fxml/"+ressources+".fxml"));
		System.out.println("dkznqkcnl");
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
