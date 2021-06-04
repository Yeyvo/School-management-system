package ma.SchoolManagement;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ma.SchoolManagement.controllers.DashboardController;
import ma.SchoolManagement.view.SceneNames;

public class Main extends Application {

	static BorderPane mainLayout = null;
	
	private static Map<SceneNames, Scene> scenes = new HashMap<>();
	private static Map<SceneNames, FXMLLoader> scenesloaders = new HashMap<>();
	private static Stage primary;
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	
		primary = primaryStage;
		scenes.put(SceneNames.DASHBOARD, returnSceneDashboard());
		//scenes.put(SceneNames.LOGING, returnSceneloging());
		

        primaryStage.setScene(scenes.get(SceneNames.DASHBOARD));
        
        primaryStage.setTitle("Gestion des Eleves  - [ Hamza CHAFKAN  |  AHMED ALI ATTAOUI ] -");
        primaryStage.getIcons().add(new Image("/ma/SchoolManagement/view/icons/icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
	public Scene returnSceneDashboard() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/fxml/dashboard.fxml"));
			mainLayout = loader.load();
			scenesloaders.put(SceneNames.DASHBOARD, loader);
			Scene scene = new Scene(mainLayout);
			return scene;
		} catch (Exception e) {
			e.printStackTrace();
			return (null);
		}
	}

	public Scene returnSceneloging() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("views/loging.fxml"));
			Parent root = loader.load();
			scenesloaders.put(SceneNames.LOGING, loader);
			Scene scene = new Scene(root);
			return (scene);
		} catch (Exception e) {
			e.printStackTrace();
			return (null);
		}
	}

    public static void main(String[] args) {
        launch(args);
    }

	public static Map<SceneNames, Scene> getScenes() {
		return scenes;
	}

	public static void setScenes(Map<SceneNames, Scene> scenes) {
		Main.scenes = scenes;
	}

	public static Map<SceneNames, FXMLLoader> getScenesloaders() {
		return scenesloaders;
	}

	public static void setScenesloaders(Map<SceneNames, FXMLLoader> scenesloaders) {
		Main.scenesloaders = scenesloaders;
	}

	public static Stage getPrimary() {
		return primary;
	}

	public static void setPrimary(Stage primary) {
		Main.primary = primary;
	}

    
    
}
