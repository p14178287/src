package pkgView.Users;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ResetPane extends GridPane {

	private TextField username;
	private PasswordField newPassword, reEnterNewPassword;
	private Label usernameLabel, passwordLabel, passwordResetLabel, userType;
	private Button resetBtn;
	private ComboBox<String> userLevelChoice;

	public ResetPane() {

		// setup combobox
		ObservableList<String> list = FXCollections.observableArrayList("Manager", "Administrator", "Clerk");
		userLevelChoice = new ComboBox<String>(list);
		userLevelChoice.getSelectionModel().select(0);
		userLevelChoice.setPrefSize(140, 30);

		resetBtn = new Button("Reset Password");

		username = new TextField();
		newPassword = new PasswordField();
		reEnterNewPassword = new PasswordField();
		usernameLabel = new Label("Username");
		passwordLabel = new Label("Password");
		passwordResetLabel = new Label("Re-enter Password");
		userType = new Label("userLevel");
		username.setPrefSize(200, 30);
		newPassword.setPrefSize(200, 30);
		reEnterNewPassword.setPrefSize(200, 30);

		ColumnConstraints column0 = new ColumnConstraints();
		column0.setHalignment(HPos.LEFT); // right aligns all elements in 1st
											// column
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHalignment(HPos.LEFT);
		column2.setHgrow(Priority.ALWAYS); // grows all elements in 2nd column

		// adds the constraints to the GridPane (i.e. this), the first argument
		// applies to the first column, second to the second column, etc
		this.getColumnConstraints().addAll(column0, column1, column2);

		this.add(usernameLabel, 0, 0);
		this.add(username, 1, 0);
		this.add(passwordLabel, 0, 1);
		this.add(newPassword, 1, 1);
		this.add(passwordResetLabel, 0, 2);
		this.add(reEnterNewPassword, 1, 2);
		this.add(userType, 0, 3);
		this.add(userLevelChoice, 1, 3);
		this.add(resetBtn, 1, 4);

		//Style the GridPane
		this.setPrefSize(410, 300);
		this.setVgap(20);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20, 5, 10, 20));
	}

	public void attachResetBtnHandler(EventHandler<ActionEvent> handler) {
		resetBtn.setOnAction(handler);
	}

	public String getUsername() {
		return username.getText();
	}

	public String getUserLevelChoice() {
		return userLevelChoice.getSelectionModel().getSelectedItem().toString();
	}

	public String getNewPassword() {
		return newPassword.getText();
	}

	public String getReEnteredPassword() {
		return reEnterNewPassword.getText();
	}

	public Button getResetBtn() {
		return resetBtn;
	}

}
