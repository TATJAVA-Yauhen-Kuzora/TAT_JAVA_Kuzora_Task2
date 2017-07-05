package com.epam.library.guicontroller;

import com.epam.library.beans.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.interfaces.Command;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class GuiController {
	@FXML
	Button logButton;
	@FXML
	TextField loginField;
	@FXML
	PasswordField passwordField;
	@FXML
	Label exceprtionLabel;
	private static User user;

	public void pressLogButton(ActionEvent event) {
		if (user == null) {
			Command command = CommandProvider.getInstance().getCommand(1, "Login");
			try {
				user = (User) command.execute(loginField.getText(), passwordField.getText());
				System.out.println(user.getName());// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				loginField.setEditable(false);
				passwordField.setVisible(false);
				logButton.setText("Logout");
				exceprtionLabel.setText("Access level: " + user.getAccessLevel().getName());
			} catch (CommandException e) {
				exceprtionLabel.setText(e.getMessage());
			}
		} else {
			System.out.println(user.getAccessLevel());// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			Command command = CommandProvider.getInstance().getCommand(user.getAccessLevel().getAccessLevelId(),
					"Logout");
			try {
				System.out.println(user.getLogin());// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				user = (User) command.execute("");
				loginField.setText("");
				loginField.setEditable(true);
				passwordField.setText("");
				passwordField.setVisible(true);
				logButton.setText("Login");
				exceprtionLabel.setText("");
			} catch (CommandException e) {
			}
		}
	}
	
	
}
