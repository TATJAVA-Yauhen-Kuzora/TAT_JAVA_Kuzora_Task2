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
	User user;

	@FXML
	Button logButton;
	@FXML
	TextField loginField;
	@FXML
	PasswordField passwordField;
	@FXML
	Label exceprtionLabel;

	public void pressLogButton(ActionEvent event) {

		if (user == null) {
			Command command = CommandProvider.getInstance().getCommand(1, "Login");

			try {

				user = (User) command.execute(loginField.getText(), passwordField.getText());

				System.out.println(user.getName());

				loginField.setEditable(false);
				passwordField.setVisible(false);
				logButton.setText("Logout");
				exceprtionLabel.setText("");

			} catch (CommandException e) {
				exceprtionLabel.setText(e.getMessage());
			}

		} else {
			loginField.setText("");
			loginField.setEditable(true);
			passwordField.setText("");
			passwordField.setVisible(true);
			logButton.setText("Login");
			exceprtionLabel.setText("");
			user = null;

		}

	}
}
