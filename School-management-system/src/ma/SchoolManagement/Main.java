package ma.SchoolManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ma.SchoolManagement.controllers.DashboardController;

public class Main extends Application {

	private static DashboardController controllerdashboard;
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	FXMLLoader rootfx = new FXMLLoader(getClass().getResource("fxml/dashboard.fxml"));
        Parent root = rootfx.load();
        controllerdashboard = rootfx.getController();
        primaryStage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
        primaryStage.getIcons().add(new Image("/ma/SchoolManagement/icons/icon.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

	public static DashboardController getControllerdashboard() {
		return controllerdashboard;
	}
    
}
