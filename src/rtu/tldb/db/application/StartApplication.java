package rtu.tldb.db.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartApplication extends Application {
	
	public static final String TITLE = "DB Application";
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(TITLE);
		
        BorderPane root = new View();
         
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.show();
		
	}
	
}
