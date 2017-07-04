/**
 * 
 */
package com.epam.library.main;

import com.epam.library.beans.User;
import com.epam.library.services.ServiceFactory;
import com.epam.library.services.exception.ServiceException;

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
//		ServiceFactory serviceFactory = new ServiceFactory();
//		try {
//			User user = serviceFactory.getUserService().singIn("user", "12345");
//			System.out.println(user.getName());
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
		primaryStage.setTitle("Desktop library");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.setResizable(false);
		primaryStage.setMaximized(false);
		primaryStage.show();
	}
}
