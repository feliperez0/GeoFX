package dad.geofx.api;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MainController controller = new MainController();

		Scene scene = new Scene(controller.getView(), 600, 400);

		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
