package com.epam.library.guicontroller;

import java.util.ArrayList;

import com.epam.library.beans.Book;
import com.epam.library.beans.User;
import com.epam.library.command.exception.CommandException;
import com.epam.library.command.impl.guest.WrongCommand;
import com.epam.library.command.interfaces.Command;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public final class GuiController {
	private static User sessionUser;
	private final CommandProvider commandProvider = CommandProvider.getInstance();
	@FXML
	private Button logButton, editButton, registrationButton, changeBookStatusButtonForAdmins, uploadUsersButton,
			orderButton;
	@FXML
	private TextField loginField, editNameField, editSecondNameField, editLoginField, editAccessLevel;
	@FXML
	private PasswordField passwordField, editPasswordFieldOld, editPasswordField1;
	@FXML
	private Label exceprtionLabel, adminLabel;
	@FXML
	private AnchorPane editAnchorPane;
	@FXML
	private ListView<Book> listView = new ListView<>();
	@FXML
	private ListView<Book> listView1 = new ListView<>();
	@FXML
	private ListView<Book> listView2 = new ListView<>();
	@FXML
	private ListView<Book> listViewUsers = new ListView<>();

	public void pressLogButton(ActionEvent event) {
		if (sessionUser == null) {
			try {
				sessionUser = (User) executeTask("Login" + " " + loginField.getText() + " " + passwordField.getText());
				loginField.setEditable(false);
				passwordField.setVisible(false);
				logButton.setText("Logout");
				editButton.setVisible(true);
				registrationButton.setVisible(false);
				exceprtionLabel.setText("");
				listView.setDisable(false);
				listView1.setVisible(true);
				orderButton.setVisible(true);
				if (sessionUser.getAccessLevel().getAccessLevelId() > 2) {
					listView2.setVisible(true);
					changeBookStatusButtonForAdmins.setVisible(true);
					if (sessionUser.getAccessLevel().getAccessLevelId() == 3) {
						adminLabel.setText("Admin users control panel");
						listView1.setDisable(false);
					} else {
						adminLabel.setText("SuperAdmin users control panel");
						listView1.setDisable(false);
					}
					adminLabel.setVisible(true);
					listViewUsers.setVisible(true);
					uploadUsersButton.setVisible(true);
				}
			} catch (CommandException e) {
				exceprtionLabel.setText(e.getMessage());
			}
		} else {
			try {
				sessionUser = (User) executeTask("Logout");
				editAnchorPane.setVisible(false);
				loginField.setText("");
				loginField.setEditable(true);
				passwordField.setText("");
				passwordField.setVisible(true);
				logButton.setText("Login");
				exceprtionLabel.setText("");
				editButton.setVisible(false);
				registrationButton.setVisible(true);
				exceprtionLabel.setText("");
				listView.setDisable(true);
				listView1.setVisible(false);
				listView2.setVisible(false);
				changeBookStatusButtonForAdmins.setVisible(false);
				adminLabel.setVisible(false);
				listViewUsers.setVisible(false);
				uploadUsersButton.setVisible(false);
				orderButton.setVisible(false);
				listView1.setDisable(true);

			} catch (CommandException e) {
				exceprtionLabel.setText(e.getMessage());
			}
		}
	}

	public void openEditPanel(ActionEvent event) {
		if (editAnchorPane.isVisible()) {
			editAnchorPane.setVisible(false);
			exceprtionLabel.setText("");
		} else {
			editNameField.setText(sessionUser.getName());
			editSecondNameField.setText(sessionUser.getSecondName());
			editLoginField.setText(sessionUser.getLogin());
			editPasswordFieldOld.setText("");
			editPasswordField1.setText("");
			editPasswordField1.setVisible(false);
			editPasswordFieldOld.setVisible(false);
			editAccessLevel.setText(sessionUser.getAccessLevel().getName());
			editAnchorPane.setVisible(true);
			exceprtionLabel.setText("");
		}
	}

	public void openRegistrationPanel(ActionEvent event) {
		if (editAnchorPane.isVisible()) {
			editAnchorPane.setVisible(false);
			logButton.setDisable(false);
			loginField.setDisable(false);
			passwordField.setDisable(false);
			exceprtionLabel.setText("");
		} else {
			editNameField.setText("");
			editSecondNameField.setText("");
			editLoginField.setText("");
			editPasswordFieldOld.setText("");
			editPasswordField1.setText("");
			editPasswordFieldOld.setPromptText("password");
			editPasswordField1.setPromptText("confirm password");
			editPasswordFieldOld.setVisible(true);
			editPasswordField1.setVisible(true);
			editAccessLevel.setText("User");
			editAnchorPane.setVisible(true);
			logButton.setDisable(true);
			loginField.setDisable(true);
			passwordField.setDisable(true);
			exceprtionLabel.setText("");
		}
	}

	public void pressConfirmRegButton(ActionEvent event) {
		if (sessionUser == null) {
			try {
				if (editPasswordFieldOld.getText().equals(editPasswordField1.getText())) {
					sessionUser = (User) executeTask(
							"Registration" + " " + editNameField.getText() + " " + editSecondNameField.getText() + " "
									+ editLoginField.getText() + " " + editPasswordFieldOld.getText());
					editAnchorPane.setVisible(false);
					loginField.setEditable(false);
					passwordField.setVisible(false);
					logButton.setText("Logout");
					editButton.setVisible(true);
					registrationButton.setVisible(false);
					loginField.setText(sessionUser.getLogin());
					logButton.setDisable(false);
					listView.setDisable(false);
					listView1.setVisible(true);
				} else {
					exceprtionLabel.setText("Pay ettension with pass.");
				}
			} catch (CommandException e) {
				exceprtionLabel.setText(e.getMessage());
			}
		} else {
			try {
				sessionUser = (User) executeTask(
						"Update_user_info" + " " + editNameField.getText() + " " + editSecondNameField.getText() + " "
								+ editLoginField.getText() + " " + sessionUser.getUserId());
				editNameField.setText(sessionUser.getName());
				editSecondNameField.setText(sessionUser.getSecondName());
				editLoginField.setText(sessionUser.getLogin());
				exceprtionLabel.setText("Changes have saved.");
				loginField.setText(sessionUser.getLogin());
			} catch (CommandException e) {
				exceprtionLabel.setText(e.getMessage());
			}
		}
	}

	public void uploadLibrary(ActionEvent event) {
		listView.getItems().clear();
		listView.getItems().addAll(uploadBooks());
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Book> uploadBooks() {
		ArrayList<Book> books = new ArrayList<>();
		try {
			books = (ArrayList<Book>) executeTask("View_all_books");
		} catch (CommandException e) {
		}
		return books;
	}

	public Object executeTask(String request) throws CommandException {
		String commandName;
		Command executionCommand;
		int accessLevelId;
		ArrayList<String> requestAfterParse = CommandParser.getInstance().parse(request);
		if (requestAfterParse.size() < 1) {
			return new WrongCommand().execute(request);
		}
		commandName = requestAfterParse.get(0);
		requestAfterParse.remove(0);
		if (sessionUser == null) {
			accessLevelId = 1;
		} else {
			accessLevelId = sessionUser.getAccessLevel().getAccessLevelId();
		}
		executionCommand = commandProvider.getCommand(accessLevelId, commandName);
		String[] stringsArray = new String[requestAfterParse.size()];
		stringsArray = requestAfterParse.toArray(stringsArray);
		return executionCommand.execute(stringsArray);
	}

}
