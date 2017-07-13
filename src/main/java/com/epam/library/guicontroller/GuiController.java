package com.epam.library.guicontroller;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.library.bean.Book;
import com.epam.library.bean.Order;
import com.epam.library.bean.User;
import com.epam.library.command.exception.CommandException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public final class GuiController extends Controller {
	private final static Logger LOG = LogManager.getLogger(GuiController.class.getName());
	@FXML
	private Button logButton, editButton, registrationButton, changeBookStatusButtonForAdmins, uploadUsersButton,
			orderButton, confirmOrderButton, confirmReturn, bunButton, promoteButton;
	@FXML
	private TextField loginField, editNameField, editSecondNameField, editLoginField, editAccessLevel, bookNameField,
			bookAuthorField;
	@FXML
	private PasswordField passwordField, editPasswordFieldOld, editPasswordField1;
	@FXML
	private Label exceprtionLabel, adminLabel, addInfoBookLabel;
	@FXML
	private AnchorPane editAnchorPane, adminButtons, addBooksPanel;
	@FXML
	private ListView<Book> listView = new ListView<>();
	@FXML
	private ListView<Order> listView1 = new ListView<>();
	@FXML
	private ListView<User> listViewUsers = new ListView<>();

	public void pressLogButton(ActionEvent event) {
		try {
			if (sessionUser == null) {
				sessionUser = (User) executeTask("Login" + "|" + loginField.getText() + "|" + passwordField.getText());
				loginField.setEditable(false);
				passwordField.setVisible(false);
				logButton.setText(LabelMessage.LOGOUT.getMessage());
				editButton.setVisible(true);
				registrationButton.setVisible(false);
				exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
				listView.setDisable(false);
				listView1.setVisible(true);
				orderButton.setVisible(true);
				if (sessionUser.getAccessLevel().getAccessLevelId() > userStatusBanned) {
					if (sessionUser.getAccessLevel().getAccessLevelId() == userStatusAdmin) {
						adminLabel.setText(LabelMessage.ADMIN_CONTROL_PANEL.getMessage());
						confirmOrderButton.setVisible(true);
						confirmReturn.setVisible(true);
						adminLabel.setVisible(true);
						listViewUsers.setVisible(true);
						adminButtons.setVisible(true);
						addBooksPanel.setVisible(true);
						changeBookStatusButtonForAdmins.setVisible(true);
						uploadUsersList(event);
					} else if (sessionUser.getAccessLevel().getAccessLevelId() == userStatusSuperAdmin) {
						adminLabel.setText(LabelMessage.SUPERADMIN_CONTROL_PANEL.getMessage());
						adminLabel.setVisible(true);
						confirmOrderButton.setVisible(true);
						confirmReturn.setVisible(true);
						listViewUsers.setVisible(true);
						adminButtons.setVisible(true);
						addBooksPanel.setVisible(true);
						changeBookStatusButtonForAdmins.setVisible(true);
						uploadUsersList(event);
					}
					uploadLibrary(event);
					uploadOrdersList(event);
				}
			} else {
				sessionUser = (User) executeTask("Logout");
				editAnchorPane.setVisible(false);
				loginField.setText(LabelMessage.BLANK.getMessage());
				loginField.setEditable(true);
				passwordField.setText(LabelMessage.BLANK.getMessage());
				passwordField.setVisible(true);
				logButton.setText(LabelMessage.LOGIN.getMessage());
				exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
				editButton.setVisible(false);
				registrationButton.setVisible(true);
				exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
				listView.setDisable(true);
				listView1.setVisible(false);
				changeBookStatusButtonForAdmins.setVisible(false);
				adminLabel.setVisible(false);
				listViewUsers.setVisible(false);
				adminButtons.setVisible(false);
				addBooksPanel.setVisible(false);
				orderButton.setVisible(false);
				confirmOrderButton.setVisible(false);
				confirmReturn.setVisible(false);
			}
		} catch (CommandException e) {
			exceprtionLabel.setText(e.getMessage());
			LOG.log(Level.ERROR, "CommandException", e);
		}
	}

	public void openEditPanel(ActionEvent event) {
		if (editAnchorPane.isVisible()) {
			editAnchorPane.setVisible(false);
			exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
		} else {
			editNameField.setText(sessionUser.getName());
			editSecondNameField.setText(sessionUser.getSecondName());
			editLoginField.setText(sessionUser.getLogin());
			editPasswordFieldOld.setText(LabelMessage.BLANK.getMessage());
			editPasswordField1.setText(LabelMessage.BLANK.getMessage());
			editPasswordField1.setVisible(false);
			editPasswordFieldOld.setVisible(false);
			editAccessLevel.setText(sessionUser.getAccessLevel().getName());
			editAnchorPane.setVisible(true);
			exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
		}
	}

	public void openRegistrationPanel(ActionEvent event) {
		if (editAnchorPane.isVisible()) {
			editAnchorPane.setVisible(false);
			logButton.setDisable(false);
			loginField.setDisable(false);
			passwordField.setDisable(false);
			exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
		} else {
			editNameField.setText(LabelMessage.BLANK.getMessage());
			editSecondNameField.setText(LabelMessage.BLANK.getMessage());
			editLoginField.setText(LabelMessage.BLANK.getMessage());
			editPasswordFieldOld.setText(LabelMessage.BLANK.getMessage());
			editPasswordField1.setText(LabelMessage.BLANK.getMessage());
			editPasswordFieldOld.setVisible(true);
			editPasswordField1.setVisible(true);
			editAccessLevel.setText(LabelMessage.USER.getMessage());
			editAnchorPane.setVisible(true);
			logButton.setDisable(true);
			loginField.setDisable(true);
			passwordField.setDisable(true);
			exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
		}
	}

	public void pressConfirmRegButton(ActionEvent event) {
		try {
			if (sessionUser == null) {
				if (editPasswordFieldOld.getText().equals(editPasswordField1.getText())) {
					sessionUser = (User) executeTask(
							"Registration" + "|" + editNameField.getText() + "|" + editSecondNameField.getText() + "|"
									+ editLoginField.getText() + "|" + editPasswordFieldOld.getText());
					exceprtionLabel.setText(LabelMessage.BLANK.getMessage());
					editAnchorPane.setVisible(false);
					orderButton.setVisible(true);
					loginField.setEditable(false);
					passwordField.setVisible(false);
					logButton.setText(LabelMessage.LOGOUT.getMessage());
					editButton.setVisible(true);
					registrationButton.setVisible(false);
					loginField.setText(sessionUser.getLogin());
					logButton.setDisable(false);
					listView.setDisable(false);
					listView1.setVisible(true);
					uploadLibrary(event);
					uploadOrdersList(event);
				} else {
					exceprtionLabel.setText(LabelMessage.PASSWORD_ETT.getMessage());
				}
			} else {
				sessionUser = (User) executeTask("Update_user_info" + "|" + editNameField.getText() + "|"
						+ editSecondNameField.getText() + "|" + editLoginField.getText() + "|" + sessionUser.getUserId()
						+ "|" + sessionUser.getPassword());
				editNameField.setText(sessionUser.getName());
				editSecondNameField.setText(sessionUser.getSecondName());
				editLoginField.setText(sessionUser.getLogin());
				exceprtionLabel.setText(LabelMessage.Changes_HAVE_SAVED.getMessage());
				loginField.setText(sessionUser.getLogin());
				if (sessionUser.getAccessLevel().getAccessLevelId() > userStatusUser)
					uploadUsersList(event);
				uploadOrdersList(event);

			}
		} catch (CommandException e) {
			exceprtionLabel.setText(e.getMessage());
			LOG.log(Level.ERROR, "CommandException", e);
		}
	}

	public void uploadLibrary(ActionEvent event) {
		listView.getItems().clear();
		listView.getItems().addAll(uploadBooks());
	}

	public void uploadOrdersList(ActionEvent event) {
		listView1.getItems().clear();
		listView1.getItems().addAll(uploadOrders());
	}

	public void uploadUsersList(ActionEvent event) {
		listViewUsers.getItems().clear();
		listViewUsers.getItems().addAll(uploadUsers());
	}

	public void pressChangeBookStatusButton(ActionEvent event) {
		ObservableList<Book> choosenBook;
		choosenBook = listView.getSelectionModel().getSelectedItems();
		Book book = choosenBook.get(0);
		if (book != null) {
			try {
				executeTask(
						"Change_book_status" + "|" + book.getBookStatus().getBookStatusId() + "|" + book.getBookId());
			} catch (CommandException e) {
				LOG.log(Level.ERROR, "CommandException", e);
			}
		}
		uploadLibrary(event);
	}

	public void pressOrderBookButton(ActionEvent event) {
		ObservableList<Book> choosenBook;
		choosenBook = listView.getSelectionModel().getSelectedItems();
		Book book = choosenBook.get(0);
		if (book != null) {
			if (book.getBookStatus().getBookStatusId() == bookStatusAvailable) {
				try {
					executeTask("Order_book" + "|" + sessionUser.getUserId() + "|" + book.getBookId());
					uploadOrdersList(event);
					uploadLibrary(event);
				} catch (CommandException e) {
					LOG.log(Level.ERROR, "CommandException", e);
				}
			}
		}
	}

	public void pressConfirmOrderButton(ActionEvent event) {
		ObservableList<Order> choosenOrder;
		choosenOrder = listView1.getSelectionModel().getSelectedItems();
		Order order = choosenOrder.get(0);
		if (order != null) {
			if (order.getOrderStatus().getOrderStatusId() == orderStatusBooked) {
				try {
					executeTask("CONFIRM_ORDER" + "|" + order.getOrderId());
					uploadLibrary(event);
					uploadOrdersList(event);
				} catch (CommandException e) {
					LOG.log(Level.ERROR, "CommandException", e);
				}
			}
		}
	}

	public void pressConfirmReturnButton(ActionEvent event) {
		ObservableList<Order> choosenOrder;
		choosenOrder = listView1.getSelectionModel().getSelectedItems();
		Order order = choosenOrder.get(0);
		if (order != null) {
			if (order.getOrderStatus().getOrderStatusId() == orderStatusOnHands) {
				try {
					executeTask("Return_ORDER" + "|" + order.getOrderId() + "|" + order.getBook().getBookId());
					uploadLibrary(event);
					uploadOrdersList(event);
				} catch (CommandException e) {
					LOG.log(Level.ERROR, "CommandException", e);
				}
			}
		}
	}

	public void pressBanButton(ActionEvent event) {
		ObservableList<User> choosenUser;
		choosenUser = listViewUsers.getSelectionModel().getSelectedItems();
		User user = choosenUser.get(0);
		if (user != null) {
			if (((sessionUser.getAccessLevel().getAccessLevelId() > userStatusUser)
					& (sessionUser.getAccessLevel().getAccessLevelId() > user.getAccessLevel().getAccessLevelId()))) {
				try {
					executeTask("Ban_user" + "|" + user.getUserId());
				} catch (CommandException e) {
					LOG.log(Level.ERROR, "CommandException", e);
				} finally {
					uploadUsersList(event);
				}
			}
		}
	}

	public void pressPromoteButton(ActionEvent event) {
		ObservableList<User> choosenUser;
		choosenUser = listViewUsers.getSelectionModel().getSelectedItems();
		User user = choosenUser.get(0);
		if (user != null) {
			if (((sessionUser.getAccessLevel().getAccessLevelId() > userStatusUser)
					& (sessionUser.getAccessLevel().getAccessLevelId() > user.getAccessLevel().getAccessLevelId()))) {
				try {
					if (user.getAccessLevel().getAccessLevelId() == userStatusBanned) {
						executeTask("UNBAN_USER" + "|" + user.getUserId());
					} else if ((user.getAccessLevel().getAccessLevelId() == userStatusUser)
							& (sessionUser.getAccessLevel().getAccessLevelId() > userStatusAdmin)) {
						executeTask("GIVE_ADMIN" + "|" + user.getUserId());
					}
				} catch (CommandException e) {
					LOG.log(Level.ERROR, "CommandException", e);
				} finally {
					uploadUsersList(event);
				}
			}
		}
	}

	public void pressAddBook(ActionEvent event) {
		try {
			if ((Boolean) executeTask(
					"Add_book" + "|" + bookNameField.getText() + "|" + bookAuthorField.getText() + "|" + 1)) {
				bookNameField.clear();
				bookAuthorField.clear();
				addInfoBookLabel.setText(LabelMessage.BLANK.getMessage());
				uploadLibrary(event);
			}
		} catch (CommandException e) {
			LOG.log(Level.ERROR, "CommandException", e);
			addInfoBookLabel.setText(e.getMessage());
			bookNameField.clear();
			bookAuthorField.clear();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<User> uploadUsers() {
		ArrayList<User> users = new ArrayList<>();
		try {
			users = (ArrayList<User>) executeTask("View_all_users");
		} catch (CommandException e) {
			LOG.log(Level.ERROR, "CommandException", e);
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Book> uploadBooks() {
		ArrayList<Book> books = new ArrayList<>();
		try {
			books = (ArrayList<Book>) executeTask("View_all_books");
		} catch (CommandException e) {
			LOG.log(Level.ERROR, "CommandException", e);
		}
		return books;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Order> uploadOrders() {
		ArrayList<Order> orders = new ArrayList<>();
		try {
			orders = (ArrayList<Order>) executeTask("View_all_orders");
		} catch (CommandException e) {
			LOG.log(Level.ERROR, "CommandException", e);
		}
		return orders;
	}
}
