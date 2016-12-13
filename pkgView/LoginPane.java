package pkgView;

import javafx.beans.binding.BooleanBinding;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/*
 * First window to login details and this should prompt 
 * the user to enter encryption details and if correct should 
 * automatically open up the other information tabs
 */

public class LoginPane extends BorderPane {

	private ComboBox<String> userLevelChoice;
	private TextField userName;
	private final PasswordField passWord;
	private Button loginBtn;

	public LoginPane() {
		
		loginBtn = new Button();
		loginBtn.setPrefSize(100, 20);

		Label lb = new Label("Welcome to Chloe's Database Tool Hire System");
	
		
		HBox lbBox = new HBox();
		lbBox.setAlignment(Pos.BOTTOM_CENTER);

		lb.setPadding(new Insets(10, 10, 50, 10));
		lb.setFont(Font.font("Verdana", 20));

		lb.setAlignment(Pos.CENTER);
		lbBox.setAlignment(Pos.CENTER);
		lbBox.getChildren().add(lb);
		lbBox.setBorder(new Border(new BorderStroke(
		        Color.GRAY, new BorderStrokeStyle(null, null, null, 20, 0, null), 
	            null, null)));

		// styling
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10, 100, 10, 100));
		gridpane.setPrefSize(400, 400);
		// gridpane.setStyle(Font.SERIF);
		gridpane.setVgap(30);
		gridpane.setHgap(50);
		gridpane.setAlignment(Pos.CENTER);

		/** style the buttons only within the gridpane */
		// gridpane.getStylesheets().add(getClass().getResource("buttonStyles.css").toExternalForm());
		// gridpane.getStyleClass().addAll("button");

		// gridpane.setBorder(new Border(new BorderStroke(Color.BROWN,
		// BorderStrokeStyle.SOLID, null, new BorderWidths(20))));
		// gridpane.setStyle("-fx-background-color: #87cefa;");
		// gridpane.setStyle("-fx-background-radius: 50px;");

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
		gridpane.getColumnConstraints().addAll(column0, column1, column2);
		// gridpane.setBorder(new Border(new BorderStroke(Color.,
		// BorderStrokeStyle.DASHED, null, new BorderWidths(2))));

		// create labels
		Label lblUsername = new Label("Username: ");
		Label lblPassword = new Label("Password: ");
		Label userType = new Label("User Level");

		// setup combobox
		ObservableList<String> list = FXCollections.observableArrayList("Manager", "Administrator", "Clerk");
		userLevelChoice = new ComboBox<String>(list);
		userLevelChoice.getSelectionModel().select(0);
		userLevelChoice.setPrefSize(140, 30);

		// setup text fields
		userName = new TextField();
		passWord = new PasswordField();

		userName.setPrefSize(200, 30);
		passWord.setPrefSize(200, 30);

		// initialising create button
		loginBtn = new Button("Login in");

		// adding controls and labels to container

		gridpane.add(lblUsername, 0, 0);
		gridpane.add(userName, 1, 0);

		gridpane.add(lblPassword, 0, 1);
		gridpane.add(passWord, 1, 1);

		gridpane.add(userType, 0, 2);
		gridpane.add(userLevelChoice, 1, 2);

		// gridpane.add(new HBox());
		gridpane.add(loginBtn, 2, 4);

		gridpane.setPrefSize(200, 200);

		HBox box = new HBox();
		box.getChildren().add(gridpane);

		/*
		 * HBox to contain the the png for the login
		 */

		HBox boxContainingPng = new HBox();
		boxContainingPng.setPrefSize(600, 200);
		ImageView image = new ImageView();

		image.setFitWidth(100);
		image.setPreserveRatio(true);

		boxContainingPng.getChildren().add(image);

		// HBox labelContainer = new HBox();
		// labelContainer.getChildren().add(lbBox);

		this.setTop(lbBox);
		this.setCenter(gridpane);

		// this.getChildren().add(gridpane);

		// this.setCenter(gridpane);
		// HBox middleContainer = new HBox();
		// middleContainer.setStyle("-fx-background-color: #87cefa;");
		// middleContainer.setPrefSize(700, 300);
		// middleContainer.setPadding(new Insets(20, 20, 20, 20));
		// middleContainer.getChildren().add(gridpane);

		// middleContainer.setAlignment(Pos.CENTER);
		// middleContainer.setPadding(new Insets(10, 10, 10, 10));
		//

	}

	/**********************************************
	 * 
	 * METHODS TO ATTACH AND BIND EVENT HANDLER
	 * 
	 **********************************************/

	public void AttachLogin_Button_Handler(EventHandler<ActionEvent> handler) {
		loginBtn.setOnAction(handler);
	}

	public void Login_Button_DisableBind(BooleanBinding pty) {
		loginBtn.disableProperty().bind(pty);
	}

	/*
	 * check if any of the TextFields are empty before allowing user to create a
	 * profile. The method's use becomes apparent when its invoked in the
	 * controller.
	 */

	public ComboBox<String> getComboBox() {
		return userLevelChoice;
	}

	public String getSelectedUserLevel() {
		return userLevelChoice.getSelectionModel().getSelectedItem().toString();
	}

	public String getUserName() {
		return userName.getText();
	}

	public void clearUsernameTextField() {
		userName.clear();
	}

	public String getPassWord() {
		return passWord.getText();
	}

	public void clearPasswordTextField() {
		passWord.clear();
	}

	public void RequestTextFieldUsernameReFocus() {
		userName.requestFocus();
	}

	public void RequestTextFieldPasswordReFocus() {
		passWord.requestFocus();
	}

	public Button getLoginBtn() {
		return loginBtn;
	}

}
