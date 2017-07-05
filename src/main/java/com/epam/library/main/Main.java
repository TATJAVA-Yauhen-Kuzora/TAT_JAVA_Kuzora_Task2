/**
 * 
 */
package com.epam.library.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Yauhen_Kuzora
 *
 */
public class Main extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
		primaryStage.setTitle("Desktop library");
		primaryStage.setScene(new Scene(root, 600, 600));
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		primaryStage.show();
	}
}
